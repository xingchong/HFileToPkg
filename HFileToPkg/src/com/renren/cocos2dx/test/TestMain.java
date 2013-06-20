package com.renren.cocos2dx.test;

import java.io.File;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/xingchong/Documents/fighting/sg4/workspace/HFileToPkg/hfile/");
		File[] files = file.listFiles();
		for(File file2:files){
			String fileName = file2.getName();
			System.out.println("fileName="+fileName);
		}
		
		
	}

}
