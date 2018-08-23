package com.xoado.authcenter.bean;

import java.util.Date;

public class TblApiInteface {
    private String apiId;

    private String appId;

    private String apiPath;

    private Long requestMethod;

    private String header;

    private String description;

    private String parameter;

    private String apistatus;

    private String auditstatus;

    private Date createtime;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId == null ? null : apiId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath == null ? null : apiPath.trim();
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
        this.header = header == null ? null : header.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getApistatus() {
        return apistatus;
    }

    public void setApistatus(String apistatus) {
        this.apistatus = apistatus == null ? null : apistatus.trim();
    }

    public String getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus == null ? null : auditstatus.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}