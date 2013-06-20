package com.renren.cocos2dx.generater;

import java.io.File;
import java.io.IOException;

import com.renren.cocos2dx.util.Constants;

public class PkgToLoaderGenerater implements IGenerater {

	private String currentPath;
	private String name;
	private String pkgFile;
	private String loadHFile;
	private String loadCppFile;

	public PkgToLoaderGenerater(String currentPath) {
		File filePre = new File(Constants.loaderPath);
		if(!filePre.isDirectory()){
			filePre.mkdirs();
		}
		this.currentPath = currentPath;
	}

	@Override
	public boolean prepareFilePath(File file) {
		String fileName = file.getName();
		if (!fileName.endsWith(".h")) {
			return false;
		}
		name = fileName.substring(0, fileName.indexOf(".h"));
		pkgFile = Constants.pkgPath + name +".pkg";
		loadHFile = Constants.loaderPath + name + "Load.h";
		loadCppFile = Constants.loaderPath + name + "Load.cpp";
		return true;
	}

	@Override
	public boolean execute() {
		String osName = System.getProperties().getProperty("os.name");
		try {		
			String cmdTolua = "";
			Runtime currentRuntime = Runtime.getRuntime();
			if(osName.equals("Mac OS X")){
				currentRuntime.exec("cd " + currentPath);
				cmdTolua = "./tolua++ -H " + loadHFile + " -o " + loadCppFile
						+ " " + pkgFile;
				currentRuntime.exec(cmdTolua);
			}else{
				currentRuntime.exec("cmd.exe /c d: /all");
				currentRuntime.exec("cmd.exe /c " + "cd " + currentPath + " /all");
				cmdTolua = "tolua++ -H " + loadHFile + " -o " + loadCppFile
						+ " " + pkgFile;
				currentRuntime.exec("cmd.exe /c " + cmdTolua + " /all");
			}
			System.out.println(cmdTolua);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean writeFile() {
		// TODO Auto-generated method stub
		return true;
	}

}
