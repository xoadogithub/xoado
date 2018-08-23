package com.xoado.organize.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xoado.client.http.Paging;
import com.xoado.common.MD5;
import com.xoado.common.XoadoResult;
import com.xoado.organize.bean.TblApiInteface;
import com.xoado.organize.bean.TblApiIntefaceExample;
import com.xoado.organize.bean.TblAppInformation;
import com.xoado.organize.bean.TblAppPackage;
import com.xoado.organize.bean.TblAppPackageExample;
import com.xoado.organize.bean.TblAppPackageExample.Criteria;
import com.xoado.organize.mapper.TblApiIntefaceMapper;
import com.xoado.organize.mapper.TblAppInformationMapper;
import com.xoado.organize.mapper.TblAppPackageMapper;
import com.xoado.organize.pojo.ApiPath;
import com.xoado.organize.service.IApiInteface;
import com.xoado.protocol.BaseRetCode;

/**
* @author 作者
* @version 创建时间：2018年6月4日 下午2:23:37
* 类说明
*/
@Service
public class ApiInteface implements IApiInteface {
	
	@Autowired
	private TblApiIntefaceMapper apiIntefaceMapper;
	@Autowired
	private TblAppInformationMapper tblAppInformationMapper;
	@Autowired
	private TblAppPackageMapper packageMapper;

	@Override
	public XoadoResult apiinteface_add(String appId, String apiPath, Long requestMethod, String header,
			String description, String parameter) {
		
		TblApiInteface inteface = new TblApiInteface();
		inteface.setApiId(MD5.MD5Encode(UUID.randomUUID().toString()));
		inteface.setApiPath(apiPath);
		inteface.setApistatus(null);
		inteface.setAppId(appId);
		inteface.setAuditstatus(null);
		inteface.setDescription(description);
		inteface.setHeader(header);
		if(parameter!=""){
			inteface.setParameter("?"+parameter);
			inteface.setRequestMethod(requestMethod);
			inteface.setCreatetime(new Date());
			apiIntefaceMapper.insert(inteface);
		}else{
			inteface.setParameter(null);
			inteface.setRequestMethod(requestMethod);
			inteface.setCreatetime(new Date());
			apiIntefaceMapper.insert(inteface);
			
		}
		
		
		return XoadoResult.ok();
	}

	@Override
	public XoadoResult apiid_update(String apiId, String apiPath, Long requestMethod, String header, String description,
			String parameter) {
		
		TblApiInteface tblApiInteface = apiIntefaceMapper.selectByPrimaryKey(apiId);
		tblApiInteface.setApiId(apiId);
		tblApiInteface.setApiPath(apiPath);
		tblApiInteface.setRequestMethod(requestMethod);
		tblApiInteface.setHeader(header);
		tblApiInteface.setDescription(description);
		tblApiInteface.setParameter(parameter);
		tblApiInteface.setApistatus(tblApiInteface.getAuditstatus());
		tblApiInteface.setAuditstatus(tblApiInteface.getAuditstatus());
		tblApiInteface.setCreatetime(tblApiInteface.getCreatetime());
		apiIntefaceMapper.updateByPrimaryKey(tblApiInteface);
		return XoadoResult.ok();
	}

	@Override
	public XoadoResult apiid_update_status(String apiId,String apistatus,HttpServletRequest request) {
		TblApiInteface tblApiInteface = apiIntefaceMapper.selectByPrimaryKey(apiId);
		tblApiInteface.setApistatus(apistatus);
		apiIntefaceMapper.updateByPrimaryKey(tblApiInteface);
		return XoadoResult.ok();
	}

	@Override
	public XoadoResult sele_apiInteface(int page, int rows, HttpServletRequest request) {
		TblApiIntefaceExample example = new TblApiIntefaceExample();
		PageHelper.startPage(page, rows);
		List<TblApiInteface> list = apiIntefaceMapper.selectByExample(example);
		Paging resule = new  Paging();
		resule.setRows(list);
		ArrayList<ApiPath> apiList = new ArrayList<ApiPath>();
		PageInfo<TblApiInteface> info = new PageInfo<>(list);
		resule.setTotal(info.getTotal());
		List<TblApiInteface> list2 = info.getList();
		for (TblApiInteface tblApiInteface : list2) {
			ApiPath path = new ApiPath();
			path.setApiId(tblApiInteface.getApiId());
			String appId = tblApiInteface.getAppId();
			path.setAppId(appId);
			String apipath = tblApiInteface.getApiPath();
			path.setApiPath(apipath);
			path.setHeader(tblApiInteface.getHeader());
			path.setDescription(tblApiInteface.getDescription());
			String parameter = tblApiInteface.getParameter();
			path.setParameter(parameter);
			path.setApistatus(tblApiInteface.getApistatus());
			path.setAuditstatus(tblApiInteface.getAuditstatus());
			Date date = tblApiInteface.getCreatetime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String format = dateFormat.format(date);
			path.setCreatetime(format);
			
			TblAppInformation key = tblAppInformationMapper.selectByPrimaryKey(appId);
			String domain = key.getAppDomain();
			String a =domain+ apipath+parameter;
			path.setPath(a);
			apiList.add(path);
		}
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), apiList);
		
	}

	@Override
	public XoadoResult sele_id_apiInteface(String apiId, HttpServletRequest request) {
		TblApiInteface tblApiInteface = apiIntefaceMapper.selectByPrimaryKey(apiId);
		ApiPath path = new ApiPath();
		path.setApiId(tblApiInteface.getApiId());
		String appId = tblApiInteface.getAppId();
		path.setAppId(appId);
		String apipath = tblApiInteface.getApiPath();
		path.setApiPath(apipath);
		path.setHeader(tblApiInteface.getHeader());
		path.setDescription(tblApiInteface.getDescription());
		String parameter = tblApiInteface.getParameter();
		path.setParameter(parameter);
		path.setApistatus(tblApiInteface.getApistatus());
		path.setAuditstatus(tblApiInteface.getAuditstatus());
		Date date = tblApiInteface.getCreatetime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String format = dateFormat.format(date);
		path.setCreatetime(format);
		TblAppInformation key = tblAppInformationMapper.selectByPrimaryKey(appId);
		String domain = key.getAppDomain();
		String a =domain+ apipath+parameter;
		path.setPath(a);
		
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(), path);
	}

	@Override
	public XoadoResult api_package_add(String apiId, String appId,String description, HttpServletRequest request) {
		TblAppPackage package3 = new TblAppPackage();
		package3.setApiId(apiId);
		package3.setAppId(appId);
		package3.setDescription(description);
		packageMapper.insert(package3);
		return XoadoResult.ok();
	}

	@Override
	public XoadoResult api_package_dele(String apiId, String appId, HttpServletRequest request) {
		TblAppPackageExample example = new TblAppPackageExample();
		Criteria criteria = example.createCriteria();
		criteria.andApiIdEqualTo(appId);
		packageMapper.deleteByExample(example);
		return XoadoResult.ok();
	}

}
