package com.xoado.wx.wxbean;

import java.io.BufferedReader;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.ConnectException;  
import java.net.URL;  
  
import javax.net.ssl.HttpsURLConnection;  
import javax.net.ssl.SSLContext;  
import javax.net.ssl.SSLSocketFactory;  
import javax.net.ssl.TrustManager;  
  
import net.sf.json.JSONObject;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 

/**
* @author 作者
* @version 创建时间：2018年6月21日 下午7:29:02
* 类说明    创建菜单使用的一个方法
*/
public class WeixinU{
	
	private static Logger log = LoggerFactory.getLogger(WeixinU.class);  
	
	 public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		 
		 	JSONObject jsonObject = null;  
	        StringBuffer buffer = new StringBuffer();
	        try {
	        	 // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
	            TrustManager[] tm = { new MyX509TrustManager() };  
	            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
	            sslContext.init(null, tm, new java.security.SecureRandom());  
	            // 从上述SSLContext对象中得到SSLSocketFactory对象  
	            SSLSocketFactory ssf = sslContext.getSocketFactory();  
	  
	            URL url = new URL(requestUrl);  
	            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
	            httpUrlConn.setSSLSocketFactory(ssf);  
	  
	            httpUrlConn.setDoOutput(true);  
	            httpUrlConn.setDoInput(true);  
	            httpUrlConn.setUseCaches(false);  
	            // 设置请求方式（GET/POST）  
	            httpUrlConn.setRequestMethod(requestMethod);  
	  
	            if ("GET".equalsIgnoreCase(requestMethod))  
	                httpUrlConn.connect();  
	  
	            // 当有数据需要提交时  
	            if (null != outputStr) {  
	                OutputStream outputStream = httpUrlConn.getOutputStream();  
	                // 注意编码格式，防止中文乱码  
	                outputStream.write(outputStr.getBytes("UTF-8"));  
	                outputStream.close();  
	            }  
	  
	            // 将返回的输入流转换成字符串  
	            InputStream inputStream = httpUrlConn.getInputStream();  
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
	  
	            String str = null;  
	            while ((str = bufferedReader.readLine()) != null) {  
	                buffer.append(str);  
	            }  
	            bufferedReader.close();  
	            inputStreamReader.close();  
	            // 释放资源  
	            inputStream.close();  
	            inputStream = null;  
	            httpUrlConn.disconnect();  
	            jsonObject = JSONObject.fromObject(buffer.toString());  
			} catch (ConnectException  e) {
				 log.error("Weixin server connection timed out."); 
			}catch(Exception e){
				log.error("https request error:{}", e);
			}
		return jsonObject;  
		 
	 }
	 public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN"; 
	 
	 public static int createMenu(Menu menu, String accessToken) {  
		 int result = 0;  
		 // 拼装创建菜单的url  
		    String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);  
		    // 将菜单对象转换成json字符串  
		    String jsonMenu = JSONObject.fromObject(menu).toString();  
		    
		    System.out.println("jsonMenu:"+jsonMenu);
		    // 调用接口创建菜单  
		    JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);  
		  
		    if (null != jsonObject) {  
		        if (0 != jsonObject.getInt("errcode")) {  
		            result = jsonObject.getInt("errcode");  
		            log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
		        }  
		    }  
		  
		    return result;  
	 }

}
