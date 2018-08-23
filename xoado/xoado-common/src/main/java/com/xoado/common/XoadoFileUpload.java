package com.xoado.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Decoder;

/**
 * Fileprocessing 文件上传
* @author 作者
* @version 创建时间：2018年7月20日 上午10:00:38
* 类说明
*/
@SuppressWarnings("restriction")
public class XoadoFileUpload {
	
	/**
	 * 图片上传  返回文件名，文件路径，base64缩略图  base64Name
	 * @param xoadofile
	 * @return
	 */
	static InputStream in = null;
	static String base64 = null;
	public static Map<String, Object> FileImageProcessing(MultipartFile xoadoFile){
		
//		存储路径为:D:/
		String url = "/usr/tomcat/apache-tomcat-8.5.29/webapps/File/image/";
//		String url = "D:/";
//		存储文件名 路径
		Map<String,Object> map = new HashMap<>();
//		生成一个新的文件名
		String name =  UUID.randomUUID()+xoadoFile.getOriginalFilename();
		File file = new File(url);
	
		if(!file.exists()){
			
			file.mkdirs();
			
		}
		
//		fileName数据库存储的全路径
		String fileName = url+name;
		String path = "www.xoado.com/File/image/";
		File xoadofile = new File(fileName);
		
		try {
			xoadoFile.transferTo(xoadofile);
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		base64缩略图
		try {
			Thumbnails.of(xoadofile).size(50,50).toFile(url+"ZIP-"+name);
			 File newpositiveImgUrlname = new File(url+"ZIP-"+name);
			in = new FileInputStream(newpositiveImgUrlname);
			byte[] bytes=new byte[(int)(newpositiveImgUrlname).length()]; in.read(bytes);
			base64 = Base64.getEncoder().encodeToString(bytes); 
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		map.put("imageName", name);
		map.put("imageUrl", path+name);
		
		map.put("ZIPName", "ZIP-"+name);
		map.put("ZIPUrl", path+"ZIP-"+name);
		
		return map;	
	}
	public static Map<String, Object> FileDocProcessing(MultipartFile xoadoFile){
		String url = "/usr/tomcat/apache-tomcat-8.5.29/webapps/File/DOC/";
//		存储文件名  路径
		Map<String,Object> map = new HashMap<>();
//		生成一个新的文件名
		String name =  UUID.randomUUID()+xoadoFile.getOriginalFilename();
		String path = "www.xoado.com/File/DOC/"+name;
		File file = new File(url);
		
		if(!file.exists()){
			
			file.mkdirs();
			
		}
//		fileName数据库存储的全路径
		String fileName = url+name;
		
		File xoadofile = new File(fileName);
		
		try {
			xoadoFile.transferTo(xoadofile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("DocName", name);
		map.put("docUrl", path);
		
		return map;
		
	}
	
	public static Map<Object, Object> base64upload(String name,String base64text) throws Exception{
		HashMap<Object,Object> map = new HashMap<>();
		BASE64Decoder decoder = new BASE64Decoder(); 
		byte[] b = decoder.decodeBuffer(base64text.toString());
		 for(int j=0;j<b.length;++j) {
			 if(b[j]<0)  {
				 b[j]+=256;
			 }
		 }
//		 String url = "D:/";
		 String url = "/usr/tomcat/apache-tomcat-8.5.29/webapps/File/image/";
//		 创建文件夹
		 File file = new File(url);
		 if(!file.exists()){	
				file.mkdirs();	
			}		 
//		 新生成的图片名称
		 String newName = MD5.MD5Encode(UUID.randomUUID().toString())+name;
//		 图片的名称及上传路径
		 String imgFilePath = url+newName+".jpg"; 
//		 以流的形式上传文件
		 OutputStream out = new FileOutputStream(imgFilePath);
//		 上传及关流
		 out.write(b);
		 out.flush();
		 out.close();
//		 缩略图上传的路径
		 String thumbnail = url+"-zip-"+name;
		 Thumbnails.of(imgFilePath).size(50,50).toFile(thumbnail);
//		 返回json数据
		 
		 map.put("imageName", newName);
		 map.put("imageUrl","www.xoado.com/File/image/"+newName+".jpg");
		 map.put("imageZipName", "-zip-"+name);
		 map.put("imageZipUrl", "www.xoado.com/File/image/"+"-zip-"+name+".png");
		 
		 return map;

}

}
