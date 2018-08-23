package com.xoado.protocol;
/**
* @author 作者
* @version 创建时间：2018年7月27日 上午10:49:52
* 类说明
*/
public enum HandoverType {
	
	direct(0,"直接交接"),
	
	express(1,"发送快递"),
	
	putinbox(2,"放入档案柜"),
	
	takeoutfrombox(3,"档案柜取出"),
	
	complete(4,"交接完成"),
	
	expressing(5,"交接中");
	
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
	
	HandoverType(Integer stauts,String describe ){
		this.stauts=stauts;
		this.describe=describe;
	}

}
