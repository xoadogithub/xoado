package com.xoado.wx.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xoado.wx.service.IAuthorizationProcess;
import com.xoado.wx.service.impl.AuthorizationProcess;
import com.xoado.wx.service.impl.Refresh_token;

/**
* @author 作者
* @version 创建时间：2018年6月26日 下午2:20:41
* 类说明
*/
@Controller
@RequestMapping("/weixin")
public class CAuthorizationProcess {
	
	@Autowired
	private IAuthorizationProcess authorizationProcess;
	
//	接收票据
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	@ResponseBody
	public String GetComponent_verify_ticket(@RequestParam("timestamp") String timestamp, //时间戳
			@RequestParam("nonce") String nonce,  //随机数
			@RequestParam("encrypt_type") String encrypt_type,
			@RequestParam("msg_signature") String msg_signature,
			@RequestBody String postData, //密文
			HttpServletRequest request) throws Exception{
		
			authorizationProcess.GetComponent_verify_ticket(postData, timestamp, nonce, msg_signature, request);
		
			return "success";	
	}
//	获取commponent_access_token
	@RequestMapping("/token")
	@ResponseBody
	public Map<String, Object> GetComponent_access_token(@RequestParam("WX3_app_id") String WX3_app_id, HttpServletRequest request) throws Exception {
		
		Map<String, Object> map = authorizationProcess.GetComponent_access_token(WX3_app_id, request);
		
		return map;
		
	}
//	刷新第三方平台commponent_access_token
	@RequestMapping("/updatetoken")
	@ResponseBody
	public Object update(HttpServletRequest request){
		
		Map<String, Object> map = Refresh_token.updateToken(request);
		
		return map;
	}
//	管理员网页授权
	@RequestMapping("/MSGAPP")
	public ModelAndView page_authorization(@RequestParam("WX3_app_id") String WX3_app_id, HttpServletRequest request) {
		ModelAndView view = authorizationProcess.page_authorization(WX3_app_id, request);
		return view;
	}
//	管理员网页授权回调接口
	@RequestMapping("/getauthorization_code")
	public void get_auth_code(@RequestParam("auth_code") String auth_code,@RequestParam("expires_in") String expires_in, HttpServletRequest request) {
		authorizationProcess.get_auth_code(auth_code, expires_in, request);
	}
	
//	用户授权
	@RequestMapping("/reqcode")
	public ModelAndView user_authorization(HttpServletRequest request) {
		ModelAndView view = authorizationProcess.user_authorization(request);
		return view;
	}
	
	
//	用户授权回调
	@RequestMapping("/getcode")
	public String getcode(@RequestParam("code") String code,@RequestParam("state") String state,@RequestParam("appid") String appid,HttpServletRequest request){
		authorizationProcess.getCode(code, state, appid, request);
		return "wxuser";
	}
//	用户刷新toke
	public static Object updateAccess_token(HttpServletRequest request){
		Object access_token = AuthorizationProcess.updateAccess_token(request);
		return access_token;
		
	}
	


		
}
