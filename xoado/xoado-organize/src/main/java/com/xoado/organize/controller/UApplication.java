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

import com.xoado.common.XoadoResult;
import com.xoado.organize.service.IApplication;

/**
* @author 作者
* @version 创建时间：2018年6月1日 下午3:56:51
*
*/
@Controller
@RequestMapping("/applications")
public class UApplication {
	
	
	
	@Autowired
	private IApplication iapplication;

	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult application_add(@RequestParam("organizeId") String organizeId, 
			@RequestParam("appName") String appName,
			@RequestParam("appType") Long appType,
			@RequestParam("description") String description,HttpServletRequest request){
		XoadoResult result = iapplication.application_add(organizeId, appName, appType, description, request);
		return result;	
	}
//	b)	[get] /applications               当前用户所有应用列表
	@RequestMapping(value="",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult application_userid(HttpServletRequest request){
		XoadoResult result = iapplication.application_userid(request);
		return result;
	}
//	[get] /applications/all				平台所有应用列表
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult application_all(HttpServletRequest request){
		XoadoResult result = iapplication.application_all(request);
		return result;
	}
	
//	c)	[get] /applications/{id}           返回指定应用详细信息
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult aplications_id(@PathVariable("id") String appId,HttpServletRequest request){
		XoadoResult result = iapplication.aplications_id(appId, request);
		return result;
	}
//	d)	[get] /applications/{id}/logo       返回应用LOGO
	@RequestMapping(value="/{id}/logo",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult aplication_id_logo(@PathVariable("id") String appId,HttpServletRequest request){
		XoadoResult result = iapplication.aplication_id_logo(appId, request);
		return result;
	}
//	d)	[get] /applications/logo?id=       返回应用LOGO
	@RequestMapping(value="/logo",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult aplication_idlogo(@RequestParam("appId") String appId,HttpServletRequest request){
		XoadoResult result = iapplication.aplication_id_logo(appId, request);
		return result;	
	}
//	e)	[put] /applications/{id}            修改应用信息
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult application_update(@RequestParam("appId") String appId,
			@RequestParam("appName") String appName,
			@RequestParam("appType") Long appType,
			@RequestParam("description") String description,
			@RequestParam("appDomain") String appDomain,HttpServletRequest request){
		XoadoResult result = iapplication.application_update(appId, appName, appType, description, appDomain, request);
		return result;
	}
//	g)	[put] /applications/{id}/logo       更新应用LOGO
	@RequestMapping(value="{id}/logo",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult application_update_logo(@PathVariable("id") String appId,@RequestParam("appImgUrl") MultipartFile appImgUrl,HttpServletRequest request){
		XoadoResult result = iapplication.application_update_logo(appId, appImgUrl, request);
		return result;
	}
//	[put] /applications/logo body{id=}
	@RequestMapping(value="logo",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult application_updatelogo(@RequestParam("appId") String appId,@RequestParam("appImgUrl") MultipartFile appImgUrl,HttpServletRequest request){
		XoadoResult result = iapplication.application_update_logo(appId, appImgUrl, request);
		return result;
	}
//	i)	[put] /applications/{id}/managers     变更应用负责人
	@RequestMapping(value="{id}/managers",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult application_update_member(@PathVariable("id") String appId,String creater,HttpServletRequest request){
		XoadoResult result = iapplication.application_update_member(appId, creater, request);
		return result;
	}
//	h)	[get] /applications/apis      返回应用下的接口列表
	@RequestMapping(value="apis")
	@ResponseBody
	public XoadoResult application_myappid(@RequestParam("appId") String appId,HttpServletRequest request){
		XoadoResult result = iapplication.application_myappid(appId, request);
		return result;
	}
//	[get] /applications/{id}/apis  返回指定应用下的接口列表
	@RequestMapping(value="/{id}/apis",method=RequestMethod.GET)			
	@ResponseBody
	public XoadoResult applicationmyappid(@PathVariable("id") String appId,HttpServletRequest request){
		XoadoResult result = iapplication.application_myappid(appId, request);
		return result;
	}
//	 [get] /applications/packageapis/{appid}   返回当前应用需要的开发API列表
	@RequestMapping(value="/packageapis/{appId}")
	@ResponseBody
	public XoadoResult app_package_id(@PathVariable("appId") String appId, HttpServletRequest request){
		XoadoResult result = iapplication.app_package_id(appId, request);
		return result;
	}
	 
}
