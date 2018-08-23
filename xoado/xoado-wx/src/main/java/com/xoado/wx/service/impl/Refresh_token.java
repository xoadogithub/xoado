package com.xoado.wx.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xoado.client.http.XoadoHttpRemote;

import net.sf.json.JSONObject;

/**
* @author 作者
* @version 创建时间：2018年6月26日 上午11:37:15
* 类说明
*/
public class Refresh_token {
	
	public static Map<String, Object> updateToken(HttpServletRequest request){
		
		String component_access_token = (String)request.getSession().getServletContext().getAttribute("component_access_token");
		
		String url = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token="+component_access_token;
//		获取刷新令牌（数据库）   
//		String authorizer_refresh_token = (String)request.getSession().getServletContext().getAttribute("authorizer_refresh_token");
		String authorizer_refresh_token ="refreshtoken@@@csj4fJaWWfnMNV8jcXg_onME2UWn2frd997lOpjxuXc";
//		组装参数
		JSONObject json = new JSONObject();
		json.put("component_appid", "wxc176ccd385b5465d");
		json.put("authorizer_appid", "wxb0eb37d7c68f0c0d");  //授权方的appid
		json.put("authorizer_refresh_token", authorizer_refresh_token);
		String string = json.toString();
//		发送请求
		Map<String, Object> map = XoadoHttpRemote.Bodysend(url, string);
//		授权方令牌
		String authorizer_access_token = (String)map.get("authorizer_access_token");
		
		request.getSession().getServletContext().setAttribute("authorizer_access_token", authorizer_access_token);
		System.out.println("authorizer_access_token:"+authorizer_access_token);
//		有效期，为2小时
		Object expires_in = map.get("expires_in");
//		刷新令牌
		String authorizer_refresh_token2 = (String)map.get("authorizer_refresh_token");
		System.out.println("第三方刷新token令牌："+authorizer_refresh_token2);
//		保存authorizer_refresh_token2
		return map;
	}

}
