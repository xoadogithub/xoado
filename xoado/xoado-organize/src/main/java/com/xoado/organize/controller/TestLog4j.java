package com.xoado.organize.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSONObject;
import com.xoado.client.XoadoLog;
import com.xoado.common.XoadoResult;
import com.xoado.protocol.OrganizeType;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("log")
public class TestLog4j {
	
	 private static  final Logger logger1 = Logger.getLogger(TestLog4j.class.getName()); 
 
	 
	 public static void main2(String[] args) {  
		   logger1.trace("我是logger1，trace");
	       logger1.debug("我是logger1，debug");
	       logger1.info("我是logger1，info");
	       logger1.warn("我是logger1，warn");
	       logger1.error("我是logger1，error");
	       logger1.fatal("我是logger1，fatal");
	      
	    }  
	 
	 
	 @RequestMapping("log")
	 @ResponseBody
	 public void log(HttpServletRequest request) throws UnknownHostException{

		 XoadoLog.getlog(request);

	 }
	 @RequestMapping("/test/{id}")
	 @ResponseBody
	 public XoadoResult test(@PathVariable("id") String id){
		 System.out.println(id);
		return XoadoResult.build(200, id);
		 
	 }

	 
	 @RequestMapping(value={"/test1","{abc}"})
	 @ResponseBody
	 public void a(@PathVariable String abc){
		 System.out.println(abc);
	 }
	
	 @RequestMapping("/a")
	 @ResponseBody
	 public String enumsele(){
		
		JSONArray array = new JSONArray();
		for (OrganizeType e : OrganizeType.values()) {
			if(e.getStauts().equals(2)){
				String string = e.getDescribe();
				System.out.println(string);
				
				return e.getDescribe();
			}
			JSONObject object = new JSONObject();
			object.put("typeId", e.getStauts());
            object.put("typeName", e.getDescribe());
            array.add(object);
		}
		return array.toString();
		 
	 }

	
}
