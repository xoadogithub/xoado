package com.xoado.organize.controller;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.common.MD5;
import com.xoado.common.XoadoResult;
import com.xoado.organize.service.IApiInteface;
import com.xoado.protocol.Apistatus;


/**
* @author 作者
* @version 创建时间：2018年6月4日 上午11:03:49
* 类说明
*/
@Controller
@RequestMapping("/apis")
public class UApiInteface {
	
	@Autowired
	private IApiInteface apiInteface;
//	b)	[get] /apis		获得接口列表
	@RequestMapping(value="",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult sele_apiInteface(@RequestParam ("page") int page,
			@RequestParam ("rows") int rows,HttpServletRequest request){
			XoadoResult result = apiInteface.sele_apiInteface(page,rows,request);
			return result;
	}
	@RequestMapping(value="{id}/apis",method=RequestMethod.GET)
	@ResponseBody
	public XoadoResult sele_id_apiInteface(@PathVariable("id") String apiId,HttpServletRequest request){
		XoadoResult result = apiInteface.sele_id_apiInteface(apiId, request);
		return result;
	}
	
//	a)	[post] /apis		创建新的接口
	@RequestMapping(value="" ,method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult apiinteface_add(String appId, String apiPath, Long requestMethod, String header,
			String description, String parameter, String apistatus, String auditstatus) {
			XoadoResult result = apiInteface.apiinteface_add(appId, apiPath, requestMethod, header, description, parameter);
			return result;
	}
//	修改指定的接口信息
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult apiid_update(@PathVariable("id") String apiId, String apiPath, Long requestMethod, String header, String description,
			String parameter){
		XoadoResult result = apiInteface.apiid_update(apiId, apiPath, requestMethod, header, description, parameter);
		return result;	
	}
	@RequestMapping(value="/upid",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult apiidupdate(@RequestParam("apiId") String apiId, String apiPath, Long requestMethod, String header, String description,
			String parameter){
		XoadoResult result = apiInteface.apiid_update(apiId, apiPath, requestMethod, header, description, parameter);
		return result;
	}
//	d)	[put] /apis /{id}/states			修改指定的接口状态
	@RequestMapping(value="/{id}/states",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult apiid_update_status(@PathVariable("id") String apiId,String apistatus,HttpServletRequest request){
		XoadoResult result = apiInteface.apiid_update_status(apiId, apistatus, request);
		return result;	
	}
	@RequestMapping(value="/states",method=RequestMethod.PUT)
	@ResponseBody
	public XoadoResult apiid_updatestatus(@RequestParam("apiId") String apiId,String apistatus,HttpServletRequest request){
		XoadoResult result = apiInteface.apiid_update_status(apiId, apistatus, request);
		return result;	
	}	
//	f)	[put] /apis/{id}/package/{appid}  把选择的API加入到当前指定应用的开发包里
	@RequestMapping(value="/{id}/package/{appId}",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult api_package_add(@PathVariable("id") String apiId,
			@PathVariable("appId") String appId,
			@RequestParam("description") String description, HttpServletRequest request){
		XoadoResult result = apiInteface.api_package_add(apiId, appId, description, request);
		return result;
	}
//	g)	[delete] /apis/{id}/package/{appid}  把选择的API从指定应用的开发包里去除
	@RequestMapping(value="{id}/package/{appId}",method=RequestMethod.DELETE)
	@ResponseBody
	public XoadoResult api_package_dele(@PathVariable("id") String apiId,@PathVariable("appId") String appId, HttpServletRequest request){
		XoadoResult result = apiInteface.api_package_dele(apiId, appId, request);
		return result;
	}
	/**
	 * 查看枚举，状态
	 */
	@RequestMapping("/apistatus")
	@ResponseBody
	public XoadoResult apistatus(){
		
		Integer stauts = Apistatus.API_OPEN.getStauts();
		String describe2 = Apistatus.API_OPEN.getDescribe();
		Integer stauts2 = Apistatus.API_CLOSE.getStauts();
		String describe = Apistatus.API_CLOSE.getDescribe();
		HashMap<Object,Object> map = new HashMap<>();
		map.put(stauts, describe2);
		map.put(stauts2, describe);
		return XoadoResult.build(200, "账户类型",map);
	}
	public static void main(String[] args) {
		String uuid = MD5.MD5Encode(UUID.randomUUID().toString());
		System.out.println(uuid);
	}

}
