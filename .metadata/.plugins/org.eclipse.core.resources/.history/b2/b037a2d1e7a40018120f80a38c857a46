package com.xoado.tools.common;

import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.http.HttpSession;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class XoadoPhoneMessage{

//	阿里云通讯固定名称
	static final String product = "Dysmsapi";
//	阿里产品固定域名
	static final String domain = "dysmsapi.aliyuncs.com";
//	商家所属产品固定id密钥
	static final String accessKeyId = "LTAI61AqWIahEEVW";
	static final String accessKeySecret = "w2KiqlohOvq6nFYGPt4Xl7zH1cww7L";
//  业务逻辑
	public static SendSmsResponse sendSms(String text,String code,String phoneNumber,HttpSession session) throws ClientException{
		
		
			 System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
			 System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//			//初始化acsClient,暂不支持region化
			 IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
			 DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
			 IAcsClient acsClient = new DefaultAcsClient(profile);
			 SendSmsRequest request = new SendSmsRequest();
//			 需要验证码的手机
			 request.setPhoneNumbers(phoneNumber);
//			 短信签名格式 在短信控制台可见
			 request.setSignName(text);
//			 短信模板样式
			 request.setTemplateCode("SMS_117512635");
//			 生成一个6位数的验证码并进行保存
			 

//			  session.setAttribute(phoneNumber, code);
			  
			  request.setTemplateParam("{\"name\":\"Tom\", \"code\":\""+code+"\"}");
			 
			 request.setOutId("yourOutId");
			 
			 SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
			 
			return sendSmsResponse;
	
		
		
	}
	public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {
		
		 //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        
      //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        
        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber("18629544462");
        request.setBizId(bizId);
//		必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        request.setPageSize(10L);
        request.setCurrentPage(1L);
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
        return querySendDetailsResponse;	
	}
	 public static void Phone_code_test(String text,String code,String phoneNumber,HttpSession session) throws ClientException, InterruptedException {
		 SendSmsResponse response = sendSms(text,code,phoneNumber,session);
		 System.out.println("短信接口返回的数据----------------");
	     System.out.println("Code=" + response.getCode());
	     System.out.println("Message=" + response.getMessage());
         System.out.println("RequestId=" + response.getRequestId());
         System.out.println("BizId=" + response.getBizId());
         Thread.sleep(3000L);
         //查明细
         if(response.getCode() != null && response.getCode().equals("OK")) {
             QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId());
             System.out.println("短信明细查询接口返回数据----------------");
             System.out.println("Code=" + querySendDetailsResponse.getCode());
             System.out.println("Message=" + querySendDetailsResponse.getMessage());
             int i = 0;
             for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
             {
                 System.out.println("SmsSendDetailDTO["+i+"]:");
                 System.out.println("Content=" + smsSendDetailDTO.getContent());
                 System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                 System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                 System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                 System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                 System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                 System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                 System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
             }
             System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
             System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
         }

	 }
}
