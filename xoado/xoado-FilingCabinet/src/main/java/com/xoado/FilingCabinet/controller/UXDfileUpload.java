package com.xoado.FilingCabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoado.FilingCabinet.service.IXDfileUpload;
import com.xoado.common.XoadoResult;

@Controller
@RequestMapping("/fileUpload")
public class UXDfileUpload {
	
	@Autowired
	private IXDfileUpload ixDfileUpload;
	
	@RequestMapping(value="/base64",method=RequestMethod.POST)
	@ResponseBody
	public XoadoResult uploadBase64(@RequestParam("archiveid") String archiveid,@RequestParam("base64text") String base64text) throws Exception{
		XoadoResult result = ixDfileUpload.uploadBase64(archiveid, base64text);
		return result;
	}


}
