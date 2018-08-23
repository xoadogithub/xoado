package com.xoado.organize.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xoado.common.XoadoResult;
import com.xoado.organize.bean.TblOrganize;

import com.xoado.organize.service.IOrganizeService;
import com.xoado.organize.service.impl.OrganizeTypeEnum;
import com.xoado.protocol.OrganizeType;


@Controller
@RequestMapping("/organizations")
public class UOrganize {
	
	@Autowired
	private IOrganizeService organizeservice;
	
	
	
	/**
	 * 
	 * @param page
	 * @param rows
	 * @param request
	 * @return [get]/oauth/organizations/all    平台所有组织列表
	 */
	@RequestMapping(value="all",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult select(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletRequest request){
		try {
			XoadoResult result = organizeservice.select(page,rows,request);
			return result;
		} catch (Exception e) {	
			return XoadoResult.build(400, "参数错误");
		}
	}
	/**
	 * 
	 * @param page
	 * @param rows
	 * @param request
	 * @return  11.	[get]/oauth/organizations       返回当前用户组织列表
	 */
	@RequestMapping(value="/me",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult select_user(@RequestParam("page") int page,@RequestParam("rows") int rows,HttpServletRequest request){
		return organizeservice.select_user(page,rows,request);
		
	}
	/**
	 * 
	 * @param organize
	 * @param request
	 * @return	10.	[post]/oauth/organizations         创建一个组织
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult organize_register(@RequestParam("organizeName") String organizeName,
			@RequestParam("address") String address,
			@RequestParam("telephone")String telephone,
			@RequestParam("orgId") Integer orgId,
			@RequestParam("scode") String scode,
			@RequestParam("usci") String usci,
			HttpServletRequest request){
		System.out.println("orgId:"+orgId);
		return organizeservice.register(organizeName, address, telephone, orgId, scode, usci,  request);
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 12.	[get]/oauth/organizations/{id}    返回指定组织详情
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult organizeParticulars(@PathVariable("id") String organizeId,HttpServletRequest request){
		XoadoResult result = organizeservice.organizeParticulars(organizeId,request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 12.	[get]/oauth/organizations?id=    返回指定组织详情
	 */
	@RequestMapping(value="id",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult id_organizeParticulars(@RequestParam("organizeId") String organizeId,HttpServletRequest request){
		XoadoResult result = organizeservice.organizeParticulars(organizeId,request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 13.	[get]/oauth/organizations/logo/{id}     返回指定组织LOGO
	 */
	@RequestMapping(value="/logo/{id}")
	@ResponseBody
	public XoadoResult id_logo(@PathVariable("id") String organizeId,HttpServletRequest request){
		XoadoResult result = organizeservice.get_logo(organizeId,request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 13.	[get]/oauth/organizations/logo?id=     返回指定组织LOGO
	 */
	@RequestMapping(value="/logo",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult idLogo(@RequestParam("organizeId") String organizeId,HttpServletRequest request){
		XoadoResult result = organizeservice.get_logo(organizeId,request);
		return result;	
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return 14.	[delete]/oauth/organizations/{id}    删除指定组织
	 */
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult dele_organize(@PathVariable("id") String organizeId,HttpServletRequest request){
		XoadoResult result = organizeservice.dele_organize(organizeId,request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param request
	 * @return [delete]/oauth/organizations?id=   删除指定组织
	 */
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult deleOrganize(@RequestParam("organizeId") String organizeId,HttpServletRequest request){
		XoadoResult result = organizeservice.dele_organize(organizeId,request);
		return result;
	}

	/**
	 * 
	 * @param organizeId
	 * @param organizeName
	 * @param address
	 * @param telephone
	 * @param scode
	 * @param request
	 * @return 16.	[put]/oauth/organizations/{id}			修改组织信息
	 */
	@RequestMapping(value="id/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_organize(@PathVariable("id") String organizeId,String organizeName,String address,String telephone,String scode,HttpServletRequest request){
		XoadoResult result = organizeservice.update_organize(organizeId, organizeName, address, telephone, scode,request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param organizeName
	 * @param address
	 * @param telephone
	 * @param scode
	 * @param request
	 * @return 16 [put]/oauth/organizations  body{id=}			修改组织信息
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_id_prganize(@RequestParam("organizeId") String organizeId,String organizeName,String address,String telephone,String scode,HttpServletRequest request){
		XoadoResult result = organizeservice.update_organize(organizeId, organizeName, address, telephone, scode,request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param orgstatus
	 * @param request
	 * @return 17.	[put]/oauth/organizations/status/{id}		修改组织状态
	 */
	@RequestMapping(value="status/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_organize_orgstatus(@PathVariable("id") String organizeId,String orgstatus,HttpServletRequest request){
		XoadoResult result = organizeservice.update_organize_orgstatus(organizeId, orgstatus, request);
		return result;
	}
	/**
	 * 
	 * @param organizeId
	 * @param orgstatus
	 * @param request
	 * @return  [put]/oauth/organizations/status   body{id=}		修改组织状态
	 */
	@RequestMapping(value="/status",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_organize_id_orgstatus(@RequestParam("organizeId") String organizeId,String orgstatus,HttpServletRequest request){
		XoadoResult result = organizeservice.update_organize_orgstatus(organizeId, orgstatus, request);
		return result;
	}
	/**
	 * 
	 * @param organizeId  组织Id
	 * @param logoUrl    图标文件
	 * @param request
	 * @return 15.	[put]/oauth/organizations/logo/{id}     更新组织LOGO
	 */
	@RequestMapping(value="/logo/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_organize_logo(@PathVariable("id") String organizeId,@RequestParam("logoUrl") MultipartFile logoUrl, HttpServletRequest request){
		XoadoResult result = organizeservice.update_organize_logo(organizeId, logoUrl, request);
		return result;
	}
	/**
	 * 
	 * @param organizeId  组织Id
	 * @param logoUrl		图标文件
	 * @param request
	 * @return [put]/oauth/organizations/logo  body{id=}   更新组织LOGO
	 */
	@RequestMapping(value="/logo",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult update_organizeidlogo(@RequestParam("organizeId") String organizeId,@RequestParam("logoUrl") MultipartFile logoUrl, HttpServletRequest request){
		XoadoResult result = organizeservice.update_organize_logo(organizeId, logoUrl, request);
		return result;
	}
	
	/**
	 * @return 返回组织类型
	 */
	@RequestMapping("/type")
	@ResponseBody
	public XoadoResult orgtype(){
		XoadoResult type = OrganizeTypeEnum.orgType();
		return type;
	}

}
