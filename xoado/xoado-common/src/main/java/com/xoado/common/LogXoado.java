package com.xoado.common;

public class LogXoado {
	
	private String host;
	
	private String addr;
	
	private int port;
	
	private String user;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LogXoado [host=" + host + ", addr=" + addr + ", port=" + port + ", user=" + user + "]";
	}

	

	
	

}
