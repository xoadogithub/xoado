package com.xoado.wx.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

/**
* @author 作者
* @version 创建时间：2018年6月26日 上午10:08:25
* 类说明  授权流程
*/
public interface IAuthorizationProcess {
/**
 * 
 * @param postData    密文
 * @param timestamp		时间戳
 * @param nonce			随机数
 * @param msg_signature  
 * @param request
 * @return      默认返回success   
 * @throws Exception
 * 获取票据
 */
	String GetComponent_verify_ticket(String postData, String timestamp,String nonce,String msg_signature,HttpServletRequest request ) throws Exception;
/**
 * 
 * @param AppId   第三方平台的的appid
 * @param request
 * @return
 * @throws Exception
 * 获取第三方平台component_access_token
 */
	Map<String, Object> GetComponent_access_token(String WX3_app_id,HttpServletRequest request) throws Exception;
	
	
/**
 * 微信管理员发起接口授权，权限集网页授权
 */
	ModelAndView page_authorization(String WX3_app_id,HttpServletRequest request);
/**
 * 
 * @param auth_code  管理员发起网页授权，微信回调返回授权码
 * @param expires_in  过期时间
 * @param request
 * @return
 */
	void get_auth_code(String auth_code,String expires_in,HttpServletRequest request);
/**
 * 用户授权
 */
	ModelAndView user_authorization(HttpServletRequest request);
/**
 * 
 * @param code  填写第一步获取的code参数
 * @param state	
 * @param appid	公众号的appid
 * @param request
 * @return
 */
	void getCode(String code,String state, String appid,HttpServletRequest request);
	

}
