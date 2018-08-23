package com.xoado.tools.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.xoado.common.XoadoResult;
import com.xoado.tools.service.SMS;





/*
*
*@author 王文斌 E-mail:snzywwb@sina.cn
*@version 创建时间 2018年3月21日上午11:53:20
*/
@Controller
@RequestMapping("/common")
public class USMS {
	String appid = "160bce83b58e050d5d90c034c980ef42";
	@Autowired
	private SMS sms;
	
//	接收手机号：phonenumber/手机验证码，xoado_message/随机数code
	@RequestMapping(value="/sendsms",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult register_phone_code(String text,String xoado_message,String phoneNumber,String code,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ClientException, InterruptedException{
		try {
			request.setCharacterEncoding("utf-8");

			XoadoResult result = sms.Phone_code(text,xoado_message,phoneNumber, session);
			
			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public void a(HttpServletRequest request){
		request.getSession().setAttribute("", "");
	}

}
