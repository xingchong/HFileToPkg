package com.renren.cocos2dx.bean;

import java.util.ArrayList;
import java.util.List;

public class ClazzBean {

	private String name;
	private List<String> publicMethodList;

	public ClazzBean(){
		publicMethodList = new ArrayList<String>();
	}
	
	public void addPublicMethod(String publicMethod){
		this.publicMethodList.add(publicMethod);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the publicMethodList
	 */
	public List<String> getPublicMethodList() {
		return publicMethodList;
	}

	/**
	 * @param publicMethodList
	 *            the publicMethodList to set
	 */
	public void setPublicMethodList(List<String> publicMethodList) {
		this.publicMethodList = publicMethodList;
	}

}
