package com.xoado.FilingCabinet.common;

import java.util.Date;

public class XDboex {
	
	private String boxid;
	
	private String boxname;
	
	private Object ownerorg;
	
	private String scopeofuse;
	
	private Object location;
	
	private String remarks;
	
	private String closestate;
	
	private Object creater;
	
	private Date creatertime;
	
	private Object shareto;
	
	private Object archives;

	public Object getArchives() {
		return archives;
	}

	public void setArchives(Object archives) {
		this.archives = archives;
	}

	public String getBoxid() {
		return boxid;
	}

	public void setBoxid(String boxid) {
		this.boxid = boxid;
	}

	public String getBoxname() {
		return boxname;
	}

	public void setBoxname(String boxname) {
		this.boxname = boxname;
	}

	public Object getOwnerorg() {
		return ownerorg;
	}

	public void setOwnerorg(Object ownerorg) {
		this.ownerorg = ownerorg;
	}

	public String getScopeofuse() {
		return scopeofuse;
	}

	public void setScopeofuse(String scopeofuse) {
		this.scopeofuse = scopeofuse;
	}

	public Object getLocation() {
		return location;
	}

	public void setLocation(Object location) {
		this.location = location;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getClosestate() {
		return closestate;
	}

	public void setClosestate(String closestate) {
		this.closestate = closestate;
	}

	public Object getCreater() {
		return creater;
	}

	public void setCreater(Object creater) {
		this.creater = creater;
	}

	public Date getCreatertime() {
		return creatertime;
	}

	public void setCreatertime(Date creatertime) {
		this.creatertime = creatertime;
	}

	public Object getShareto() {
		return shareto;
	}

	public void setShareto(Object shareto) {
		this.shareto = shareto;
	}

	@Override
	public String toString() {
		return "XDboex [boxid=" + boxid + ", boxname=" + boxname + ", ownerorg=" + ownerorg + ", scopeofuse="
				+ scopeofuse + ", location=" + location + ", remarks=" + remarks + ", closestate=" + closestate
				+ ", creater=" + creater + ", creatertime=" + creatertime + ", shareto=" + shareto + ", archives="
				+ archives + "]";
	}
	
	

}
