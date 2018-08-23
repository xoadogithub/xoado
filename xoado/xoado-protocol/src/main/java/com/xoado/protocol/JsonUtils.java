package com.xoado.protocol;

import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
*
*@author 王文斌 E-mail:snzywwb@sina.cn
*@version 创建时间 2018年3月23日下午3:01:44
*/
public class JsonUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	
//	对象转json
	public static String objectToJson(Object data){
		try {
			String valueAsString = mapper.writeValueAsString(data);
			return  valueAsString;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//	json转对象
	public static <T> T jsonToPojo(String jsonData,Class<T> beanType){
		try {
			T t = mapper.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//	json转list
	public static <T>List<T> jsonToList(String jsonData,Class<T> beanType){
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = mapper.readValue(jsonData, javaType);
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

}
