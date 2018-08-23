package com.xoado.protocol;
/**
* @author 作者
* @version 创建时间：2018年6月4日 下午4:38:10
* 类说明
*/
public enum Apistatus {

	API_OPEN(1,"开放状态"),
	API_CLOSE(2,"关闭状态");
	
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
	
	Apistatus(Integer stauts,String describe){
		this.stauts = stauts;
		this.describe = describe;
	}

	
}
