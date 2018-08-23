package com.xoado.wx.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import com.xoado.client.http.XoadoHttpRemote;

import com.xoado.wx.common.MessageUtil;
import com.xoado.wx.service.IWxMessageEvents;
import com.xoado.wx.wxbean.TextMessage;
import com.xoado.wx.wxbean.WxEventKey;

import net.sf.json.JSONObject;

/**
* @author 作者
* @version 创建时间：2018年6月19日 下午6:45:15
* 类说明
*/
@Service
public class WxMessageEvents implements IWxMessageEvents{

	 public String processRequest(String postData,HttpServletRequest request) throws UnsupportedEncodingException {
		 
		 String respMessage = null; 
		 
		 Map<String, String> map = new HashMap<String, String>();
		 try {
			 DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			 InputStream stream = new ByteArrayInputStream(postData.getBytes("UTF-8"));
			 Document doc = documentBuilder.parse(stream);
			 doc.getDocumentElement().normalize();
			 NodeList nodeList = doc.getDocumentElement().getChildNodes();
			 for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				 Node node = nodeList.item(idx);
				 if (node.getNodeType() == Node.ELEMENT_NODE) {
					 Element element = (Element) node;
					 map.put(element.getNodeName(), element.getTextContent());
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 String respContent = "请求处理异常，请稍候尝试！";  
		 // 发送方帐号（open_id）  
         String fromUserName = map.get("FromUserName");  
         // 公众帐号  
         String toUserName = map.get("ToUserName");  
         // 消息类型  
         String msgType = map.get("MsgType"); 
         String CreateTime = map.get("CreateTime");
         String MsgId = map.get("MsgId");
         String Recognition = map.get("Recognition");
         String MediaId = map.get("MediaId");
         String Format = map.get("Format");
         String PicUrl = map.get("PicUrl");
 
         // 回复文本消息  
         TextMessage textMessage = new TextMessage();  
         textMessage.setToUserName(fromUserName);  
         textMessage.setFromUserName(toUserName);  
         textMessage.setCreateTime(new Date().getTime());  
         textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
         
         // 文本消息  
         if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
             respContent = "您发送的是文本消息！";  
         }  
         // 图片消息  
         else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
             respContent = "您发送的是一张图片：！"+PicUrl;  
         }  
         // 地理位置消息  
         else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
             respContent = "您发送的是地理位置消息！";  
         }  
         // 链接消息  
         else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
             respContent = "您发送的是链接消息！";  
         }  
         // 音频消息  
         else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
        	
        	String jsonString = WxMessageEvents.search(Recognition,request);
             respContent = "您发送的是音频消息！:"+Recognition+"----语义分析结果："+jsonString;  
         }  
         // 事件推送  
         else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
             // 事件类型  
             String eventType = map.get("Event");  
             // 订阅  
             if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                 respContent = "谢谢您的关注！";  
             }  
             // 取消订阅  
             else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                 // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
             }  
             // 自定义菜单点击事件  
             else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                 // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                 String eventKey = map.get("EventKey");  

                 if (eventKey.equals("11")) {  
                	 WxEventKey wxEventKey = new WxEventKey();
                	 wxEventKey.setToUserName(toUserName);
                	 wxEventKey.setFromUserName(fromUserName);
                	 wxEventKey.setCreateTime(System.currentTimeMillis());
                	 wxEventKey.setMsgType("eventKey");
                	 wxEventKey.setEvent("VIEW");
                	 wxEventKey.setEventKey("www.baidu.com");
                	 wxEventKey.setMenuId(MsgId);
                	  
                     respContent = "天气预报菜单项被点击！";  
                 } else if (eventKey.equals("12")) {  
                     respContent = "公交查询菜单项被点击！";  
                 } else if (eventKey.equals("13")) {  
                     respContent = "周边搜索菜单项被点击！";  
                 } else if (eventKey.equals("14")) {  
                     respContent = "历史上的今天菜单项被点击！";  
                 } else if (eventKey.equals("21")) {  
                     respContent = "歌曲点播菜单项被点击！";  
                 } else if (eventKey.equals("22")) {  
                     respContent = "经典游戏菜单项被点击！";  
                 } else if (eventKey.equals("23")) {  
                     respContent = "美女电台菜单项被点击！";  
                 } else if (eventKey.equals("24")) {  
                     respContent = "人脸识别菜单项被点击！";  
                 } else if (eventKey.equals("25")) {  
                     respContent = "聊天唠嗑菜单项被点击！";  
                 } else if (eventKey.equals("31")) {  
                     respContent = "Q友圈菜单项被点击！";  
                 } else if (eventKey.equals("32")) {  
                     respContent = "电影排行榜菜单项被点击！";  
                 } else if (eventKey.equals("33")) {  
                     respContent = "幽默笑话菜单项被点击！";  
                 }  
             }  
         }  

         textMessage.setContent(respContent);  
         respMessage = MessageUtil.textMessageToXml(textMessage); 
         return respMessage; 
        
		
	 }
//	语义理解 http请求方式: POST（请使用https协议）
	 public static String search(String Recognition,HttpServletRequest request) throws UnsupportedEncodingException{
		 
		request.setCharacterEncoding("utf-8");
		
		 String appid_access_token = (String)request.getSession().getServletContext().getAttribute("appid_access_token");
		 
		 String url = "https://api.weixin.qq.com/semantic/semproxy/search?access_token="+appid_access_token;
		 
		 String Myopenid = (String)request.getSession().getServletContext().getAttribute("Myopenid");
		 
		 JSONObject json = new JSONObject();
		 json.put("query", Recognition);
		 json.put("city", "西安");
		 json.put("category", "flight,hotel");
		 json.put("appid", "wxb0eb37d7c68f0c0d");   //公众号唯一标识，用于区分公众号开发者
		 json.put("uid", Myopenid);

		 String string = json.toString();
		 HashMap<String,Object> map = new HashMap<>();
		 String jsonString = XoadoHttpRemote.dopost(url, string);
	
		return jsonString;
	 }
}
