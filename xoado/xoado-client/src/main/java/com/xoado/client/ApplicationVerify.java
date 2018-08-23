package com.xoado.client;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoado.client.http.ApplicationRequest;

public class ApplicationVerify {
	
	public static boolean getcode(HttpServletRequest request,HttpServletResponse response,String appid,String url,String method,String code,String parmer){
		/*
		 *  ServletContext   sc
		 *  
		 */
		
	
//	首先获取访问源的code
//		String code = ApplicationRequest.headerbeat(null, appid);	
//	发起访问，第三方应用需要判断访问源
		ApplicationRequest.access(request,response, code, url, appid, parmer, method);
		XoadoCache.getcode(request, response,code, method, parmer, appid, url);
		return true;
		
	}

}
