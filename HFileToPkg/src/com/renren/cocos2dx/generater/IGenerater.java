package com.renren.cocos2dx.generater;

import java.io.File;

public interface IGenerater {
	
	public boolean prepareFilePath(File file);
	
	public boolean execute();
	
	public boolean writeFile();

}
