package com.xoado.wx.wxbean;
/**
* @author 作者
* @version 创建时间：2018年6月19日 下午5:50:49
* 类说明
*/
public enum MsgType {
	
	Text("text"),    
    Image("image"),    
    Music("music"),    
    Video("video"),    
    Voice("voice"),    
    Location("location"),    
    Link("link");    
    private String msgType = "";    
    
    MsgType(String msgType) {    
        this.msgType = msgType;    
    }    
    
    /**  
     * @return the msgType  
     */    
    @Override    
    public String toString() {    
        return msgType;    
    }    

}
