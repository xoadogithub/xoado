package com.xoado.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;



public class HttpsUtil {

	/**
	* 以https方式发送请求并将请求响应内容以String方式返回
	*@param path 请求路径
	* @param method 请求方法
	* @param body 请求数据体
	* @return 请求响应内容转换成字符串信息
	*/
	
	 public static String httpsRequestToString(String path, String method, String body) {
		if (path == null || method ==null) {
		return null;
		}
	  
		String response = null;
		InputStream inputStream =null;
		InputStreamReader inputStreamReader=null;
		BufferedReader bufferedReader= null;
		HttpsURLConnection conn =null;
		
		try {
			SSLContext sslContext=SSLContext.getInstance("SSL", "SunJSSE");
			
			TrustManager[] tm={
				new X509TrustManager() {
					
					@Override
					public X509Certificate[] getAcceptedIssuers() {
						
						return null;
					}
					
					@Override
					public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
						
						
					}
					
					@Override
					public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
						
						
					}
					}
				};
			
			sslContext.init(null, tm, new java.security.SecureRandom());
			
			// 从上面对象中得到SSLSocketFactory
			SSLSocketFactory ssf=sslContext.getSocketFactory();
			
//			System.out.println("请求网址--"+path);
			
			URL url=new URL(path);
			System.out.println("path:"+path);
			
			conn=(HttpsURLConnection) url.openConnection();
			System.out.println("conn:"+conn);
			
			conn.setSSLSocketFactory(ssf);
			System.out.println("conn2:"+conn);
			
			conn.setDoOutput(true);
			
			conn.setDoInput(true);
			
			conn.setUseCaches(false);
			
			// 设置请求方式（get|post）
			conn.setRequestMethod(method);
			
			// 有数据提交时
			if (null != body) {
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(body.getBytes("UTF-8"));
				outputStream.close();
		    }
			
			// 将返回的输入流转换成字符串
			inputStream =conn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer= new StringBuffer();
			
			while((str=bufferedReader.readLine())!=null){
				buffer.append(str);
			}
			
			response=buffer.toString();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(conn!=null){
				conn.disconnect();
			}
			
		  try {
			bufferedReader.close();
		    inputStreamReader.close();
		    inputStream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		}	
		return response;
	 }
	
}
