package com.xoado.wx.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoado.common.MD5;
import com.xoado.wx.bean.TblAppPackage;
import com.xoado.wx.bean.TblComponentverifyticket;

import com.xoado.wx.mapper.TblComponentverifyticketMapper;
import com.xoado.wx.service.IPackage;

/**
* @author 作者
* @version 创建时间：2018年6月11日 上午10:26:52
* 类说明
*/
@Service
public class XoadoPackage implements IPackage{
	

	@Autowired
	private TblComponentverifyticketMapper tblComponentverifyticketMapper;

	@Override
	public void packageAdd(String description) {
		
		TblAppPackage appPackage = new TblAppPackage();
		appPackage.setApiId(MD5.MD5Encode(UUID.randomUUID().toString()));
		appPackage.setAppId(MD5.MD5Encode(UUID.randomUUID().toString()));
		appPackage.setDescription(description);
		
	
	}

	@Override
	public void TblComponentverifyticketadd(String WX3_app_id, String ComponentVerifyTicket) {
		System.out.println("service:"+WX3_app_id);
		System.out.println("service:ComponentVerifyTicket"+ComponentVerifyTicket);
		TblComponentverifyticket key = tblComponentverifyticketMapper.selectByPrimaryKey(WX3_app_id);
		
		
		if(key!=null){
				System.out.println("key不能null");
			key.setComponentverifyticket(ComponentVerifyTicket);
			tblComponentverifyticketMapper.updateByPrimaryKey(key);
			
		}else{
			System.out.println("key等于null");
			key.setWx3AppId(WX3_app_id);
			key.setComponentverifyticket(ComponentVerifyTicket);
			key.setPreAuthCode(null);
			key.setComponentAccessToken(null);
			int insert = tblComponentverifyticketMapper.insert(key);
			System.out.println(insert);
		}	
	}

	@Override
	public TblComponentverifyticket selectComponentVerifyTicket(String WX3_app_id) {
		TblComponentverifyticket key = tblComponentverifyticketMapper.selectByPrimaryKey(WX3_app_id);
		return key;
	}

	@Override
	public void TblComponentverifyticketupdate_code(String WX3_app_id,
			String pre_auth_code) {
		TblComponentverifyticket key = tblComponentverifyticketMapper.selectByPrimaryKey(WX3_app_id);
		key.setPreAuthCode(pre_auth_code);
		tblComponentverifyticketMapper.updateByPrimaryKey(key);
		
	}

	@Override
	public void TblComponentverifyticketupdate_token(String WX3_app_id,String token) {
		TblComponentverifyticket key = tblComponentverifyticketMapper.selectByPrimaryKey(WX3_app_id);
		key.setComponentAccessToken(token);
		tblComponentverifyticketMapper.updateByPrimaryKey(key);
		
	}

	

}
