package com.xoado.authcenter.service.Iuser;
/**
* @author 作者
* @version 创建时间：2018年6月6日 上午11:53:44
* 类说明
*/

import com.xoado.common.XoadoResult;

public interface Userpwd {
	/**
	 * 接收密码需要手机号，手机验证码
	 * @param phoneNumber
	 * @return
	 */
	XoadoResult update_user_pwd(String phoneNumber);

}
