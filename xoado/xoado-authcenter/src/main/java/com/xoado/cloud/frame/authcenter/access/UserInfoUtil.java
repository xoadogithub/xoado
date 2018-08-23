package com.xoado.cloud.frame.authcenter.access;

public class UserInfoUtil {
	 //小程序的商户秘钥
//		private final static String AppId="wx6f286fd741748f68";    
//		private final static String AppSecret="e12c509305f5e511cd12da6b5adecc77";
		
	
	private final static String AppId="wxeadd48617e3768a5";    
	private final static String AppSecret="954e4c8a77fff5e621b2e3f3d87fcd85";
		public static String Get_Code="https://open.weixin.qq.com/connect/oauth2/authorize?"
				+ "appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";

	    public static String getCode(String APPID,String REDIRECT_URI,String SCOPE){
	    	return String.format(Get_Code, APPID,REDIRECT_URI,SCOPE);
	    	
	    }
	    //获取Web_access_tokenhttps的请求地址
		public static String Web_access_tokenhttps="https://api.weixin.qq.com/sns/jscode2session?"
				+ "appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
		
		public static String getWebAccess(String CODE){
			
			return String.format(Web_access_tokenhttps, AppId,AppSecret,CODE);
		}
		
		//拉取用户信息的请求地址
		public static String User_Message ="https://api.weixin.qq.com/sns/userinfo?"
				+ "access_token=%s&openid=%s&lang=zh_CN";
		
		public static String getUserMessage(String access_token,String openid){
			return String.format(User_Message, access_token,openid);
		}

		public static String getAppid() {
			return AppId;
		}

		public static String getAppsecret() {
			return AppSecret;
		}


}
