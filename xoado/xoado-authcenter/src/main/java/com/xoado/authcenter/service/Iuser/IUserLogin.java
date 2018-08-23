package com.xoado.authcenter.service.Iuser;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoado.common.XoadoResult;




public interface IUserLogin {
//	密码登录
	XoadoResult select(String phoneNumber,String userPassword,HttpServletRequest request,HttpServletResponse response);
//	短信登录
	XoadoResult phone_VerificationCode_login(String phoneNumber,String Verification_code,HttpServletRequest request);
//	注册新用户
	XoadoResult user_register(String phoneNumber,String userPassword,String Verification_code,HttpServletRequest request);




}
