package com.xoado.FilingCabinet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.FilingCabinet.service.IBoxes;
import com.xoado.common.XoadoResult;

/**
* @author 作者
* @version 创建时间：2018年8月4日 下午5:41:01
* 类说明
*/
@Controller
@RequestMapping("/boxes")
public class Uboxes {
	
	@Autowired
	private IBoxes boxes;
	
	/**
	 * 当前账户增加一个档案柜
	 * @param boxName
	 * @param ownerOrgid
	 * @param scopeofuse
	 * @param location
	 * @param gisa
	 * @param gisb
	 * @param remarks
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult Add_Boex(@RequestParam("boxname") String boxname, 
			@RequestParam("owner_orgid") String owner_orgid,
			@RequestParam("owner_orgname") String owner_orgname, 
			@RequestParam("scopeofuse") String scopeofuse,
			@RequestParam("location_address") String location_address,
			@RequestParam("location_longitude") float location_longitude,
			@RequestParam("location_latitude") float location_latitude,
			@RequestParam("remarks")String remarks,HttpServletRequest request) {
		XoadoResult result = boxes.Add_Boex(boxname, owner_orgid,owner_orgname, scopeofuse, location_address, location_longitude, location_latitude, remarks, request);
		return result;	
	}

	/**
	 * 当前账户所有的档案柜
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult Obtain_current_users(HttpServletRequest request) {
		XoadoResult result = boxes.Obtain_current_users(request);
		return result;
	}
	/**
	 * 当前账户共享一个档案柜
	 * @param userId
	 * @param boxId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="{boxid}/share",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult share_boexAddUser(@RequestParam("userid") String userid,@RequestParam("username") String username,@PathVariable("boxid")  String boxid, HttpServletRequest request) {
		XoadoResult result = boxes.share_boexAddUser(userid,username ,boxid, request);
		return result;	
	}
	/**
	 * 当前账户删除一个档案柜
	 * @param boxId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{boxid}",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult remove_boex(@PathVariable("boxid") String boxId, HttpServletRequest request) {
		XoadoResult result = boxes.remove_boex(boxId, request);
		return result;
	}
	/**
	 * 当前账户删除一个共享账户
	 * @param userId
	 * @param boxId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="{boxid}/share",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult share_boexRemoveUser(@RequestParam("userid") String userId,@PathVariable("boxid")  String boxId, HttpServletRequest request) {
		XoadoResult result = boxes.share_boexRemoveUser(userId, boxId, request);
		return result;	
	}
	/**
	 * 获得指定档案盒详情（创建人和被授权人）。
	 * @param boexId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{boxid}",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult get_boex_particulars(@PathVariable("boxid") String Boexid, HttpServletRequest request) {
		XoadoResult result = boxes.get_boex_particulars(Boexid, request);
		return result;
	}

}
