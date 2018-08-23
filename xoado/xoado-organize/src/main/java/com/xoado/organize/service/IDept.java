package com.xoado.organize.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.xoado.common.XoadoResult;



/*
 * 
 */
public interface IDept {

	
	
	XoadoResult id_dept_all(String organizeId,HttpServletRequest request);
	
	XoadoResult id_deptDetails(String deptId,HttpServletRequest request);
	
	XoadoResult dele_id_dept(String deptId,HttpServletRequest request);
	
	XoadoResult id_dept_users(String deptId,HttpServletRequest request);
	
	XoadoResult id_dept(String organizeId,String deptName,String managerid,Object member,String createrid,HttpServletRequest request);
	
	XoadoResult update_dept(String deptId ,String deptName,Object member,HttpServletRequest request);
	
	XoadoResult update_dapt_managerId(String deptId,String managerid,HttpServletRequest request);
	
	XoadoResult dept_member_add(String deptId,Object member,HttpServletRequest request);
	/**
	 * 
	 * @param YdeptId  原来的部门Id
	 * @param XdeptId  现在的部门Id
	 * @param userId   部门成员Id
	 * @param request
	 * @return
	 */
	XoadoResult update_id_dept(String YdeptId,String XdeptId,String userId,HttpServletRequest request);
	/**
	 * 
	 * @param organizeId 组织Id
	 * @param userid	用户Id
	 * @param role	组织角色
	 * @param parttimejob	是否允许兼职
	 * @param joinTime	加入时间
	 * @return
	 */
	XoadoResult orgAddmember(String organizeId,String userId,String role ,Long parttimejob,Date joinTime);
	
	XoadoResult update_org_role(String userId ,String role,HttpServletRequest request);
	XoadoResult test();
	

}
