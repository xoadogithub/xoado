package com.xoado.wx.wxbean;
/**
* @author 作者
* @version 创建时间：2018年6月19日 下午2:04:34
* 类说明
*/
public class WxUser {
	
	private Object openid;
	
	private Object nickname;
	
	private Object sex;
	
	private Object province;
	
	private Object city;
	
	private Object country;
	
	private Object headimgurl;
	
	private Object privilege;
	
	private Object unionid;

	public Object getOpenid() {
		return openid;
	}

	public void setOpenid(Object openid) {
		this.openid = openid;
	}

	public Object getNickname() {
		return nickname;
	}

	public void setNickname(Object nickname) {
		this.nickname = nickname;
	}

	public Object getSex() {
		return sex;
	}

	public void setSex(Object sex) {
		this.sex = sex;
	}

	public Object getProvince() {
		return province;
	}

	public void setProvince(Object province) {
		this.province = province;
	}

	public Object getCity() {
		return city;
	}

	public void setCity(Object city) {
		this.city = city;
	}

	public Object getCountry() {
		return country;
	}

	public void setCountry(Object country) {
		this.country = country;
	}

	public Object getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(Object headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Object getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Object privilege) {
		this.privilege = privilege;
	}

	public Object getUnionid() {
		return unionid;
	}

	public void setUnionid(Object unionid) {
		this.unionid = unionid;
	}

	@Override
	public String toString() {
		return "WxUser [openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + ", province=" + province
				+ ", city=" + city + ", country=" + country + ", headimgurl=" + headimgurl + ", privilege=" + privilege
				+ ", unionid=" + unionid + "]";
	}
	
	

}
