package com.xoado.protocol;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GetTokenId {
	
	public static String gettokenid(HttpServletRequest request){
		


		Cookie[] cookies = request.getCookies();
		
		Map<String,Object> map = new HashMap<>();
		
		if(cookies!=null){
			
			for (Cookie cookie : cookies) {
				
				map.put(cookie.getName(), cookie.getValue());
				
			}			
			return (String)map.get("tokenid");				
		}
		
		String tokenid = request.getHeader("tokenid");
		
		if(tokenid==null){
			
			return "";
					 
		}
		return tokenid;
		
	}

}
