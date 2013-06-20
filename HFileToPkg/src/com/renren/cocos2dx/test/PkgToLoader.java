package com.renren.cocos2dx.test;

import java.io.File;
import java.io.IOException;



public class PkgToLoader {
	public static String hFilePath = "hfile/";
	public static String pkgPath = "pkg/";
	public static String loaderPath = "loader/";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = PkgToLoader.class.getResource("/").getPath();
		path = path.substring(1, path.length()-4);
		File files = new File(pkgPath);
		for (File file : files.listFiles()) {
			String name  = file.getName();
			String pkgFile = pkgPath+name;
			String loadHFile  = loaderPath+name.substring(0, name.indexOf("pkg")-1)+"Load.h";
			String loadCppFile  = loaderPath+name.substring(0, name.indexOf("pkg")-1)+"Load.cpp";
			Runtime  currentRuntime =  Runtime.getRuntime();
			currentRuntime.exec("cmd.exe /c d: /all");
			currentRuntime.exec("cmd.exe /c "+"cd "+path+" /all");
			String cmdTolua = "tolua++ -H "+loadHFile+" -o "+loadCppFile+" "+pkgFile;
			currentRuntime.exec("cmd.exe /c "+cmdTolua+" /all");
			System.out.println(cmdTolua);
		}
	}

}
