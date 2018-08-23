package com.xoado.wx.wxbean;
/**
* @author 作者
* @version 创建时间：2018年6月19日 下午7:11:07
* 类说明
*/
public class BaseMessage {
	 /**
     * 开发者微信号
     */
    public String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    public String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    public long CreateTime;
    /**
     * text
     */
    public String MsgType ;
     
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

}
