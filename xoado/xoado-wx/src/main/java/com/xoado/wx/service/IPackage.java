package com.xoado.wx.service;

import com.xoado.wx.bean.TblComponentverifyticket;

/**
* @author 作者
* @version 创建时间：2018年6月11日 上午10:25:05
* 类说明
*/



public interface IPackage {
	
		void packageAdd(String description);
//		操作票据、code、服务开发方的access_token
		void TblComponentverifyticketadd(String WX3_app_id,String ComponentVerifyTicket);
		void TblComponentverifyticketupdate_code(String WX3_app_id,String pre_auth_code);
		void TblComponentverifyticketupdate_token(String WX3_app_id,String token);
		
		TblComponentverifyticket selectComponentVerifyTicket(String WX3_app_id);
}
