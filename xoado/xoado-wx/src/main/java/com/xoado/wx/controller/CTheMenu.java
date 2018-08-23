package com.xoado.wx.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.common.XoadoResult;
import com.xoado.wx.service.ITheMenu;

/**
* @author 作者
* @version 创建时间：2018年6月26日 下午3:25:05
* 类说明
*/
@Controller
@RequestMapping("/Menu")
public class CTheMenu {
	
	@Autowired
	private ITheMenu iTheMenu;
//	创建菜单
	@RequestMapping("/addmenu")
	@ResponseBody
	public XoadoResult MenuManager(HttpServletRequest request,HttpServletResponse response)throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		XoadoResult xoadoResult = iTheMenu.MenuManager(request, response);
		return xoadoResult;
	}

}
