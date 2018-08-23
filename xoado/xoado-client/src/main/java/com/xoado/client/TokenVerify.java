package com.xoado.client;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoado.protocol.AccessIdentity;
import com.xoado.protocol.OrganizationStauts;
import com.xoado.protocol.XoadoConstant;
import com.xoado.protocol.XoadoHeader;



public class TokenVerify {
	
	public static AccessIdentity verfiy(HttpServletRequest request,HttpServletResponse response){
		
		AccessIdentity accessIdentity =(AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		
		if(accessIdentity !=null){
			
			return accessIdentity;
		}
//		System.out.println("clien未获取到参数");
		String tokenid = XoadoHeader.getToken(request);
		
		System.out.println("获取到的tokenid："+tokenid);
		
		if(tokenid !=null){
//			System.out.println("token有值，将tokenid作为键在全局中查找token");
			ServletContext context = request.getSession().getServletContext();
//			System.out.println("查看context");

//			XoadoCache xoadocache = (XoadoCache)context.getAttribute(XoadoConstant.XOADOCACHE);

			Object xoado_token = context.getAttribute(tokenid);
			
//			全局中缓存不存在的话，在本地缓存中找找token
			if(xoado_token==null){
//				System.out.println("本地中查找对象:"+tokenid);
				AccessIdentity xoadotoken = XoadoCache.getToken(request,response,tokenid);
//				System.out.println("cilenxoadotoken:"+xoadotoken);
//			将获取到的token存入session
				
				request.getSession().setAttribute(XoadoConstant.XOADOTOKEN, xoadotoken);
				 if(xoadotoken.getUserType().equals(OrganizationStauts.CONTROLLED.getDescribe())){
					 return null;
				 }
				return xoadotoken;
				
			}
			return null;
			
		}
		
		return null;

		
	}

}
