package com.xoado.protocol;

import javax.servlet.http.HttpServletRequest;


public class XoadoHeader {

	
	 public static String getToken(HttpServletRequest request) {

	      String tokenid = GetTokenId.gettokenid(request);
    
	      return tokenid;
	   }


}
