package com.xoado.FilingCabinet.service;
/**
* @author 作者
* @version 创建时间：2018年8月5日 下午12:10:30
* 类说明
*/



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.xoado.common.XoadoResult;

public interface IHandover {
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
	XoadoResult ReceiveData(Object handout,Object recipient,String task_id,Object archives,String businesslabel,String comments,Object location,HttpServletRequest request);
	/**
	 * 发送快递
	 * @param handout
	 * @param recipient
	 * @param task_id
	 * @param express
	 * @param archives
	 * @param Businesslabel
	 * @param Comments
	 * @param Location
	 * @return
	 */
	XoadoResult ToSendExpress(Object handout,Object recipient,String task_id,Object express,Object archives,String Businesslabel,String comments,Object Location,HttpServletRequest request);
	/**
	 * 接收快递确认
	 * @param handoverid 交接Id
	 * @param handoverdate 确认时间  ？？？？
	 * @param Businesslabel 业务标签
	 * @param Comments	交接备注
	 * @param Location  交接地址  ？？？
	 * @param request
	 * @return
	 */
	XoadoResult ReceiveExpress(String handoverid,String businesslabel,String comments,Object lcation,HttpServletRequest request);
	/**
	 * 返回指定的快递单号记录
	 * @param expressid
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 */
	XoadoResult ExpressRecord(String expressid,Integer page,Integer rows,HttpServletRequest request);
	/**
	 * 返回当前用户的交接单详情
	 * @param handoverid  交接Id
	 * @param page		 页数
	 * @param rows		行数
	 * @param scope		日期区间
	 * @param request
	 * @return
	 */
	XoadoResult userhandover(String handoverid,Integer page,Integer rows,Date scope,HttpServletRequest request);
	/**
	 * 指定资料的交接记录
	 * @param archiveid
	 * @param request
	 * @return
	 */
	XoadoResult TheSpecifiedDataHandover(String archiveid,HttpServletRequest request);

}
