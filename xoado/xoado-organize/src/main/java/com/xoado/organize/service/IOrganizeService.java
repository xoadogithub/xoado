package com.xoado.organize.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.common.XoadoResult;
import com.xoado.organize.bean.TblOrganize;




public interface IOrganizeService {
	/**
	 * 
	 * @param tblOrganize
	 * @param request
	 * @return   10.	[post]/oauth/organizations         创建一个组织
	 */
	XoadoResult register(String organizeName, String address,String telephone,Integer orgtype,String scode,String usci,HttpServletRequest request);
	
	XoadoResult select_user(int page,int rows,HttpServletRequest request);
	
	XoadoResult select(int page,int rows,HttpServletRequest request);
	
	XoadoResult organizeParticulars(String organizeId,HttpServletRequest request);
	
	XoadoResult get_logo(String organizeId,HttpServletRequest request);
	
	XoadoResult dele_organize(String organizeId,HttpServletRequest request);
	/**
	 * 
	 * @param logoUrl  替换的logo
	 * @param request
	 * @return	更新组织logo
	 */
	XoadoResult update_organize_logo(String organizeId,MultipartFile logoUrl,HttpServletRequest request);
	
	XoadoResult update_organize(String organizeId,String organizeName,String address,String telephone,String scode,HttpServletRequest request);
	
	XoadoResult update_organize_orgstatus(String organizeId,String orgstatus,HttpServletRequest request);
	

	


}
