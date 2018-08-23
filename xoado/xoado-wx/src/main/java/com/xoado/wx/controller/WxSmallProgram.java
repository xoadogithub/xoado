package com.xoado.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.common.XoadoResult;

/**
* @author 作者
* @version 创建时间：2018年7月3日 下午1:52:03
* 类说明
*/
@Controller
@RequestMapping("/")
//@RequestMapping("/archives")
public class WxSmallProgram {
	
	
	/**
	 * 当前用户的所有临时资料。
	 * [get]path: / 
	 * @return archiveid:“档案iD”,handoverdate: “交接日期”,archivename:“档案名称”,org_ID:”组织ID”, org_name:”组织名称”
	 */

	public XoadoResult getTemporaryData(HttpServletRequest request,HttpServletResponse response){
		
		
		return null;	
	}
	
	/**
	 * 获得指定资料的详细信息
	 * @param archiveid
	 * @param request
	 * @param response
	 * @return 指定资料的详细信息，包括内容和当前定位（除图片外）。
	 */
	@RequestMapping("/{archiveid}")
//	@ResponseBody
	public XoadoResult getSpecifiedData(@PathVariable("archiveid") String archiveid,HttpServletRequest request,HttpServletResponse response){
		
		return null;
	}
	
	/**
	 * 获得指定资料的图片信息。
	 * @param archiveid
	 * @param request
	 * @param response
	 * @return 指定资料的图片列表（base64）。
	 */
	@RequestMapping("/{archiveid}/pictures")
	@ResponseBody
	public XoadoResult getImage(@PathVariable("archiveid") String archiveid,HttpServletRequest request,HttpServletResponse response){
		
		return null;
	}
	/**
	 * 指定资料的添加一个图片附件。
	 * @param imageBase64
	 * @param request
	 * @param response
	 * @return 返回true/false
	 */
	@RequestMapping(value="/{archiveid}/pictures",method=RequestMethod.POST)
	@ResponseBody
	public Boolean setimage(@RequestParam(value="archiveid") String archiveid,String base64,HttpServletRequest request,HttpServletResponse response){
		
		return null;	
	}
}
