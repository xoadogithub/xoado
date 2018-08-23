package com.xoado.FilingCabinet.service;

import javax.servlet.http.HttpServletRequest;

import com.xoado.common.XoadoResult;

/**
* @author 作者
* @version 创建时间：2018年8月3日 下午5:05:36
* 类说明
*/
public interface IBoxes {
	/**
	 * 
	 * @param boxname  档案柜名称
	 * @param owner_orgid 所属组织Id
	 * @param owner_orgname 所属组织名称
	 * @param scopeofuse  使用类型   enum private public
	 * @param location_address  地址的具体信息
	 * @param location_longitude  经度
	 * @param location_latitude  纬度
	 * @param remarks 备注
	 * @param request
	 * @return
	 */
	XoadoResult Add_Boex(String boxname,String owner_orgid,String owner_orgname,String scopeofuse,String location_address,double location_longitude,double location_latitude,String remarks,HttpServletRequest request);
	/**
	 * 
	 * @param request
	 * @return  返回当前用户有权限的档案柜列表，包括创建的和别人共享的
	 */
	XoadoResult Obtain_current_users(HttpServletRequest request);
	/**
	 * 删除一个自己创建的档案柜
	 * @param boxid  删除指定的档案柜
	 * @param request
	 * @return
	 */
	XoadoResult remove_boex(String boxid,HttpServletRequest request);
	/**
	 * 指定一个档案柜共享给一个或者多个人
	 * @param userid  共享给的人
	 * @param boxid  指定的档案柜
	 * @param request
	 * @return
	 */
	XoadoResult share_boexAddUser(String userid,String username,String boxid,HttpServletRequest request);
	/**
	 * 将指定的一个或者多个人从当前档案柜共享中删除
	 * @param userid  指定删除的人
	 * @param boxid  指定的档案柜
	 * @param request
	 * @return
	 */
	XoadoResult share_boexRemoveUser(String userid,String boxid,HttpServletRequest request);
	/**
	 * 	返回指定档案柜详情（创建人和被授权人）。
	 * @param boexId
	 * @param request
	 * @return
	 */
	XoadoResult get_boex_particulars(String Boexid,HttpServletRequest request);
}
