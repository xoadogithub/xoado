package com.xoado.wx.wxbean;
/**
* @author 作者
* @version 创建时间：2018年6月20日 下午3:41:40
* 类说明   普通按钮
*/
public class CommonButton extends Button{
	/**
	 * type=
	 * key： 根据设的ley进行操作
	 */
	
	private String type;  
	
    private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}  
    
    

}
