package com.xoado.authcenter.controller.users;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.authcenter.service.Iuser.IXdQRcode;
import com.xoado.common.XoadoResult;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
* @author 作者
* @version 创建时间：2018年8月8日 下午3:12:00
* 类说明
*/
@Controller
@RequestMapping("/qrcode")
public class UXdQRcode {
	
	@Autowired
	private IXdQRcode iXdQRcode;

	/**
	 * 创建一个新的二维码
	 * @param QRcode
	 * @param Data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/creating")
	@ResponseBody
	public XoadoResult createQRcode(@RequestParam("QRcode") String QRcode,@RequestParam(value="Data",required=true) String Data,HttpServletRequest request) throws Exception{
		
		XoadoResult result = iXdQRcode.createQRcode(QRcode, Data,request);
		
		return result;	
	}
	
	
	
}
