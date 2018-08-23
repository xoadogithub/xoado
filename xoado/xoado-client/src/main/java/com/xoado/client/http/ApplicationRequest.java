package com.xoado.client.http;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoado.client.PropertiesGetFile;
import com.xoado.protocol.AccessIdentity;

import com.xoado.protocol.XoadoConstant;





public class ApplicationRequest {
	
	private static XoadoHttpRemote xhr;
	
	static Object host = "";

	public static AccessIdentity gettoken(HttpServletRequest request,HttpServletResponse response, String tokenid) {
//		System.out.println("client-tokenid="+tokenid);
//		获取到tokenid
		if(tokenid!=null){
//		去认证中心	post  http://localhost:8080
			host = PropertiesGetFile.getMap().get("XOADOAUTHCETERDOMAIN");
			String url = host+"/usercode/gettoken?tokenid="+tokenid;
			System.out.println("url:"+url);
//		System.out.println("url:"+url);
			xhr= new XoadoHttpRemote("post", url);
//		获取app之间存的code
			String code = (String)request.getSession().getAttribute(XoadoConstant.LOCALAPPCODE);
//		存入头文件中
//			System.out.println("将code存入header");
			xhr.setHeader(request, response, code);
//		将参数打包
//			String parmer = (String)tokenid;	
			String token = xhr.send();
				System.out.println("apptoken:"+token);
			if(token!=null){
//				System.out.println("token="+token);
				
				AccessIdentity accessIdentity = AccessIdentity.add(token);
				
				return accessIdentity;
			}
			return null;	
		}
		return null;
		
}
	
	public static String headerbeat(String code,String appid){
		
		host = PropertiesGetFile.getMap().get("XOADOAUTHCETERDOMAIN");
		
		if(code!=null){

			String url = host+"/usercode/setcode?code="+code+"&appid="+appid;
			
//			System.out.println("url:"+url);
			
			xhr= new XoadoHttpRemote("post", url);
			
			String send = xhr.send();
			
//			System.out.println("send:"+send);
			
			return send;
			
		} else{
			
			String url = host+"/usercode/getcode?appid="+appid;
			
			xhr= new XoadoHttpRemote("post", url);
			
			xhr.send();
//			System.out.println("send2:"+send);
			
			return "";
			
		}
	
		
}
	
	
	
	public static Object access(HttpServletRequest request,HttpServletResponse response,Object body,String url,String appid,String parmer,String method){
		
		if(appid!=null){
			
			xhr = new XoadoHttpRemote(method, url);
			
			String code = (String) request.getSession().getAttribute(XoadoConstant.LOCALAPPCODE);
			
			xhr.setHeader(request,response, code);
			
			return xhr.send();
			
		}
		
		return method;
		
	}

}
