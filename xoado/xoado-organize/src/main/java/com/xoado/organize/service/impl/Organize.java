package com.xoado.organize.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xoado.common.MD5;
import com.xoado.common.XoadoResult;
import com.xoado.organize.bean.TblOrganize;

import com.xoado.organize.bean.TblOrganizeExample;
import com.xoado.organize.bean.TblOrganizeExample.Criteria;

import com.xoado.organize.mapper.TblOrganizeMapper;
import com.xoado.organize.pojo.OrganizeXoadoT;
import com.xoado.organize.service.IOrganizeMember;
import com.xoado.organize.service.IOrganizeService;
import com.xoado.protocol.AccessIdentity;
import com.xoado.protocol.BaseRetCode;
import com.xoado.protocol.OrganizeType;
import com.xoado.protocol.XoadoConstant;

@Service
public class Organize implements IOrganizeService {
	
	@Autowired
	private TblOrganizeMapper organizeMapper;
	
	@Autowired
	private IOrganizeMember iOrganizeMember;
	
	@Value("${XOADO_IMAGE}")
	private String XOADO_IMAGE;
	
	@Value("${XOADO_ORGANIZE_LOGO}")
	private String XOADO_ORGANIZE_LOGO;
	
	@Value("${XOADO_URL}")
	private String XOADO_URL;


	@Override
	public XoadoResult register(String organizeName, String address,String telephone,Integer orgId,String scode,String usci,HttpServletRequest request) {
		AccessIdentity token = (AccessIdentity) request.getSession().getAttribute(XoadoConstant.XOADOTOKEN);
		String userId = token.getUserId();
		try {	
		
		TblOrganize organize = new TblOrganize();
		organize.setOrganizeid(MD5.MD5Encode(UUID.randomUUID().toString()));
		organize.setOrganizeName(organizeName);
		organize.setCreaterid(userId);
		organize.setCreateTime(new Date());
		organize.setLogoUrl(null);
		organize.setAddress(address);
		organize.setTelephone(telephone);
		organize.setOrgtype(Organize.getUserOrgType(orgId));
		organize.setOrgstatus("CONTROLLED");
		organize.setScode(scode);
		organize.setUsci(usci);
		organize.setBusinessLicenseImgUrl(null);
		organize.setMessage(null);
		organize.setAuditTime(null);
		organizeMapper.insert(organize);
		} catch (Exception e) {
			
		}
		return XoadoResult.ok();
	}

	@Override
	public XoadoResult select_user(int page, int rows, HttpServletRequest request) {
//		查询中间表tbl_organize_member,获取到对应的服务组织id
		List<String> list2 = iOrganizeMember.select(page, rows, request);
//		新建一个list集合便于返回
		if(list2==null){
			return XoadoResult.build(400, "list为空");
		}
		List<Object> list3 = new ArrayList<>();
//		遍历list集合
		for (String organizeid : list2) {
//		启动分页插件
			PageHelper.startPage(page, rows);
//		使用organizeid查询列表	
			TblOrganizeExample example = new TblOrganizeExample();
			Criteria criteria = example.createCriteria();
			criteria.andOrganizeidEqualTo(organizeid);
			List<TblOrganize> list = organizeMapper.selectByExample(example);
//			将查出来的列表存到分页信息
			PageInfo<TblOrganize> pageInfo = new PageInfo<>(list);
//			将分页中的集合进行遍历
			List<TblOrganize> list4 = pageInfo.getList();
//			存入list3集合
			for (TblOrganize tblOrganize : list4) {
				list3.add(tblOrganize);
			}
		}
		return XoadoResult.build(200, "展示全部",list3);
	}
//	all
	@Override
	public XoadoResult select(int page, int rows, HttpServletRequest request) {
//		分页
		PageHelper.startPage(page, rows);
		TblOrganizeExample example = new TblOrganizeExample();
		List<TblOrganize> list = organizeMapper.selectByExample(example);
		List<OrganizeXoadoT> xoado_list = new ArrayList<>();
		PageInfo<TblOrganize> pageInfo = new PageInfo<>(list);
		List<TblOrganize> list2 = pageInfo.getList();
		for (TblOrganize tblOrganize : list2) {
			OrganizeXoadoT xoado = new OrganizeXoadoT();
			xoado.setOrganizeid(tblOrganize.getOrganizeid());
			xoado.setOrganizeName(tblOrganize.getOrganizeName());
			xoado_list.add(xoado);
		}
		return XoadoResult.build(200, "返回值",xoado_list);
	}
 
	@Override
	public XoadoResult organizeParticulars(String organizeId,HttpServletRequest request) {
		TblOrganizeExample example = new TblOrganizeExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizeidEqualTo(organizeId);
		List<TblOrganize> list = organizeMapper.selectByExample(example);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),list);
	}
	
	@Override
	public XoadoResult get_logo(String organizeId,HttpServletRequest request) {
		TblOrganize tblOrganize = organizeMapper.selectByPrimaryKey(organizeId);
		String url = tblOrganize.getLogoUrl();
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),url);
	}
	
	@Override
	public XoadoResult dele_organize(String organizeId,HttpServletRequest request) {
		organizeMapper.deleteByPrimaryKey(organizeId);
		return XoadoResult.ok();
	}
	
	/**
	 * 更新组织logo
	 */
	@Override
	public XoadoResult update_organize_logo(String organizeId,MultipartFile logoUrl, HttpServletRequest request) {
		
		String newlogoUrlName = XOADO_ORGANIZE_LOGO +UUID.randomUUID()+logoUrl.getOriginalFilename();
		
		File file = new File(XOADO_IMAGE+XOADO_ORGANIZE_LOGO);
		
		if(!file.exists()){
			
			file.mkdirs();
			
		}
		
		File newlogoUrl = new File(XOADO_IMAGE+newlogoUrlName);
		
		try {
			logoUrl.transferTo(newlogoUrl);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TblOrganize tblOrganize = organizeMapper.selectByPrimaryKey(organizeId);
		
		tblOrganize.setLogoUrl(XOADO_URL+newlogoUrlName);
		
		organizeMapper.updateByPrimaryKey(tblOrganize);
		
		return XoadoResult.ok();
	}
	
	
	@Override
	public XoadoResult update_organize(String organizeId,String organizeName, String address, String telephone, String scode,HttpServletRequest request) {
		TblOrganize tblOrganize = organizeMapper.selectByPrimaryKey(organizeId);
		tblOrganize.setOrganizeName(organizeName);
		tblOrganize.setAddress(address);
		tblOrganize.setTelephone(telephone);
		tblOrganize.setScode(scode);
		organizeMapper.updateByPrimaryKey(tblOrganize);
		return XoadoResult.ok();
	}
	
	@Override
	public XoadoResult update_organize_orgstatus(String organizeId, String orgstatus, HttpServletRequest request) {
		TblOrganize tblOrganize = organizeMapper.selectByPrimaryKey(organizeId);
		tblOrganize.setOrgstatus(orgstatus);
		organizeMapper.updateByPrimaryKey(tblOrganize);
		return XoadoResult.ok();
	}
	
	/**
	 * 获取页面的组织类型
	 */
	public static String getUserOrgType(Integer orgId){
		for (OrganizeType e : OrganizeType.values()) {
			if(e.getStauts().equals(orgId)){
				
				return e.toString();
			}
		}
		return null;
	}


}
