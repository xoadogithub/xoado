package com.xoado.authcenter.controller.users;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("getlog")
public class XoadoGetLog {
	/**
	 private static  final Logger logger1 = Logger.getLogger(XoadoGetLog.class.getName()); 
	
	@RequestMapping(value="log",method=RequestMethod.POST)
	public void log(String addr,String host,int port,String user){
//		System.out.println(addr);
//		System.out.println(host);
//		System.out.println(port);
//		System.out.println(user);
		logger1.info("ip:"+host+";端口:"+port+";隐藏ip："+addr+";用户："+user);
		
		
		/*
		List<LogXoado> list = JsonUtils.jsonToList((String)logxoado, LogXoado.class);
		for (LogXoado logXoado2 : list) {
			System.out.println(logXoado2.toString());
		}
		
		
	}
	
	**/
	
	
	public static void main(String[] args) {
//		aaaaaaaaaaaaaaaaaaaaaaaaaaaa
	}
}
