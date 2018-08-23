package com.xoado.organize.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoado.common.XoadoResult;
import com.xoado.organize.bean.TblOrganizeMember;
import com.xoado.organize.bean.TblOrganizeMemberExample;
import com.xoado.organize.bean.TblOrganizeMemberExample.Criteria;

import com.xoado.organize.mapper.TblOrganizeMemberMapper;
import com.xoado.organize.service.IOrganizeMember;
import com.xoado.protocol.AccessIdentity;
import com.xoado.protocol.BaseRetCode;

import com.xoado.protocol.XoadoConstant;



@Service
public class Organizemember implements IOrganizeMember{
	
	@Autowired
	private TblOrganizeMemberMapper organizeMemberMapper;

	@Override
	public List<String> select(int page, int rows, HttpServletRequest request) {
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String userId = token.getUserId();
			TblOrganizeMemberExample example = new TblOrganizeMemberExample();
			Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(userId);
			List<TblOrganizeMember> list2 = organizeMemberMapper.selectByExample(example);
			List<String> list_user = new ArrayList<>();
			for (TblOrganizeMember tblOrganizeMember : list2) {
				String organizeid = tblOrganizeMember.getOrganizeid();
				list_user.add(organizeid);
			}
			return list_user;
		
	
	}
	
	@Override
	public XoadoResult get_organize_user(String organizeId,HttpServletRequest request) {
		TblOrganizeMemberExample example = new TblOrganizeMemberExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizeidEqualTo(organizeId);
		List<TblOrganizeMember> list = organizeMemberMapper.selectByExample(example);
	
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),list);
	}

}
