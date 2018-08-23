package com.xoado.authcenter.service.Iuser;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xoado.authcenter.bean.TblWeixinUser;
import com.xoado.common.XoadoResult;



public interface IUserWxLogin {
	
//	微信登录
	List<TblWeixinUser> WXuser_login_select(String openId);
	XoadoResult register_Wxuser(TblWeixinUser user);
//	小程序绑定手机号
	XoadoResult Wx_register_phone(String openId,String phoneNumber,String Verification_code,HttpServletRequest request);

}
