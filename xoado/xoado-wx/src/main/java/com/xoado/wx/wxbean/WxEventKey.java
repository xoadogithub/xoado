package com.xoado.wx.wxbean;
/**
* @author 作者
* @version 创建时间：2018年6月22日 上午11:57:39
* 类说明
*/
public class WxEventKey {
//	点击菜单跳转链接时的事件推送
	private String ToUserName;
	
	private String FromUserName;
	
	private long CreateTime;
	
	private String MsgType;
	
	private String Event;
	
	private String EventKey;
	
	private String MenuId;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getMenuId() {
		return MenuId;
	}

	public void setMenuId(String menuId) {
		MenuId = menuId;
	}
	
	

}
