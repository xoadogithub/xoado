package com.xoado.client.http;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

import com.xoado.protocol.XoadoConstant;





public class XoadoHttpRemote {
	
//	private static final String get = "GET";
//	
//	private static final String post = "POST";
//
//	private static final String put = "PUT";
	
//	public HttpClients clients;
	
	private HttpUriRequest request;
	
	public HttpUriRequest getRequest() {
		return request;
	}

	public void setRequest(HttpUriRequest request) {
		this.request = request;
	}

	public XoadoHttpRemote (String method,String url){
		
//		 CloseableHttpClient httpClient = HttpClients.createDefault();
		
		try {
			
			if(method =="post"){
				
				request = new HttpPost(url);

				
			}else if(method == "get"){
				
				request = new HttpGet(url);
				
				
			}else if(method =="put"){
				
				request= new HttpPut(url);
				
			}
			
		} catch (Exception e) {
		
		}
		
	
	}
	
	public  void setHeader(HttpServletRequest request,HttpServletResponse response,String code){

		
		response.setHeader(XoadoConstant.LOCALAPPCODE, code);
		

	}

	public String send(){
		
		String token = ""; 
		
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		
		try {
			
//			request = new HttpPost("http://localhost:8085/a/c?tokenid=123456789");
//			HttpUriRequest name = this.getRequest();
			
			CloseableHttpResponse response = httpClient.execute(request);
			
			
			HttpEntity entity = response.getEntity();
			
			if(entity!=null){
	
				token = EntityUtils.toString(entity, "UTF-8");
				
				System.out.println("打印："+token);
				response.close();
				
				return token;
			}
			
		} catch (Exception e) {
			return token;
		}
		
		return token;
		
	}
	public static Map<String,Object> Bodysend(String url,String jsonparam){
		
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		
		 HttpPost post = new HttpPost(url);
		 
		 try {
			
			 StringEntity s = new StringEntity(jsonparam);
			 s.setContentEncoding("UTF-8");
//			 s.setContentType("text/html;charset=UTF-8");//发送json数据需要设置contentType
			 s.setContentType("application/json");
			 post.setEntity(s);
			 HttpResponse res = httpclient.execute(post);
			
			 if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				 String result = EntityUtils.toString(res.getEntity());// 返回json格式：
				 System.out.println("result:"+result);
				 
				 Map<String,Object> map = JSON.parseObject(result);
				 return map;
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		return null;
		
	}
	
	
	/**
	 * httpclient  发送post请求，问题：使用类的上一个方法  发回来的数据为乱码，这个方法解决乱码问题，  
	 * 应该封装http发送方法，解决各个问题
	 * 
	 */
	private static RequestConfig requestConfig; 
	public static String dopost(String url,String jsonparam){
		 CloseableHttpClient httpClient = HttpClients.createDefault();  
		  String httpStr = null;  
	        HttpPost httpPost = new HttpPost(url); 

	        CloseableHttpResponse response = null;
	        try {
	        	 httpPost.setConfig(requestConfig);  
	        	 StringEntity stringEntity = new StringEntity(jsonparam.toString(),"UTF-8");//解决中文乱码问题  
	        	  stringEntity.setContentEncoding("UTF-8");  
	              stringEntity.setContentType("application/json");  
	              httpPost.setEntity(stringEntity);  
	              response = httpClient.execute(httpPost);  
	              HttpEntity entity = response.getEntity();  
	              System.out.println(response.getStatusLine().getStatusCode());  
	              httpStr = EntityUtils.toString(entity, "UTF-8");  
			} catch (Exception e) {
				 e.printStackTrace();  
			}finally {
				if(response != null){
					try {
						 EntityUtils.consume(response.getEntity());  
					} catch (Exception e) {
						 e.printStackTrace();  
					}
				}
			}
	        System.out.println("httpStr:"+httpStr);
			return httpStr;
		
	}
	
	/**
	 * 
	 * @param url
	 * @param json
	 * @param map
	 * @return
	 * 扫描文本
	 */
	public static String xoadoDopost(String url,String json,Map<String, String> map){
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		 HttpPost post = new HttpPost(url);
		 
		 try {
			
			 StringEntity s = new StringEntity(json);
			 s.setContentEncoding("UTF-8");
			 s.setContentType("application/json");
			 post.setEntity(s);
			 for (Map.Entry<String, String> e : map.entrySet()) {
				 post.addHeader(e.getKey(), e.getValue());
		        }

			
			 HttpResponse res = httpClient.execute(post);
			
			 if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				 String result = EntityUtils.toString(res.getEntity());// 返回json格式：

//				 Map<String, Object> map2 = JSON.parseObject(result);
				 return result;
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		return null;

		
	}

}
