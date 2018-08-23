package com.xoado.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.common.XoadoResult;
import com.xoado.wx.service.IImageRecognitiona;

/**
* @author 作者
* @version 创建时间：2018年6月29日 下午5:23:54
* 类说明
*/
@Controller
@RequestMapping("/")
public class CImageRecognitiona {
	
	@Autowired
	private IImageRecognitiona iImageRecognition;
	
	@RequestMapping("")
	@ResponseBody
	public XoadoResult xoado_scanning(@RequestParam("file") CommonsMultipartFile file,
			@RequestParam("base64Body") String base64Body,
			@RequestParam("Text") Object Text){
		
			XoadoResult result = iImageRecognition.image_recognition(file, base64Body);
				
			return result;
		
	}

}
