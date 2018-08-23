package com.xoado.organize.pojo;

import java.util.Date;

import com.xoado.organize.bean.TblUser;



/**
 * 实名认证所需的参数
 * @author 80665
 *
 */
public class Authentications {
	
	/**
	 * 手机
	 */
	private String Phone_number;   
	/**
	 * 姓名
	 */
	private String name;		   
	/**
	 * 注册时间
	 */
	private Date Register_time;  
	/**
	 * 性别
	 */
	private Long sex;
	/**
	 * 城市
	 */
	
	private String city;
	
	private String country;
	
	private String province;	
	
	private String IdCard;		
	
	private String Positive_img_url; 
	
	private String reverse_img_url; 
	
	private Date audit_Time;
	
	private String message;

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegister_time() {
		return Register_time;
	}

	public void setRegister_time(Date register_time) {
		Register_time = register_time;
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

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public String getPositive_img_url() {
		return Positive_img_url;
	}

	public void setPositive_img_url(String positive_img_url) {
		Positive_img_url = positive_img_url;
	}

	public String getReverse_img_url() {
		return reverse_img_url;
	}

	public void setReverse_img_url(String reverse_img_url) {
		this.reverse_img_url = reverse_img_url;
	}

	public Date getAudit_Time() {
		return audit_Time;
	}

	public void setAudit_Time(Date audit_Time) {
		this.audit_Time = audit_Time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Authentications [Phone_number=" + Phone_number + ", name=" + name + ", Register_time=" + Register_time
				+ ", sex=" + sex + ", city=" + city + ", country=" + country + ", province=" + province + ", IdCard="
				+ IdCard + ", Positive_img_url=" + Positive_img_url + ", reverse_img_url=" + reverse_img_url
				+ ", audit_Time=" + audit_Time + ", message=" + message + "]";
	}
	
	
	public static Authentications inster(TblUser user){
		Authentications authentications2 = new Authentications();
			authentications2.setPhone_number(user.getPhoneNumber());
			authentications2.setName(user.getName());
			authentications2.setRegister_time(user.getRegisterTime());
			authentications2.setSex(user.getSex());
			authentications2.setCity(user.getCity());
			authentications2.setCountry(user.getCountry());
			authentications2.setProvince(user.getProvince());
			authentications2.setIdCard(user.getIdcard());
			authentications2.setAudit_Time(user.getAuditTime());
			authentications2.setMessage(user.getMessage());
			authentications2.setPositive_img_url(user.getPositiveImgUrl());
			authentications2.setReverse_img_url(user.getReverseImgUrl());		
		return authentications2;
		
	}
	
	

}
