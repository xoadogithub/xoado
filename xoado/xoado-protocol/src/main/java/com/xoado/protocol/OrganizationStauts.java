package com.xoado.protocol;
/*
*
*@author 王文斌 E-mail:snzywwb@sina.cn
*@version 创建时间 2018年3月29日下午12:04:23
*组织状态枚举定义
*/
public enum OrganizationStauts {
	
	
	NOTVERIFYREALNAME(1,"未实名认证"),
	NORMAL(2,"正常"),
	ABNORMITY(3,"异常"),
	CONTROLLED(4,"受控");
	
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

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	OrganizationStauts(Integer stauts,String describe){
		this.stauts = stauts;
		this.describe = describe;
	}

}
