package com.xoado.organize.service;
/**
* @author 作者
* @version 创建时间：2018年6月4日 下午2:21:07
* 类说明
*/

import javax.servlet.http.HttpServletRequest;

import com.xoado.common.XoadoResult;

public interface IApiInteface {
	
	XoadoResult sele_apiInteface(int page,int rows,HttpServletRequest request);
	
	XoadoResult sele_id_apiInteface(String apiId,HttpServletRequest request);
	
	XoadoResult apiinteface_add(String appId,String apiPath,Long requestMethod,String header,String description,String parameter);
	
	XoadoResult apiid_update(String apiId,String apiPath,Long requestMethod,String header,String description,String parameter);
	
	XoadoResult apiid_update_status(String apiId,String apistatus,HttpServletRequest request);
	
	XoadoResult api_package_add(String apiId,String appId,String description,HttpServletRequest request);
	
	XoadoResult api_package_dele(String apiId,String appId,HttpServletRequest request);
	
	
	
	

}
