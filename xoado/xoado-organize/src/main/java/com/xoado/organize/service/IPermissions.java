package com.xoado.organize.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoado.common.XoadoResult;




public interface IPermissions {
	
	
	XoadoResult select(int page,int rows,String organizeid,HttpServletRequest request,HttpServletResponse response);
	
	XoadoResult permissions_register(String organizeid,String name,Object permissions,String createrid,HttpServletRequest request);

}
