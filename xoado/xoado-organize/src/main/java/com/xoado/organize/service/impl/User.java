package com.xoado.organize.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xoado.client.http.Paging;
import com.xoado.common.JsonUtils;
import com.xoado.common.XoadoResult;


import com.xoado.organize.bean.TblUser;
import com.xoado.organize.bean.TblUserExample;
import com.xoado.organize.bean.TblUserExample.Criteria;

import com.xoado.organize.mapper.TblUserMapper;
import com.xoado.organize.pojo.Authentications;
import com.xoado.organize.pojo.UserXoado;
import com.xoado.organize.service.IUser;
import com.xoado.protocol.AccessIdentity;
import com.xoado.protocol.BaseRetCode;

import com.xoado.protocol.XoadoConstant;


@Service
public class User implements IUser{
	
	@Autowired
	private TblUserMapper tblUserMapper;


	@Value("${XOADO_USERID_IMAGE}")
	private String XOADO_USERID_IMAGE;

	@Value("${XOADO_IMAGE}")
	private String  XOADO_IMAGE;
	
	@Value("${XOADO_URL}")
	private String XOADO_URL;
	
	
	@Override
	public XoadoResult all_search(int page, int rows, HttpServletRequest request) {
//		缓存中存在登录信息，调取数据库	
		TblUserExample example = new TblUserExample();
		PageHelper.startPage(page, rows);
		List<TblUser> list = tblUserMapper.selectByExample(example);
		Paging resule = new  Paging();
		resule.setRows(list);
		List<UserXoado> xoado_list = new ArrayList<UserXoado>();	
		PageInfo<TblUser> info = new PageInfo<TblUser>(list);
		resule.setTotal(info.getTotal());
//		从分页信息中，获取信息
		List<TblUser> list2 = info.getList();
		for (TblUser tblUser : list2) {
			UserXoado xoado = new UserXoado();
			xoado.setUserid(tblUser.getUserid());
			xoado.setPhoneNumber(tblUser.getPhoneNumber());
			xoado.setName(tblUser.getName());
			xoado.setNickName(tblUser.getNickName());
			xoado.setCity(tblUser.getCity());
			xoado.setSex(tblUser.getSex());
			xoado.setCountry(tblUser.getCountry());
			xoado.setHeadImgUrl(tblUser.getHeadImgUrl());
			xoado.setProvince(tblUser.getProvince());
			xoado.setAccountstatus(tblUser.getAccountstatus());
			xoado_list.add(xoado);
		}
//		将获取到的信息返回前端
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), xoado_list);
	
	}
	
	@Override
	public XoadoResult active_user(HttpServletRequest request) {
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String userid = token.getUserId();
		TblUser user = tblUserMapper.selectByPrimaryKey(userid);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), user);
	}

	@Override
	public XoadoResult named_user(String userid, HttpServletRequest request) {

		if(userid==null){
			AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
			String userId2 = token.getUserId();
			TblUser user = tblUserMapper.selectByPrimaryKey(userId2);
			ArrayList<Object> list = new ArrayList<>();
			UserXoado xoado = new UserXoado();
			xoado.setUserid(user.getUserid());
			xoado.setPhoneNumber(user.getPhoneNumber());
			xoado.setName(user.getName());
			xoado.setNickName(user.getNickName());
			xoado.setCity(user.getCity());
			xoado.setSex(user.getSex());
			xoado.setCountry(user.getCountry());
			xoado.setHeadImgUrl(user.getHeadImgUrl());
			xoado.setProvince(user.getProvince());
			xoado.setAccountstatus(user.getAccountstatus());
			list.add(xoado);
			return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), list);
		}
		try {
			TblUser user = tblUserMapper.selectByPrimaryKey(userid);
			ArrayList<UserXoado> list = new ArrayList<UserXoado>();
			UserXoado xoado = new UserXoado();
			xoado.setUserid(user.getUserid());
			xoado.setPhoneNumber(user.getPhoneNumber());
			xoado.setName(user.getName());
			xoado.setNickName(user.getNickName());
			xoado.setCity(user.getCity());
			xoado.setSex(user.getSex());
			xoado.setCountry(user.getCountry());
			xoado.setHeadImgUrl(user.getHeadImgUrl());
			xoado.setProvince(user.getProvince());
			xoado.setAccountstatus(user.getAccountstatus());
			list.add(xoado);	
			return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), list);
		} catch (Exception e) {
			return XoadoResult.build(400,"未找到该用户");
		}
		
		
		
	}
	
	@Override
	public XoadoResult appoint_head(String userid, HttpServletRequest request) {
		TblUser user = tblUserMapper.selectByPrimaryKey(userid);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),user.getHeadImgUrl());
	}
	
	@Override
	public XoadoResult present_head(HttpServletRequest request) {
		AccessIdentity token =(AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		TblUser user = tblUserMapper.selectByPrimaryKey(token.getUserId());
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), user.getHeadImgUrl());
	}
	
	
	
	@Override
	public XoadoResult Certification(String idcard, MultipartFile positiveImgUrl, MultipartFile reverseImgUrl,
			String name, HttpServletRequest request) {
//	从session中获取到token
		AccessIdentity token = (AccessIdentity)request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
//	token中获取tokenid
		String tokenId = token.getTokenId();
		String userId = token.getUserId();
		TblUserExample example = new TblUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<TblUser> list = tblUserMapper.selectByExample(example);

//	正面新名称
		String positiveImgUrlname = XOADO_USERID_IMAGE+UUID.randomUUID()+positiveImgUrl.getOriginalFilename();
//	反面新名称
		String reverseImgUrlname = XOADO_USERID_IMAGE+UUID.randomUUID()+reverseImgUrl.getOriginalFilename();
//	生成文件夹
		File file = new File(XOADO_IMAGE+XOADO_USERID_IMAGE);
		if(!file.exists()){
			file.mkdirs();
		}
		File newpositiveImgUrlname = new File(XOADO_USERID_IMAGE+positiveImgUrlname);
		File newreverseImgUrlname = new File(XOADO_USERID_IMAGE+reverseImgUrlname);
		try {
			positiveImgUrl.transferTo(newpositiveImgUrlname);
			reverseImgUrl.transferTo(newreverseImgUrlname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TblUser user = new TblUser();
		for (TblUser tblUser : list) {
//	实名认证之前将原来的信息进行保存复制
			user.setUserid(tblUser.getUserid()); //userid
			user.setPhoneNumber(tblUser.getPhoneNumber());//手机号
			user.setUnionid(tblUser.getUnionid());//微信的unionid
			user.setUserPassword(tblUser.getUserPassword());//原来的密码
			user.setNickName(tblUser.getNickName());//原来的昵称
			user.setHeadImgUrl(tblUser.getHeadImgUrl());	//原来的头像
			user.setRegisterTime(tblUser.getRegisterTime());//注册时间
			user.setAccounttype(tblUser.getAccounttype());//账户类型
			user.setAccountstatus(tblUser.getAccountstatus());//账户状态，默认正常
			user.setSex(tblUser.getSex());
			user.setCity(tblUser.getCity());
			user.setCountry(tblUser.getCountry());
			user.setProvince(tblUser.getProvince());
			user.setIdcard(idcard);
			user.setMessage(tblUser.getMessage());
//	s实名认证的信息
			user.setPositiveImgUrl(XOADO_URL+positiveImgUrlname);
			user.setReverseImgUrl(XOADO_URL+reverseImgUrlname);
			user.setName(name);
			user.setAuditTime(new Date());
			tblUserMapper.updateByPrimaryKey(user);
		}
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult me_Certification(HttpServletRequest request) {
		
		AccessIdentity token = (AccessIdentity)request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String userId = token.getUserId();
		TblUser tblUser = tblUserMapper.selectByPrimaryKey(userId);
		Authentications authentications = Authentications.inster(tblUser);
		
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), authentications);
	}
		
	@Override
	public XoadoResult named_Certification(String userid, HttpServletRequest request) {
		TblUser user = tblUserMapper.selectByPrimaryKey(userid);
		Authentications authentications = Authentications.inster(user);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), authentications);
	}
	
	@Override
	public XoadoResult update_user(String nickName, Long sex, String city, String country, String province,HttpServletRequest request) {
		AccessIdentity token =(AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String userId = token.getUserId();
		TblUser tblUser = tblUserMapper.selectByPrimaryKey(userId);
		tblUser.setNickName(nickName);
		tblUser.setSex(sex);
		tblUser.setCity(city);
		tblUser.setCountry(country);
		tblUser.setProvince(province);
		tblUserMapper.updateByPrimaryKey(tblUser);
		return XoadoResult.ok();
	}
	@Override
	public XoadoResult update_id_user(String userId, String nickName, Long sex, String city, String country,
			String province, HttpServletRequest request) {
		TblUser tblUser = tblUserMapper.selectByPrimaryKey(userId);
		tblUser.setNickName(nickName);
		tblUser.setSex(sex);
		tblUser.setCity(city);
		tblUser.setCountry(country);
		tblUser.setProvince(province);
		tblUserMapper.updateByPrimaryKey(tblUser);
		return XoadoResult.ok();
	}

	
	@Override
	public XoadoResult update_user_headimgurl(String headImgUrl, HttpServletRequest request) {
		AccessIdentity token =(AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String userId = token.getUserId();
		TblUser tblUser = tblUserMapper.selectByPrimaryKey(userId);
		tblUser.setHeadImgUrl(headImgUrl);
		tblUserMapper.updateByPrimaryKey(tblUser);
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult update_type(String accounttype, HttpServletRequest request) {
		AccessIdentity token =(AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String userId = token.getUserId();
		TblUser tblUser = tblUserMapper.selectByPrimaryKey(userId);
		tblUser.setAccounttype(accounttype);
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult update_id_type(String userId, String accounttype, HttpServletRequest request) {
		TblUser tblUser = tblUserMapper.selectByPrimaryKey(userId);
		tblUser.setAccounttype(accounttype);
		tblUserMapper.updateByPrimaryKey(tblUser);
		return XoadoResult.ok();
	}





	
	
	

}
