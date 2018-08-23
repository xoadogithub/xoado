package com.xoado.wx.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

/**
* @author 作者
* @version 创建时间：2018年6月26日 上午9:54:02
* 类说明    消息与事件接收
*/
public interface IWxMessageEvents {
	
	String processRequest(String postdata,HttpServletRequest request) throws UnsupportedEncodingException;

}
