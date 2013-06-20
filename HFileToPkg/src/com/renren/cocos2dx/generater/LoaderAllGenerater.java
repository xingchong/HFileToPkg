package com.renren.cocos2dx.generater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.renren.cocos2dx.util.Constants;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class LoaderAllGenerater implements IGenerater {

	private String currentPath;
	private int hFileNum;
	private int currentNum;
	private String loaderAllFile;
	private List<String> includeNameList;

	public LoaderAllGenerater(String currentPath) {
		File filePre = new File(Constants.loaderAllPath);
		if(!filePre.isDirectory()){
			filePre.mkdirs();
		}
		this.currentPath = currentPath;
		includeNameList = new ArrayList<String>();
		File file = new File(this.currentPath+""+Constants.hFilePath);
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.getName().endsWith(".h")) {
				hFileNum++;
			}
		}
		loaderAllFile = Constants.loaderAllPath+"/"+Constants.loaderAllName+".h";
	}

	@Override
	public boolean prepareFilePath(File file) {
		String name = file.getName();
		if (!name.endsWith(".h")) {
			return false;
		}
		includeNameList.add(name.substring(0, name.indexOf(".h")));
		return true;
	}

	@Override
	public boolean execute() {
		currentNum++;
		if(currentNum==hFileNum){
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
			Template template = configuration.getTemplate(Constants.templateOfLoaderAll);
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("includeNameList", includeNameList);
			rootMap.put("date", (new Date()).toString());
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(loaderAllFile), Constants.FORMAT));
			template.process(rootMap, writer);
			writer.flush();
			writer.close();
			System.out.println("generate loaderAll: "+loaderAllFile);
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
