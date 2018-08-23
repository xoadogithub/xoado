package com.xoado.protocol;


import java.util.List;



public class AccessIdentity {

	private String tokenId;
	
	private String userId;
	
	private String userName;
	
	private long date;
	
	private String userType;
	
	private String openId;
	

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public static AccessIdentity add(String token){
//		System.out.println("请求过来的参数"+token);
		AccessIdentity ad = new AccessIdentity();
		/*
		ad.setDate(new Date().getTime());
		ad.setTokenId("123456798");
		ad.setUserId("987654321");
		ad.setUserName("zhangsan");
		ad.setUserType("正常");
		*/
		
		
		List<AccessIdentity> list = JsonUtils.jsonToList(token, AccessIdentity.class);
		for (AccessIdentity accessIdentity : list) {
			ad.setDate(accessIdentity.getDate());
			ad.setTokenId(accessIdentity.getTokenId());
			ad.setUserId(accessIdentity.getUserId());
			ad.setUserName(accessIdentity.getUserName());
			ad.setUserType(accessIdentity.getUserType());
		}
//		AccessIdentity pojo = JsonUtils.jsonToPojo(token, AccessIdentity.class);
//		System.out.println(pojo);
//		long a = pojo.getDate();
//		System.out.println("data:"+a);

	
		
		return ad;
		
	}

	@Override
	public String toString() {
		return "AccessIdentity [tokenId=" + tokenId + ", userId=" + userId + ", userName=" + userName + ", date=" + date
				+ ", userType=" + userType + "]";
	}
	
}
