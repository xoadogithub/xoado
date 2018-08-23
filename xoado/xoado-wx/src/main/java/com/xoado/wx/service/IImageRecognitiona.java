package com.xoado.wx.service;
/**
* @author 作者
* @version 创建时间：2018年6月29日 下午4:09:45
* 类说明
*/



import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.common.XoadoResult;

public interface IImageRecognitiona {
	/**
	 * 
	 * @param host		身份证识别、行驶证识别、银行卡识别、通用文字识别、营业执照识别
	 * @param imaText	base64位码
	 * @param headers	根据API的要求，定义相对应的Content-Type
	 * @param file      文件
	 * @return
	 */
	XoadoResult	image_recognition(CommonsMultipartFile file,String base64Body);

}
