package com.xoado.protocol;

import com.fasterxml.jackson.annotation.JsonValue;

/**
* @author 作者
* @version 创建时间：2018年7月10日 上午10:19:26
* 类说明
*/
public enum OrganizeType {

	COPARTNER(1,"合伙"),
	ENTERPRISE(2,"企业"),
	SOCIALGROUPS(3,"社团");
	
	private Integer stauts;
	
	private String describe;

	public Integer getStauts() {
		return stauts;
	}

	public void setStauts(Integer stauts) {
		this.stauts = stauts;
	}

	public String getDescribe() {
		return describe;
	}
	@JsonValue
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	OrganizeType(Integer stauts,String describe){
		this.stauts = stauts;
		this.describe = describe;
	}
}
