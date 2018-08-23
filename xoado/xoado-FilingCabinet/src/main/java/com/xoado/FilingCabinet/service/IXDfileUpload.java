package com.xoado.FilingCabinet.service;

import com.xoado.common.XoadoResult;

public interface IXDfileUpload {
	
	XoadoResult uploadBase64(String archiveid,String base64text) throws Exception;

}
