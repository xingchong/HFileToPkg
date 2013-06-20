package com.renren.cocos2dx.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.renren.cocos2dx.util.FileUtil;

public class HToPkgMain {

	public static String hFilePath = "hfile/";
	public static String pkgPath = "pkg/";
	public static String loaderPath = "loader/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder content = new StringBuilder();
		try {
			FileReader reader = new FileReader(hFilePath);
			BufferedReader bfReader = new BufferedReader(reader);
			String text = null;
			int i=0;
			while ((text = bfReader.readLine()) != null) {
				if(text.startsWith("#include")){
					content.append('$'+text+'\n');
					continue;
				}
				if(text.startsWith("class")){
					int pos = 0;
					pos = text.indexOf(":")==-1? text.indexOf("{"):text.indexOf(":");
					String temp = text.substring(text.indexOf("class")+6, pos);
					content.append('$'+temp+'\n');
				}
				
			}

			FileUtil.writeFile(pkgPath, content.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
