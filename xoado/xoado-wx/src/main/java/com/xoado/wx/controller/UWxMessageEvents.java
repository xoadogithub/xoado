package com.xoado.wx.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xoado.wx.common.AesException;
import com.xoado.wx.common.WXBizMsgCrypt;
import com.xoado.wx.service.IWxMessageEvents;




/**
* @author 作者
* @version 创建时间：2018年6月7日 下午2:33:10
* 类说明  消息与事件接收URL
*/
@Controller
@RequestMapping("/Wechat")
public class UWxMessageEvents {
	
	private static final String key = "1234567891234567891234567891234567891234567";
	private static String token = "xoadoToken";
	private static final String AppId = "wxc176ccd385b5465d";
	
	@Autowired
	private IWxMessageEvents iwxMessageEvents;
	
	@RequestMapping(value="/{APPID}/callback",method={RequestMethod.GET,RequestMethod.POST})
	public void wxtest(PrintWriter out,@RequestBody String postData, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{

	        
	
		 boolean isGet = request.getMethod().toLowerCase().equals("get");  
		 PrintWriter print;  
		 if(isGet){
			  // 微信加密签名  
	            String signature = request.getParameter("signature");  
	            // 时间戳  
	            String timestamp = request.getParameter("timestamp");  
	            // 随机数  
	            String nonce = request.getParameter("nonce");  
	            // 随机字符串  
	            String echostr = request.getParameter("echostr");  
	            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {  
	            	 try {  
	                     print = response.getWriter();  
	                     print.write(echostr);  
	                     print.flush();  
	                 } catch (IOException e) {  
	                     e.printStackTrace();  
	                 }  
	            }
	            
		 }else {
			 // 微信加密签名  
	            String msg_signature = request.getParameter("msg_signature");  
	            // 时间戳  
	            String timestamp = request.getParameter("timestamp");  
	            // 随机数  
	            String nonce = request.getParameter("nonce");  
	          
	            try {
					WXBizMsgCrypt pc = new WXBizMsgCrypt(token, key, AppId);
//					对发送过来的消息体进行解密
					String postdata = pc.decryptMsg(msg_signature, timestamp, nonce, postData);

					 String responseMessage = iwxMessageEvents.processRequest(postdata,request);
//					 对发出的消息体进行加密
					 String msg = pc.encryptMsg(responseMessage, timestamp, nonce);
					 
					 System.out.println(msg);
					 out.print(msg);
				     out.flush();
				} catch (AesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		}

	}

	
}
