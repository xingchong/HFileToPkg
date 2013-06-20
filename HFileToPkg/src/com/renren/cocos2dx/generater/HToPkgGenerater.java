package com.renren.cocos2dx.generater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.renren.cocos2dx.bean.ClazzBean;
import com.renren.cocos2dx.bean.PkgFileBean;
import com.renren.cocos2dx.util.Constants;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HToPkgGenerater implements IGenerater {

	private String currentPath;
	private String name;
	private String hFile;
	private String pkgFile;

	private PkgFileBean pkgFileBean;

	// StringBuilder content;

	public HToPkgGenerater(String currentPath) {
		this.currentPath = currentPath;
	}

	@Override
	public boolean prepareFilePath(File file) {
		File filePre = new File(Constants.pkgPath);
		if(!filePre.isDirectory()){
			filePre.mkdirs();
		}
		name = file.getName();
		if (!name.endsWith(".h")) {
			return false;
		}
		hFile = Constants.hFilePath + name;
		pkgFile = Constants.pkgPath + name.substring(0, name.indexOf(".h"))
				+ ".pkg";

		pkgFileBean = new PkgFileBean();
		return true;
	}

	@Override
	public boolean execute() {
		pkgFileBean.addInclude("$#include \"" + name + "\"");
		try {
			FileReader reader = new FileReader(hFile);
			BufferedReader bfReader = new BufferedReader(reader);
			String text = null;
			int i = 0;
			while ((text = bfReader.readLine()) != null) {
				if (text.trim().startsWith("//")) {
					continue;
				}
				if (text.startsWith("#include")) {
					pkgFileBean.addInclude('$' + text);
					continue;
				}
				if (text.trim().startsWith("class")
						&& text.trim().endsWith(";")) {
					pkgFileBean.addInclude("$#include \""
							+ text.replace("class", "").replace(";", "").trim()
							+ ".h\"");
					continue;
				}
				if (text.trim().startsWith("class")) {
					pkgFileBean.addClazzBean(this
							.buildClazzBean(text, bfReader));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private ClazzBean buildClazzBean(String clazzText, BufferedReader bfReader) throws IOException{
		ClazzBean clazzBean = new ClazzBean();
		StringBuilder nameBuilder = new StringBuilder();
		if(clazzText.contains("{")){
			nameBuilder.append(clazzText.replace("{", ""));
		}else{
			nameBuilder.append(clazzText);
			String tempText;
			while ((tempText = bfReader.readLine()) != null) {
				if (tempText.contains("{")) {
					nameBuilder.append(tempText.replace("{", ""));
					break;
				}
				nameBuilder.append(tempText);
			}
		}
		clazzBean.setName(nameBuilder.toString());//类的名字
//		String clazzName = clazzBean.getName();
//		String include = clazzName.substring(clazzName.indexOf("class")+6);
//		if(include.contains(":")){
//			include = include.substring(0, include.indexOf(":")).trim();
//		}
//		pkgFileBean.addInclude("$#include \"" + include + ".h\"");
		
		String beforeMethodType = "";
		String methodStr;
		while ((methodStr = bfReader.readLine()) != null) {
			if(methodStr.contains("};")){
				break;
			}
			if(isMetodType(methodStr)){
				beforeMethodType = methodStr;
				continue;
			}
			if(isPublic(beforeMethodType)){
				if(isMetodType(methodStr)){
					beforeMethodType = methodStr;
					continue;
				}
				clazzBean.addPublicMethod(methodStr);
			}
		}
		
		
		return clazzBean;
	}
	
	private boolean isMetodType(String methodStr){
		if(isPublic(methodStr)||isProtected(methodStr)||isPrivate(methodStr)){
			return true;
		}
		return false;
	}
	
	private boolean isPublic(String methodStr){
		if(methodStr.contains("public")&&methodStr.contains(":")){
			return true;
		}
		return false;
	}
	
	private boolean isProtected(String methodStr){
		if(methodStr.contains("protected")&&methodStr.contains(":")){
			return true;
		}
		return false;
	}
	
	private boolean isPrivate(String methodStr){
		if(methodStr.contains("private")&&methodStr.contains(":")){
			return true;
		}
		return false;
	}

	@Override
	public boolean writeFile() {
		try {
			Configuration configuration = new Configuration();
			configuration.setDefaultEncoding(Constants.FORMAT);
			configuration.setDirectoryForTemplateLoading(new File(Constants.templatePath));
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			Template template = configuration.getTemplate(Constants.templateOfPkg);
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("pkgFileBean", pkgFileBean);
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pkgFile), Constants.FORMAT));
			template.process(rootMap, writer);
			writer.flush();
			writer.close();
			System.out.println("generate pkg: "+pkgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
