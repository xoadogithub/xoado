package com.xoado.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.common.XoadoResult;
import com.xoado.tools.service.IImageRecognition;

/**
* @author 作者
* @version 创建时间：2018年7月2日 下午3:04:35
* 类说明
*/
@Controller
@RequestMapping("/image_scanning")
public class CImageRecognition {
	
	@Autowired
	private IImageRecognition iImageRecognition;
	/**
	 * 图片识别
	 * @param file
	 * @param base64Body
	 * @param Text
	 * @return
	 */
	@RequestMapping(value="/image",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult xoado_scanning(@RequestParam("file") CommonsMultipartFile file,
			@RequestParam(value="base64Body",required=false) String base64Body,
			@RequestParam(value="Text",required=false) Object Text){
		
		XoadoResult result = iImageRecognition.image_recognition(file, base64Body);
		return result;
		
	}

}
