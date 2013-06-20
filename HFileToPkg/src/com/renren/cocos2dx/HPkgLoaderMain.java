package com.renren.cocos2dx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.renren.cocos2dx.generater.HToPkgGenerater;
import com.renren.cocos2dx.generater.IGenerater;
import com.renren.cocos2dx.generater.LoaderAllGenerater;
import com.renren.cocos2dx.generater.PkgToLoaderGenerater;
import com.renren.cocos2dx.test.PkgToLoader;
import com.renren.cocos2dx.util.Constants;

public class HPkgLoaderMain {
	
	private List<IGenerater> generaterList = new ArrayList<IGenerater>();
	
	public void init(String path ){
		generaterList.add(new HToPkgGenerater(path));
		generaterList.add(new PkgToLoaderGenerater(path));
		generaterList.add(new LoaderAllGenerater(path));
	}
	
	
	/**
	 * @return the generaterList
	 */
	public List<IGenerater> getGeneraterList() {
		return generaterList;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = PkgToLoader.class.getResource("/").getPath();
		path = path.substring(0, path.length()-4);
		HPkgLoaderMain hPkgLoaderMain = new HPkgLoaderMain();
		hPkgLoaderMain.init(path);//初始化
		File files = new File(Constants.hFilePath);
		for (File file : files.listFiles()) {
			for (IGenerater generater:hPkgLoaderMain.getGeneraterList()) {
				if(generater.prepareFilePath(file)){
					if(generater.execute()){
						generater.writeFile();
					}
				}
			}
		}
		System.out.println("\rsucess...");
	}

}
