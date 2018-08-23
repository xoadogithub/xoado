package com.xoado.wx.controller;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;



import org.apache.http.HttpResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.client.http.XoadoHttpRemote;
import com.xoado.common.XoadoResult;
import com.xoado.wx.common.AliHttpUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
* @author 作者
* @version 创建时间：2018年6月28日 上午9:50:58
* 类说明
*/
@Controller
@RequestMapping("/Image")
public class ImageText {
	
	
	
	@RequestMapping(value="/SCANNING",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult IMAGE_SCANNING(@RequestParam("file") CommonsMultipartFile file) throws IOException {
		
		String host = "https://dm-58.data.aliyun.com/rest/160601/ocr/ocr_business_license.json"; //营业执照
		String appcode = "37a51d682bbc4e0b82d246a54cb13b3f";
		String host2 = "https://tysbgpu.market.alicloudapi.com/api/predict/ocr_general";  //通用文字识别
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "APPCODE " + appcode);
		headers.put("Content-Type", "application/json; charset=UTF-8");
			String bodys = null;
	        InputStream in = null;
			String imagepath = "H:/image/"+new Date().getTime()+file.getOriginalFilename();
			 File file2 = new File("H:/image");
			 if(!file2.exists()){
				 file2.mkdirs();
				}
	 
        try {
        	 File newpositiveImgUrlname = new File(imagepath);
			 file.transferTo(newpositiveImgUrlname);
        	 in = new FileInputStream(newpositiveImgUrlname);
//        	 进行base64编码
        	 byte[] bytes=new byte[(int)newpositiveImgUrlname.length()]; in.read(bytes);
        	 bodys = Base64.getEncoder().encodeToString(bytes);     
//             System.out.println("base64:"+bodys);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (in != null) {
				try {
					 in.close();
				} catch (Exception e) {
					 e.printStackTrace();
				}
			}
		}
        String word = null;

        JSONObject json = new JSONObject();
        json.put("image", bodys);
        String imaText = json.toString();
     
       
        HashMap<Object,Object> map = new HashMap<>();
        	String result = XoadoHttpRemote.xoadoDopost(host2, imaText, headers);

//        	获取到返回的json串
        	JSONObject jsonObject =JSONObject.fromObject(result);
        	System.out.println("jsonObject:"+jsonObject);
//        	取出社会信用代码
//        	Object object = jsonObject.get("reg_num");
        	JSONArray jsonArray = jsonObject.getJSONArray("ret");
//        	System.out.println(object);
        	for (int i = 0; i < jsonArray.size(); i++) {
				
        		word = jsonArray.getJSONObject(i).getString("word");
        		for (int j = 1; j < jsonArray.size()-1; j++) {
					map.put(word, word);
				}
			}
        	Object a = map.get("营业执照");
        	System.out.println("map"+map);
        
			return XoadoResult.build(200, "营业执照",jsonObject);
		
			// TODO Auto-generated catch block
		
		
		
	
		
	}
	public static void main(String[] args) {
			String host = "https://dm-58.data.aliyun.com";
			String path = "/rest/160601/ocr/ocr_business_license.json";
		    String method = "POST";
		    String appcode = "37a51d682bbc4e0b82d246a54cb13b3f";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + "83359fd73fe94948385f570e3c139105");
		    //根据API的要求，定义相对应的Content-Type
		    headers.put("Content-Type", "application/json; charset=UTF-8");
		    Map<String, String> querys = new HashMap<String, String>();
		    String bodys = "{\"image\":\"对图片内容进行Base64编码\"}";

		    try {
		    	/**
		    	* 重要提示如下:
		    	* HttpUtils请从
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		    	* 下载
		    	*
		    	* 相应的依赖请参照
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		    	*/
		    	HttpResponse response = AliHttpUtils.doPost(host, path, method, headers, querys, bodys);
		    	System.out.println(response.toString());
		    	//获取response的body
		    	//System.out.println(EntityUtils.toString(response.getEntity()));
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
	}

}
