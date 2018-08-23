package com.xoado.organize.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.xoado.common.XoadoResult;
import com.xoado.organize.service.IDept;
import com.xoado.organize.service.IOrganizeMember;

/**
* @author wangwenbin
* @version 0.0.0
* 
*/
@Controller
@RequestMapping("/organization")
public class UDept {
	
	@Autowired
	private IDept iDept;
	@Autowired
	private IOrganizeMember iOrganizeMember;
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 20.	[get] base/organizations/{id}/depts       返回指定组织部门列表
	 */
	@RequestMapping(value="{id}/depts",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult id_dept(@PathVariable("id") String organizeId,HttpServletRequest request){
		XoadoResult result = iDept.id_dept_all(organizeId,request);
		return result;	
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 返回指定组织部门列表
	 */
	@RequestMapping(value="/depts",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult idept(@RequestParam("organizeId") String organizeId,HttpServletRequest request){
		XoadoResult result = iDept.id_dept_all(organizeId,request);
		return result;
	}
	/**
	 * 
	 * @param deptId
	 * @param request
	 * @return 返回指定部门详情
	 */
	@RequestMapping(value="/dept/{id}",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult id_deptDetails(@PathVariable("id") String deptId,HttpServletRequest request){
		XoadoResult result = iDept.id_deptDetails(deptId,request);
		return result;
	}
	/**
	 * 
	 * @param deptId
	 * @param request
	 * @return 返回指定部门详情
	 */
	@RequestMapping(value="/dept",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult idDeptDetails(@RequestParam("deptId") String deptId,HttpServletRequest request){
		XoadoResult result = iDept.id_deptDetails(deptId,request);
		return result;
	}
	/**
	 * 
	 * @param deptId
	 * @param request
	 * @return 删除指定的部门
	 */
	@RequestMapping(value="/depts/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult dele_id_dept(@PathVariable("id") String deptId,HttpServletRequest request){
		XoadoResult result = iDept.dele_id_dept(deptId,request);
		return result;
	}
	/**
	 * 
	 * @param deptId
	 * @param request
	 * @return 删除指定的部门
	 */
	@RequestMapping(value="/depts/body",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult deleIdDept(@RequestParam("deptId") String deptId,HttpServletRequest request){
		XoadoResult result = iDept.dele_id_dept(deptId,request);
		return result;
	}
	/**
	 * 
	 * @param deptId
	 * @param request
	 * @return 返回指定部门的成员列表
	 */
	@RequestMapping(value="depts/{id}/members",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult id_dept_users(@PathVariable("id") String deptId,HttpServletRequest request){
		XoadoResult result = iDept.id_dept_users(deptId,request);
		return result;	
	}
	/**
	 * 
	 * @param organizeId
	 * @param deptName
	 * @param managerid
	 * @param member
	 * @param createrid
	 * @param request
	 * @return 指定组织创建一个部门
	 */
	@RequestMapping(value="{id}/depts",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult id_dept(@PathVariable("id") String organizeId,
			@RequestParam("deptName") String deptName,
			@RequestParam("managerid") String managerid,
			@RequestParam("member") Object member,
			@RequestParam("createrid") String createrid,HttpServletRequest request){
		XoadoResult result = iDept.id_dept(organizeId, deptName, managerid, member, createrid, request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param deptName
	 * @param managerid
	 * @param member
	 * @param createrid
	 * @param request
	 * @return 指定组织创建一个部门
	 */
	@RequestMapping(value="/depts",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult iddept(@RequestParam("organizeId") String organizeId,
			@RequestParam("deptName") String deptName,
			@RequestParam("managerid") String managerid,
			@RequestParam("member") Object member,
			@RequestParam("createrid") String createrid,HttpServletRequest request){
		XoadoResult result = iDept.id_dept(organizeId, deptName, managerid, member, createrid, request);
		return result;	
	}
	/**
	 * 
	 * @param deptId
	 * @param deptName
	 * @param member
	 * @param request
	 * @return 修改部门信息
	 */
	@RequestMapping(value="deptsid/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_dept(@PathVariable("id") String deptId,
			@RequestParam("deptName") String deptName,
			@RequestParam("member") Object member,HttpServletRequest request){
		XoadoResult result = iDept.update_dept(deptId, deptName, member,request);
		return result;
	}
	@RequestMapping(value="/depts",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult updatedept(@RequestParam("deptId") String deptId,
			@RequestParam("deptName") String deptName,
			@RequestParam("member") Object member,HttpServletRequest request){
		XoadoResult result = iDept.update_dept(deptId, deptName, member,request);
		return result;
	}
	/**
	 * 
	 * @param deptId
	 * @param managerid
	 * @param request
	 * @return 变更部门负责人信息
	 */
	@RequestMapping(value="depts/{id}/managers",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_dapt_managerId(@PathVariable("id") String deptId,@RequestParam("managerid") String managerid ,HttpServletRequest request){
		XoadoResult result = iDept.update_dapt_managerId(deptId, managerid,request);
		return result;
	}
	/**
	 * 
	 * @param deptId
	 * @param member
	 * @param request 
	 * @return 添加部门成员
	 */
	@RequestMapping(value="depts/{id}/mamber",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult dept_member_add(@PathVariable("id") String deptId, @RequestParam("member") Object member, HttpServletRequest request){
		XoadoResult result = iDept.dept_member_add(deptId, member, request);
		return result;
	}
	/**
	 * 
	 * @param YdeptId 原来的部门Id
	 * @param XdeptId 目标部门Id
	 * @param userId  部门成员Id
	 * @param request
	 * @return [put] base/organizations/depts/members   成员换部门,角色不变
	 */
	@RequestMapping(value="depts/members",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_id_dept(String YdeptId, String XdeptId, String userId, HttpServletRequest request){
		XoadoResult result = iDept.update_id_dept(YdeptId, XdeptId, userId, request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 29.	[get] base/organizations/{id}/role           获得组织角色成员列表
	 */
	@RequestMapping(value="/{id}/role",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult get_organize_user(@PathVariable("id") String organizeId,HttpServletRequest request){
		XoadoResult result = iOrganizeMember.get_organize_user(organizeId,request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param userId
	 * @param role
	 * @param parttimejob
	 * @param joinTime
	 * @return 28.	[post] base/organizations/{id}/role           增加组织角色的成员
	 */
	@RequestMapping(value="/{id}/role",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult orgAddmember(String organizeId,String userId,String role ,Long parttimejob,Date joinTime){
		XoadoResult result = iDept.orgAddmember(organizeId, userId, role, parttimejob, joinTime);
		return result;
	}
	/**
	 * 
	 * @param userId
	 * @param role
	 * @param request
	 * @return 30.	[delete] base/organizations/{id}/role        组织成员撤销管理角色
	 */
	@RequestMapping(value="/{id}/role",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult update_org_role(String userId, String role, HttpServletRequest request){
		XoadoResult result = iDept.update_org_role(userId, role, request);
		return result;
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public XoadoResult a(){
		XoadoResult result = iDept.test();
		return result;
	}
	
}
