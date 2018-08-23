package com.xoado.authcenter.bean;

import java.util.Date;

public class TblOrganizeMember extends TblOrganizeMemberKey {
    private String role;

    private Long parttimejob;

    private Date joinTime;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Long getParttimejob() {
        return parttimejob;
    }

    public void setParttimejob(Long parttimejob) {
        this.parttimejob = parttimejob;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}