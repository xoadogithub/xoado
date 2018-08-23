package com.xoado.organize.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xoado.common.MD5;
import com.xoado.common.XoadoResult;
import com.xoado.organize.bean.TblOrgPermissions;
import com.xoado.organize.bean.TblOrgPermissionsExample;
import com.xoado.organize.bean.TblOrgPermissionsExample.Criteria;
import com.xoado.organize.mapper.TblOrgPermissionsMapper;
import com.xoado.organize.pojo.Actor;
import com.xoado.organize.service.IPermissions;


@Service
public class Permissions implements IPermissions{
	
	@Autowired
	private TblOrgPermissionsMapper tblOrgPermissionsMapper;

	
	
	@Override
	public XoadoResult select(int page, int rows, String organizeid,HttpServletRequest request, HttpServletResponse response) {
		
		if(organizeid==null){
			
			return XoadoResult.build(400, "错误", null);
		}
		PageHelper.startPage(page, rows);
		TblOrgPermissionsExample example = new TblOrgPermissionsExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizeidEqualTo(organizeid);
		List<TblOrgPermissions> list = tblOrgPermissionsMapper.selectByExample(example);
		
		PageInfo<TblOrgPermissions> pageInfo = new PageInfo<>(list);
		
		for (TblOrgPermissions tblOrgPermissions : list) {
			response.setCharacterEncoding("text/html,charset=utf-8");
			String a = (String)tblOrgPermissions.getPermissions();
			JsonObject obj = new JsonParser().parse(a).getAsJsonObject();
			
			Actor actor = new Gson().fromJson(obj, Actor.class);
			for (Map map : actor.getModules()) {
				
				System.out.println(map.get("REMARK"));
				System.out.println(map.get("FIELDS"));
				System.out.println(map.get("MODULE"));
				System.out.println(map.get("ACTIONS"));
			}
		}
		return XoadoResult.build(200, "返回所属组织的权限",pageInfo);
	}

	@Override
	public XoadoResult permissions_register(String organizeid, String name, Object permissions, String createrid,HttpServletRequest request) {

		TblOrgPermissions tblOrgPermissions = new TblOrgPermissions();
		tblOrgPermissions.setCreaterid(createrid);
		tblOrgPermissions.setCreateTime(new Date());
		tblOrgPermissions.setName(name);
		tblOrgPermissions.setOrganizeid(organizeid);
		tblOrgPermissions.setPermissions(permissions);
		tblOrgPermissions.setPermissionsid(MD5.MD5Encode(UUID.randomUUID().toString()));
		tblOrgPermissionsMapper.insert(tblOrgPermissions);
		return XoadoResult.ok();
	}


	
}
