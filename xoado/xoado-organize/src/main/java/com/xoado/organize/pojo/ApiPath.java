package com.xoado.organize.pojo;

import java.util.Date;

/**
* @author 作者
* @version 创建时间：2018年6月4日 上午11:50:09
* 类说明
*/
public class ApiPath {
	
		private String apiId;

	    private String appId;

	    private String apiPath;

	    private Long requestMethod;

	    private String header;

	    private String description;

	    private String parameter;

	    private String apistatus;

	    private String auditstatus;
	    
	    private String path;
	    
	    private String createtime;

		public String getApiId() {
			return apiId;
		}

		public void setApiId(String apiId) {
			this.apiId = apiId;
		}

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getApiPath() {
			return apiPath;
		}

		public void setApiPath(String apiPath) {
			this.apiPath = apiPath;
		}

		public Long getRequestMethod() {
			return requestMethod;
		}

		public void setRequestMethod(Long requestMethod) {
			this.requestMethod = requestMethod;
		}

		public String getHeader() {
			return header;
		}

		public void setHeader(String header) {
			this.header = header;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getParameter() {
			return parameter;
		}

		public void setParameter(String parameter) {
			this.parameter = parameter;
		}

		public String getApistatus() {
			return apistatus;
		}

		public void setApistatus(String apistatus) {
			this.apistatus = apistatus;
		}

		public String getAuditstatus() {
			return auditstatus;
		}

		public void setAuditstatus(String auditstatus) {
			this.auditstatus = auditstatus;
		}

		
		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getCreatetime() {
			return createtime;
		}

		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}

		@Override
		public String toString() {
			return "ApiPath [apiId=" + apiId + ", appId=" + appId + ", apiPath=" + apiPath + ", requestMethod="
					+ requestMethod + ", header=" + header + ", description=" + description + ", parameter=" + parameter
					+ ", apistatus=" + apistatus + ", auditstatus=" + auditstatus + ", path=" + path + ", createtime="
					+ createtime + "]";
		}

	
	
	    
	    

}
