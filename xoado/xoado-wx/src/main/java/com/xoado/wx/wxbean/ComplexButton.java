package com.xoado.wx.wxbean;
/**
* @author 作者
* @version 创建时间：2018年6月20日 下午3:42:35
* 类说明   父菜单类
*/
public class ComplexButton extends Button{
	
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}  
	
	

}
