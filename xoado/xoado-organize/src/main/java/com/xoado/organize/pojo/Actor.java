package com.xoado.organize.pojo;

import java.util.List;
import java.util.Map;

public class Actor {
	
	private String appid;
	
	private List<Map> modules;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public List<Map> getModules() {
		return modules;
	}

	public void setModules(List<Map> modules) {
		this.modules = modules;
	}

}
