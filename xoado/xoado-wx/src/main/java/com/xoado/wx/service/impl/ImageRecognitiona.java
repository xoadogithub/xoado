package com.xoado.wx.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.client.http.XoadoHttpRemote;
import com.xoado.common.XoadoResult;
import com.xoado.wx.service.IImageRecognitiona;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @author 作者
* @version 创建时间：2018年6月29日 下午4:17:56
* 类说明
*/
@Service
public class ImageRecognitiona implements IImageRecognitiona{
	
	@Value("${THEBUSINESSLICENSEURL}")
	private String THEBUSINESSLICENSEURL;
	@Value("${TEXTURL}")
	private String TEXTURL;
	@Value("${APPCODE}")
	private String APPCODE;
	@Value("${XOADO_SCANNING}")
	private String XOADO_SCANNING;
	
	@Override
	public XoadoResult image_recognition(CommonsMultipartFile file, String base64Body) {
		/**
		 * 1:使用通用文字识别TEXTURL，如果识别出来有营业执照进行营业执照识别THEBUSINESSLICENSEURL
		 */

//		生成map
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "APPCODE " + APPCODE);
		headers.put("Content-Type", "application/json; charset=UTF-8");
		if(base64Body==null){
			try {
				
		        InputStream in = null;
		        String imagepath = XOADO_SCANNING+new Date().getTime()+file.getOriginalFilename();
		        File file2 = new File(XOADO_SCANNING);
		        if(!file2.exists()){
					 file2.mkdirs();
					}
		        try {
		        	 File newpositiveImgUrlname = new File(imagepath);
		        	 file.transferTo(newpositiveImgUrlname);
		        	 in = new FileInputStream(newpositiveImgUrlname);
//		        	 进行base64编码
		        	 byte[] bytes=new byte[(int)newpositiveImgUrlname.length()]; in.read(bytes);
		        	 base64Body = Base64.getEncoder().encodeToString(bytes); 
		        	 
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
			} catch (Exception e) {
				
			}
		}
		JSONObject json = new JSONObject();
        json.put("image", base64Body);
        String imaText = json.toString();
        String result = XoadoHttpRemote.xoadoDopost(TEXTURL, imaText, headers);
        
        JSONObject jsonObject =JSONObject.fromObject(result);
        
        HashMap<Object,Object> map = new HashMap<>();
        JSONArray jsonArray = jsonObject.getJSONArray("ret");
        if(jsonArray!=null){
        	for (int i = 0; i < jsonArray.size(); i++) {
        		String word = jsonArray.getJSONObject(i).getString("word");
        		for (int j = 1; j < jsonArray.size()-1; j++) {
					map.put(word, word);
				}
    		}
        }
        if(map.get("营业执照")=="营业执照"){
//        	执行扫描营业执照
        	 String result1 = XoadoHttpRemote.xoadoDopost(THEBUSINESSLICENSEURL, imaText, headers);
        	 JSONObject jsonObject2 =JSONObject.fromObject(result1);
        	 Object object = jsonObject2.get("reg_num");
        	 return XoadoResult.build(200, "营业执照信息",object);
        }else if(map.get("身份证")=="身份证"){
//        	执行身份证扫描
        }else if(map.get("银行卡")=="银行卡"){
//        	执行银行卡扫描
        }
        

       
		return XoadoResult.build(200, "返回值的是通用信息",jsonObject);
	}

}
