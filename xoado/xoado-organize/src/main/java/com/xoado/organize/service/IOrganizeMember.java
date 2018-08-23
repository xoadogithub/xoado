package com.xoado.organize.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xoado.common.XoadoResult;

public interface IOrganizeMember {
	
	List<String> select(int page,int rows,HttpServletRequest request);
	
	XoadoResult get_organize_user(String organizeId,HttpServletRequest request);
	

}
