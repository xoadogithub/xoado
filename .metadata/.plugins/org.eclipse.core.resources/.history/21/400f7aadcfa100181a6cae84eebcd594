package com.xoado.FilingCabinet.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.FilingCabinet.service.IHandover;
import com.xoado.common.XoadoResult;

/**
* @author 作者
* @version 创建时间：2018年8月5日 下午9:02:30
* 类说明
*/
@Controller
@RequestMapping("/handover")
public class UHandover {
	
	@Autowired 
	private IHandover iHandover;

	/**
	 * 接收资料，资料放入档案柜，从档案柜中取出资料
	 * @param handout
	 * @param recipient
	 * @param task_id
	 * @param archives
	 * @param Businesslabel
	 * @param Comments
	 * @param Location
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult ReceiveData(String handout, String recipient, String task_id, String archives,
			String Businesslabel, String Comments,@RequestParam(value="location",required=true) String location,HttpServletRequest request) {
			XoadoResult result = iHandover.ReceiveData(handout, recipient, task_id, archives, Businesslabel, Comments, location, request);
			return result;	
	}
	
	/**
	 * 返回当前用户的交接单详情
	 * @param handoverid  交接Id
	 * @param page		 页数
	 * @param rows		行数
	 * @param scope		日期区间
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult userhandover(@RequestParam(value="handoverid",required=false) String handoverid,@RequestParam(value="page",required=false) Integer page,@RequestParam(value="rows",required=false) Integer rows,@RequestParam(value="scope",required=false) Date scope,
			HttpServletRequest request) {
		XoadoResult result = iHandover.userhandover(handoverid, page, rows, scope, request);
		return result;
	}
	
}
