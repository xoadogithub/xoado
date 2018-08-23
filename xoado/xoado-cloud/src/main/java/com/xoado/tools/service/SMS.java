package com.xoado.tools.service;

import javax.servlet.http.HttpSession;

import com.xoado.common.XoadoResult;


/*
*
*@author 王文斌 E-mail:snzywwb@sina.cn
*@version 创建时间 2018年3月21日上午11:49:57
*/
public interface SMS {
	
//	获取手机验证码
	XoadoResult Phone_code(String text,String xoado_message,String phoneNumber,HttpSession session);

}
