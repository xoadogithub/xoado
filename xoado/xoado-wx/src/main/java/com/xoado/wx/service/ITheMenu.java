package com.xoado.wx.service;
/**
* @author 作者
* @version 创建时间：2018年6月26日 下午2:12:34
* 类说明   菜单
*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xoado.common.XoadoResult;

public interface ITheMenu {
//	菜单管理器
	XoadoResult MenuManager(HttpServletRequest request,HttpServletResponse response);

}
