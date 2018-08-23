package com.xoado.authcenter.bean;

import java.util.Date;

public class TblOrgPermissions {
    private String permissionsid;

    private String organizeid;

    private String name;

    private Object permissions;

    private String createrid;

    private Date createTime;

    public String getPermissionsid() {
        return permissionsid;
    }

    public void setPermissionsid(String permissionsid) {
        this.permissionsid = permissionsid == null ? null : permissionsid.trim();
    }

    public String getOrganizeid() {
        return organizeid;
    }

    public void setOrganizeid(String organizeid) {
        this.organizeid = organizeid == null ? null : organizeid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Object getPermissions() {
        return permissions;
    }

    public void setPermissions(Object permissions) {
        this.permissions = permissions;
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid == null ? null : createrid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}