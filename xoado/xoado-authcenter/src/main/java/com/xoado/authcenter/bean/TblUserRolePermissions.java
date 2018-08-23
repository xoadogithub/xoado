package com.xoado.authcenter.bean;

public class TblUserRolePermissions {
    private Integer id;

    private String objectid;

    private Long roleoruser;

    private String organizeid;

    private String permissionsid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid == null ? null : objectid.trim();
    }

    public Long getRoleoruser() {
        return roleoruser;
    }

    public void setRoleoruser(Long roleoruser) {
        this.roleoruser = roleoruser;
    }

    public String getOrganizeid() {
        return organizeid;
    }

    public void setOrganizeid(String organizeid) {
        this.organizeid = organizeid == null ? null : organizeid.trim();
    }

    public String getPermissionsid() {
        return permissionsid;
    }

    public void setPermissionsid(String permissionsid) {
        this.permissionsid = permissionsid == null ? null : permissionsid.trim();
    }
}