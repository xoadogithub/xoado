package com.xoado.organize.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.xoado.common.XoadoResult;




public interface IUser {
	/**
	 * 
	 * @param page
	 * @param rows
	 * @param request
	 * @return  1.	[get]/oauth/users  			返回用户列表?orgid=&name=&status=
	 */
	XoadoResult all_search(int page,int rows,HttpServletRequest request);
	/**
	 * 
	 * @param request
	 * @return	 [get]/oauth/users/me       返回当前用户详情
	 */
	XoadoResult active_user(HttpServletRequest request);
	/**
	 * 
	 * @param userid
	 * @param request
	 * @return  2.	[get]/oauth/users/{id}			返回指定用户详情
	 */
	XoadoResult named_user(String userid,HttpServletRequest request);
	/**
	 * 
	 * @param userid
	 * @param request
	 * @return  [get]/oauth/users/headimg?id= 指定ID用户头像
	 */
	XoadoResult appoint_head(String userid,HttpServletRequest request);
	/**
	 * 
	 * @param request
	 * @return  3.	[get]/oauth/users/headimg     当前用户头像
	 */
	XoadoResult present_head(HttpServletRequest request);
	/**
	 * 
	 * @param idcard
	 * @param positiveImgUrl
	 * @param reverseImgUrl
	 * @param name
	 * @param request
	 * @return  8.	[post]/oauth/users/authentications     提交实名认证资料
	 */
	XoadoResult Certification(String idcard ,MultipartFile positiveImgUrl,MultipartFile reverseImgUrl,String name,HttpServletRequest request);
	/**
	 * 
	 * @param request
	 * @return   7.	[get]/oauth/users/authentications    获得当前用户实名认证信息
	 */
	XoadoResult me_Certification(HttpServletRequest request);
	/**
	 * 
	 * @param userid
	 * @param request
	 * @return   [get]/oauth/users/authentications/{id}    获得指定用户实名认证信息
	 */
	XoadoResult named_Certification(String userid,HttpServletRequest request);
	/**
	 * 
	 * @param nickName
	 * @param sex
	 * @param city
	 * @param country
	 * @param province
	 * @param request
	 * @return  4.	[put]/oauth/users      		 修改当前用户信息
	 */
	XoadoResult update_user(String nickName,Long sex,String city,String country,String province,HttpServletRequest request);
	/**
	 * 
	 * @param userId
	 * @param nickName
	 * @param sex
	 * @param city
	 * @param country
	 * @param province
	 * @param request
	 * @return 5.	[put]/oauth/users/{id}      	 修改指定ID 用户信息
	 */
	XoadoResult update_id_user(String userId,String nickName,Long sex,String city,String country,String province,HttpServletRequest request);
	/**
	 * 
	 * @param headImgUrl
	 * @param request
	 * @return  6.	[put]/oauth/users/headimg      更新当前用户头像
	 */
	XoadoResult update_user_headimgurl(String headImgUrl,HttpServletRequest request);
	/**
	 * 
	 * @param accounttype
	 * @param request
	 * @return  9.	[put]/oauth/users/type				改变当前用户类型
	 */
	XoadoResult update_type(String accounttype,HttpServletRequest request);
	/**
	 * 
	 * @param userId
	 * @param accounttype
	 * @param request
	 * @return  [put]/oauth/users/type/{id}			改变指定用户类型
	 */
	XoadoResult update_id_type(String userId,String accounttype,HttpServletRequest request);

}
