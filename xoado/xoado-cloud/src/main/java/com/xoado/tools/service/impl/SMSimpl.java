package com.xoado.tools.service.impl;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;
import com.xoado.common.XoadoResult;
import com.xoado.protocol.BaseRetCode;
import com.xoado.tools.common.XoadoPhoneMessage;
import com.xoado.tools.service.SMS;





/*
*
*@author 王文斌 E-mail:snzywwb@sina.cn
*@version 创建时间 2018年3月21日上午11:51:21
*获取验证码
*/
@Service
public class SMSimpl implements SMS{

	@Override
	public XoadoResult Phone_code(String text,String xoado_message,String PhoneNumber,HttpSession session) {
		
		
		try {
			XoadoPhoneMessage.Phone_code_test(text,xoado_message,PhoneNumber, session);
		} catch (ClientException | InterruptedException e) {
			
			e.printStackTrace();
		};
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg());
	}

}
