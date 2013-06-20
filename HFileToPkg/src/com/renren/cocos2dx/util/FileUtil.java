package com.renren.cocos2dx.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	
	/**
	 * read.....
	 * 
	 * @param filePath
	 * @return
	 */
	public static String readFile(String filePath) {
		StringBuffer _sb = new StringBuffer();
		try {
			FileReader fr = new FileReader(filePath);
			int ch = 0;
			while ((ch = fr.read()) != -1) {
				_sb.append((char) ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _sb.toString();
	}

	/**
	 * 写文件
	 * 
	 * @param filePath
	 * @param content
	 */
	public static boolean writeFile(String filePath, String content) {
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(content, 0, content.length());
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
