 package com.xoado.protocol;
/**
* @author 作者
* @version 创建时间：2018年7月23日 上午9:40:56
* 类说明
*/
public enum ArchivesStatus {
	
	temporary(1,"持有状态"),
	ready(2,"准备区状态"),
	person(3,"属于个人"),
	box(4,"属于盒子");
	
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
	
	ArchivesStatus(Integer stauts,String describe){
		this.stauts = stauts;
		this.describe = describe;
	}

}
