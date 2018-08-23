package com.xoado.authcenter.service.Iuser;

import javax.servlet.http.HttpServletRequest;

import com.xoado.common.XoadoResult;

/**
* @author 作者
* @version 创建时间：2018年8月8日 下午3:47:32
* 类说明
*/
public interface IXdQRcode {
	/**
	 * 创建一个二维码
	 * @param QRcode K
	 * @param Data	 V
	 * @return
	 * @throws Exception
	 */
	XoadoResult createQRcode(String QRcoda,String Data,HttpServletRequest request) throws Exception;
	/**
	 * 扫描二维码更新标志
	 * @param QRcode
	 * @param Date
	 * @return
	 * @throws Exception
	 */
	XoadoResult scannedQRcode(String QRcoda,String Date,HttpServletRequest request) throws Exception;
	/**
	 * 创建端不断查询是否被扫描过
	 * @param QRcode
	 * @return
	 */
	XoadoResult ThequeryScannedQrcode(String QRcode,HttpServletRequest request);
	/**
	 * 接收方得到业务确认收到
	 * @param QRcode
	 * @param request
	 * @return
	 */
	XoadoResult TheReceiverGetData(String QRcode,HttpServletRequest request);
	/**
	 * 扫描后交件方不断查询对方是否已经确认接收
	 * @param QRcode
	 * @param request
	 * @return
	 */
	XoadoResult HandOverThequery(String QRcode,HttpServletRequest request);
}
