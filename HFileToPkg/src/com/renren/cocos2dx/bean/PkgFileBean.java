package com.renren.cocos2dx.bean;

import java.util.ArrayList;
import java.util.List;

public class PkgFileBean {

	private List<String> includeList;

	private List<ClazzBean> clazzBeanList;
	
	public PkgFileBean(){
		includeList = new ArrayList<String>();
		clazzBeanList = new ArrayList<ClazzBean>();
	}
	
	
	public void addInclude(String include){
		this.includeList.add(include);
	}
	
	public void addClazzBean(ClazzBean clazzBean){
		this.clazzBeanList.add(clazzBean);
	}

	/**
	 * @return the includeList
	 */
	public List<String> getIncludeList() {
		return includeList;
	}

	/**
	 * @param includeList
	 *            the includeList to set
	 */
	public void setIncludeList(List<String> includeList) {
		this.includeList = includeList;
	}

	/**
	 * @return the clazzBeanList
	 */
	public List<ClazzBean> getClazzBeanList() {
		return clazzBeanList;
	}

	/**
	 * @param clazzBeanList
	 *            the clazzBeanList to set
	 */
	public void setClazzBeanList(List<ClazzBean> clazzBeanList) {
		this.clazzBeanList = clazzBeanList;
	}

}
