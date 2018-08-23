package com.xoado.tools.service;
/**
* @author 作者
* @version 创建时间：2018年7月2日 下午2:49:52
* 类说明
*/

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.common.XoadoResult;

public interface IImageRecognition {
	/**
	 * 
	 * @param file
	 * @param base64Body
	 * @return
	 */
	XoadoResult image_recognition(CommonsMultipartFile file,String base64Body);

}
