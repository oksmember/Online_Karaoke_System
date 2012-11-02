package com.klok.base.action;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public static final String DYNAMIC = "dynamic";
	
	public static final String MYREDIRCT = "myredirect";
	
	protected String dynamicUrl;
	
	public String getDynamicUrl() {
		return dynamicUrl;
	}

	public void setDynamicUrl(String dynamicUrl) {
		this.dynamicUrl = dynamicUrl;
	}
}
