package com.xoado.organize.service;
/**
* @author 作者
* @version 创建时间：2018年6月1日 下午3:51:34
* 
*/

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.xoado.common.XoadoResult;


public interface IApplication {
	
	/**
	 * @author 80665
	 * @instructions 创建一个应用
	 */
	XoadoResult application_add(String organizeId,String appName,Long appType,String description,HttpServletRequest request);
	XoadoResult application_userid(HttpServletRequest request);
	XoadoResult application_all(HttpServletRequest request);
//	c)	[get] /applications/{id}           返回指定应用详细信息
	XoadoResult aplications_id(String appId,HttpServletRequest request);
//	d)	[get] /applications/{id}/logo       返回应用LOGO
	XoadoResult aplication_id_logo(String appId,HttpServletRequest request);
//	e)	[put] /applications/{id}            修改应用信息
	XoadoResult application_update(String appId,String appName,Long appType,String description,String appDomain,HttpServletRequest request);
//	g)	[put] /applications/{id}/logo       更新应用LOGO
	XoadoResult application_update_logo(String appId,MultipartFile appImgUrl,HttpServletRequest request);
//	i)	[put] /applications/{id}/managers     变更应用负责人
	XoadoResult application_update_member(String appId,String creater,HttpServletRequest request);
//	h)	[get] /applications/apis      返回应用下的接口列表
	XoadoResult application_myappid(String appId,HttpServletRequest request);
//	 [get] /applications/packageapis/{appid}   返回当前应用需要的开发API列表
	XoadoResult app_package_id(String  appId,HttpServletRequest request);
	

}
