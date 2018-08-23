package com.xoado.authcenter.service.user.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.xoado.authcenter.jedis.XoadoSession;
import com.xoado.authcenter.service.Iuser.IXdQRcode;
import com.xoado.common.ConvertUtil;
import com.xoado.common.XoadoResult;
import com.xoado.protocol.BaseRetCode;

import net.sf.json.JSONObject;

/**
* @author 作者
* @version 创建时间：2018年8月8日 下午3:52:54
* 类说明
*/
@Service
public class XdQRcode implements IXdQRcode{
	
	@Autowired
	private XoadoSession xoadoSession;

	@Override
	public XoadoResult createQRcode(String QRcode, String Data,HttpServletRequest request) throws Exception {
		/**
		 * 对象生成二维码有2种情况，第一种是交件方生成二维码 （携带Qrcode以及Data数据）
		 * 						     第二种是收件方生成二维码（携带Qrcode不携带Data数据）
		 */
		if(Data==""){Data=null;};
//		定义文件输出流
		InputStream in = null;
		OutputStream out = new ByteArrayOutputStream();
//		缓存中的数据
		JSONObject json = new JSONObject();
		json.put("qrcodestate", "new");
		json.put("Data", Data);
//		根据QRcode生成二维码
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("QRcode", QRcode);
//		定义二维码
	    int width = 200; // 图像宽度  
	    int height = 200; // 图像高度
	    String format = "png";// 图像类型  
	    Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
	    hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	    BitMatrix bitMatrix = new MultiFormatWriter().encode(jsonObject.toString(), BarcodeFormat.QR_CODE, width, height, hints);
	    MatrixToImageWriter.writeToStream(bitMatrix, format, out);
//	    outputStream 转intputstream
	    ConvertUtil convertUtil = new ConvertUtil();
	    in = convertUtil.parse(out);
	    byte[] bytes = new byte[in.available()]; in.read(bytes);
	    String encodeToString = Base64.getEncoder().encodeToString(bytes);
	    
	    xoadoSession.set(QRcode, json.toString());
	    xoadoSession.expire(QRcode, 60);
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),encodeToString);
	}

	/**
	 * 扫描更新分2种情况，第一种是收件方生成了一个携带有K的二维码标志为new，交件扫描二维码给K填充内容，并且更改标志位scanned
	 * 					  第二种是交件方生成一个携带有K，V的二维码，标志位new，收件方扫描后获取信息更改扫描标志为scanned
	 */
	@SuppressWarnings("unused")
	@Override
	public XoadoResult scannedQRcode(String QRcode, String Data,HttpServletRequest request) throws Exception {
//		Data没有值，从缓存中获取数据内容，收件方调用
		if(Data=="" || Data==null){
			String QRcodeValue = xoadoSession.get(QRcode);
			JSONObject jsonObject = JSONObject.fromObject(QRcodeValue);
			Object DataValue = jsonObject.get("Data");
			jsonObject.remove("qrcodestate");
			jsonObject.put("qrcodestate", "scanned");
			xoadoSession.set(QRcode, jsonObject.toString());
			xoadoSession.expire(QRcode, 60);
			
			return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),DataValue.toString());
		}
		if(Data!="" || Data!=null){
//			Data有值   写入缓存  交件方调用存储数据   1获取缓存中的QRcode
			String QRcodeValue = xoadoSession.get(QRcode);
			JSONObject jsonObject = JSONObject.fromObject(QRcodeValue);
			jsonObject.remove("qrcodestate");
			jsonObject.put("qrcodestate", "scanned");
			jsonObject.put("Data", Data);
			xoadoSession.set(QRcode, jsonObject.toString());
			xoadoSession.expire(QRcode, 60*5);
			return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),Data.toString());
		}
		return null;	
	}
	/**
	 * 创建端不断查询是否被扫描过
	 * @param QRcode
	 * @return
	 */
	@Override
	public XoadoResult ThequeryScannedQrcode(String QRcode, HttpServletRequest request) {
		
		try {
			String QRcodeValue = xoadoSession.get(QRcode);
			JSONObject fromObject = JSONObject.fromObject(QRcodeValue);
			Object qrcodestateValue = fromObject.get("qrcodestate");
			if(qrcodestateValue=="scanned"){
				return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg(),QRcodeValue.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return XoadoResult.build(201, "创建端查询到收件方未扫描",null);
	}
	/**
	 * 接收方得到业务确认收到
	 * @param QRcode
	 * @param request
	 * @return
	 */
	@Override
	public XoadoResult TheReceiverGetData(String QRcode, HttpServletRequest request) {
		try {
			String QRcodeValue = xoadoSession.get(QRcode);
			if(QRcodeValue==null){
				return XoadoResult.build(202, "");
			}
			JSONObject fromObject = JSONObject.fromObject(QRcodeValue);
			fromObject.remove("qrcodestate");
			fromObject.put("qrcodestate", "confirmed");
			xoadoSession.set(QRcode, fromObject.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	/**
	 * 扫描后交件方不断查询对方是否已经确认接收
	 * @param QRcode
	 * @param request
	 * @return
	 */
	@Override
	public XoadoResult HandOverThequery(String QRcode, HttpServletRequest request) {
		String QRcodeValue = xoadoSession.get(QRcode);
		JSONObject jsonObject = JSONObject.fromObject(QRcodeValue);
		Object qrcodestateValue = jsonObject.get("qrcodestate");
		if(qrcodestateValue.toString()!="confirmed"){
			return XoadoResult.build(201, "");
		}
		
		return XoadoResult.build(Integer.parseInt(BaseRetCode.CODE_SUCCESS.getRetCode()), BaseRetCode.CODE_SUCCESS.getRetMsg());
	}

}
