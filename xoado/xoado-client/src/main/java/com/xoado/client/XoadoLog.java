package com.xoado.client;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xoado.client.http.XoadoHttpRemote;

import com.xoado.common.LogXoado;


public class XoadoLog {
	

	private static XoadoHttpRemote xhr;

	 
	
	 public static void getlog(HttpServletRequest request){

		 String addr = request.getRemoteAddr();
		 String host = request.getRemoteHost();
		 int port = request.getRemotePort();
		 String user = request.getRemoteUser();
		 List<LogXoado> list = new ArrayList<>();
			 LogXoado xoado = new LogXoado();
			 xoado.setHost(host);
			 xoado.setAddr(addr);
			 xoado.setPort(port);
			 xoado.setUser(user);
			 list.add(xoado); 
//			 Object json = JsonUtils.objectToJson(list);
			 
//		 String url = "http://localhost:8081/getlog/log?logxoado="+"132";
			 String url = "http://localhost:8081/getlog/log?addr="+addr+"&host="+host+"&port="+port+"&user="+user;
	
		 xhr =  new XoadoHttpRemote("post", url);
		 xhr.send();
		 
		 
	 }

	 public static void main(String[] args) {
		 /*
		 	logger1.trace("我是logger1，trace");
	       logger1.debug("我是logger1，debug");
	       logger1.info("我是logger1，info");
	       logger1.warn("我是logger1，warn");
	       logger1.error("我是logger1，error");
	       logger1.fatal("我是logger1，fatal");
	       */
		
	}
	

}
