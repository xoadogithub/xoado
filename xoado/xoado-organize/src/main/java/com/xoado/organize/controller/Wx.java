package com.xoado.organize.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.common.XoadoResult;

/**
* @author 作者
* @version 创建时间：2018年6月7日 上午10:51:13
* 类说明
*/
@Controller
@RequestMapping("/weixin")
public class Wx {
	
	private final static String AppId="wx6f286fd741748f68";    
	private final static String AppSecret="e12c509305f5e511cd12da6b5adecc77";
	
	/**
	 * 
	 * @return  微信菜单功能
	 */
	@RequestMapping(value="/{module}/{wxappId}")
	@ResponseBody
	public XoadoResult WxMenu(){
		return null;
		
	}
	/**
	 * 
	 * @return  开发平台授权验证URL
	 */
	@RequestMapping(value="/authorization")
	@ResponseBody
	public XoadoResult Wxaccredit(HttpServletRequest request,HttpServletResponse response){
		
		return null;
		
	}

}
