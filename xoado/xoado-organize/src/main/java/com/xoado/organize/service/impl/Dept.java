package com.xoado.organize.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xoado.common.JsonUtils;

import com.xoado.common.XoadoResult;
import com.xoado.organize.bean.TblOrganizeDept;
import com.xoado.organize.bean.TblOrganizeDeptExample;
import com.xoado.organize.bean.TblOrganizeDeptExample.Criteria;
import com.xoado.organize.bean.TblOrganizeMember;
import com.xoado.organize.bean.TblOrganizeMemberExample;
import com.xoado.organize.mapper.TblOrganizeDeptMapper;
import com.xoado.organize.mapper.TblOrganizeMemberMapper;
import com.xoado.organize.service.IDept;
import com.xoado.protocol.BaseRetCode;


@Service
public class Dept implements IDept{
	@Autowired
	private TblOrganizeDeptMapper tblOrganizeDeptMapper;
	@Autowired
	private TblOrganizeMemberMapper tblOrganizeMemberMapper;
	
	
	
	@Override
	public XoadoResult id_dept_all(String organizeId,HttpServletRequest request) {
		TblOrganizeDeptExample example = new TblOrganizeDeptExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizeidEqualTo(organizeId);
		List<TblOrganizeDept> list = tblOrganizeDeptMapper.selectByExample(example);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),list);
	}
	
	@Override
	public XoadoResult id_deptDetails(String deptId,HttpServletRequest request) {
		TblOrganizeDept dept = tblOrganizeDeptMapper.selectByPrimaryKey(deptId);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),dept);
	}
	
	@Override
	public XoadoResult dele_id_dept(String deptId,HttpServletRequest request) {
		tblOrganizeDeptMapper.deleteByPrimaryKey(deptId);
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult id_dept_users(String deptId,HttpServletRequest request) {
		TblOrganizeDept dept = tblOrganizeDeptMapper.selectByPrimaryKey(deptId);
		Object member = dept.getMember();
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),member);
	}
	
	@Override
	public XoadoResult id_dept(String organizeId,String deptName,String managerid,Object member,String createrid, HttpServletRequest request) {
		
		TblOrganizeDept dept = new TblOrganizeDept();
		dept.setOrganizeid(organizeId);
		dept.setDeptid(UUID.randomUUID().toString());
		dept.setDeptName(deptName);
		dept.setManagerid(managerid);
		dept.setManagerid(managerid);
		dept.setCreaterid(createrid);
		dept.setCreateTime(new Date());
		tblOrganizeDeptMapper.insert(dept);
		
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult update_dept(String deptId,String deptName, Object member,HttpServletRequest request) {
		TblOrganizeDept dept = tblOrganizeDeptMapper.selectByPrimaryKey(deptId);
		dept.setDeptName(deptName);
		dept.setMember(member);
		tblOrganizeDeptMapper.updateByPrimaryKey(dept);
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult update_dapt_managerId(String deptId, String managerid,HttpServletRequest request) {
		TblOrganizeDept dept = tblOrganizeDeptMapper.selectByPrimaryKey(deptId);
		dept.setManagerid(managerid);
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult dept_member_add(String deptId,Object member, HttpServletRequest request) {

		TblOrganizeDept dept = tblOrganizeDeptMapper.selectByPrimaryKey(deptId);
//		获取到数据库的json数组
		Object user = dept.getMember();
		System.out.println(user);
//		将json转换成string
		String string = JsonUtils.objectToJson(user);
//		截取字符串
		String substring = string.substring(1, string.length()-1);
		String substring2 = substring.substring(1, substring.length()-1);
//		将客户端传来的进行拼接
		String newuser = "\""+"["+substring2+","+member+"]"+"\"";
//		拼接完成转成json数组
		Object parse = JSON.parse(newuser);
//		存入实体类
		dept.setMember(parse);
//		更新
		tblOrganizeDeptMapper.updateByPrimaryKey(dept);
		return XoadoResult.ok();
	}

	
	public XoadoResult test(){
		return null;
		/*
		String deptId = "999999";
		TblOrganizeDept dept = tblOrganizeDeptMapper.selectByPrimaryKey(deptId);
		Object user = dept.getMember();
		Map<String, Object> map1 = JSON.parseObject((String) user);  
		List<String> a = (List) map1.get("userid");
//		a.remove("123");
		a.add("18292967656");
		String jsonString = JSON.toJSONString(map1);
		dept.setMember(jsonString);
		tblOrganizeDeptMapper.updateByPrimaryKey(dept);
		return XoadoResult.build(200, "",user);
		*/
	}
//	27.	[put] base/organizations/depts/members   成员换部门,角色不变
	@Override
	public XoadoResult update_id_dept(String YdeptId, String XdeptId, String userId, HttpServletRequest request) {
		TblOrganizeDept tblOrganizeDept = tblOrganizeDeptMapper.selectByPrimaryKey(YdeptId);
		Object member = tblOrganizeDept.getMember();
		Map<String,Object> map = JSON.parseObject((String)member);
		List<String> list =(List) map.get("userid");
		list.remove(userId);
		String jsonString = JSON.toJSONString(map);
		tblOrganizeDept.setMember(jsonString);
		int i = tblOrganizeDeptMapper.updateByPrimaryKey(tblOrganizeDept);
		
		
		TblOrganizeDept newtblOrganizeDept = tblOrganizeDeptMapper.selectByPrimaryKey(XdeptId);
		Object newmember = tblOrganizeDept.getMember();
		Map<String,Object> newmap = JSON.parseObject((String)newmember);
		List<String> newlist =(List) map.get("userid");
		list.add(userId);
		String newjsonString = JSON.toJSONString(map);
		newtblOrganizeDept.setMember(newjsonString);
		int j = tblOrganizeDeptMapper.updateByPrimaryKey(newtblOrganizeDept);
		return XoadoResult.ok();
	}
//	增加组织成员
	@Override
	public XoadoResult orgAddmember(String organizeId, String userId, String role, Long parttimejob, Date joinTime) {
		TblOrganizeMember member = new TblOrganizeMember();
		member.setOrganizeid(organizeId);
		member.setUserid(userId);
		member.setRole(role);
		member.setParttimejob(parttimejob);
		member.setJoinTime(new Date());
		tblOrganizeMemberMapper.insert(member);
		return XoadoResult.ok();
	}
//	30.	[delete] base/organizations/{id}/role        组织成员撤销管理角色
	@Override
	public XoadoResult update_org_role(String userId, String role, HttpServletRequest request) {
		TblOrganizeMemberExample example = new TblOrganizeMemberExample();
		com.xoado.organize.bean.TblOrganizeMemberExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<TblOrganizeMember> list = tblOrganizeMemberMapper.selectByExample(example);
		
		for (TblOrganizeMember tblOrganizeMember : list) {
			tblOrganizeMember.setRole(role);
			tblOrganizeMemberMapper.updateByPrimaryKey(tblOrganizeMember);
		}
		return XoadoResult.ok();
	}

	


}
