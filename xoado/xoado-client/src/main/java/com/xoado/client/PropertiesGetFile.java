package com.xoado.client;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;



import com.xoado.protocol.XoadoConstant;



/*
 * 文件读取控制器
 */
public class PropertiesGetFile {
	

	
	private static Map<String, Object> map = new HashMap<>();

	public static Map<String, Object> getMap() {
		return map;
	}

	public static void setMap(Map<String, Object> map) {
		PropertiesGetFile.map = map;
	}
	

	public static void getProperties(){
		
		Properties pro = new Properties();
		
		try {
//			获取发布后文件的相对路径
			String path = PropertiesGetFile.class.getClassLoader().getResource("").getPath();
			FileInputStream in = new FileInputStream(path+XoadoConstant.PROPERTIES);
			

			pro.load(in);
			
			Iterator<String> it = pro.stringPropertyNames().iterator();
			
			
			while(it.hasNext()){
				
				String key = it.next();
				
				String value = pro.getProperty(key);
				
				map.put(key, value);
				
				PropertiesGetFile.getMap().put(key, value);
				
			}
			
		} catch (Exception e) {
			
			System.out.println("file文件出错");
			
		}
		
	}
	


	public static void main(String[] args) {
		
		PropertiesGetFile.getProperties();
		
//		Map<String, Object> map2 = PropertiesGetFile.getMap();
		
		map.get("XOADOAUTHCETERDOMAIN");
		
//		System.out.println(a);
		
	}

}
