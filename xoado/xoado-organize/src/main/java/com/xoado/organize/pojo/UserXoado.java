package com.xoado.organize.pojo;

public class UserXoado {
	
	private String userid;   

    private String phoneNumber;	

    private String name;	

    private String nickName;	

    private String headImgUrl;	

    private String accountstatus;	

    private Long sex;	

    private String city;	

    private String country;		

    private String province;	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

	@Override
	public String toString() {
		return "Tbluser_xoado [userid=" + userid + ", phoneNumber=" + phoneNumber + ", name=" + name + ", nickName="
				+ nickName + ", headImgUrl=" + headImgUrl + ", accountstatus=" + accountstatus + ", sex=" + sex
				+ ", city=" + city + ", country=" + country + ", province=" + province + "]";
	}



}
