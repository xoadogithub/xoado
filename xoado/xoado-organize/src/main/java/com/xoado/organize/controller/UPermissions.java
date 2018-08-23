package com.xoado.organize.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.common.XoadoResult;
import com.xoado.organize.service.IPermissions;

/**
 * 
 * @author 80665
 *
 */
@Controller
@RequestMapping("/Permissions")
public class UPermissions {
	
	@Autowired
	private IPermissions iPermissions;
	/**
	 * 
	 * @param page  页码
	 * @param rows	显示的行数
	 * @param organizeid  组织Id
	 * @param request	请求
	 * @param response	返回
	 * @return	返回列表
	 */
	@RequestMapping("all")
	@ResponseBody
	public XoadoResult select(@RequestParam("page") int page,@RequestParam("rows") int rows,@RequestParam("organizeId") String organizeid,HttpServletRequest request,HttpServletResponse response){
		XoadoResult result = iPermissions.select(page,rows,organizeid,request,response);
		return result;
	}


}
