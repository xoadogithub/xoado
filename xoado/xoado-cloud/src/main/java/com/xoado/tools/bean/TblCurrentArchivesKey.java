package com.xoado.tools.bean;

public class TblCurrentArchivesKey {
    private String ownerid;

    private String archiveId;

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid == null ? null : ownerid.trim();
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId == null ? null : archiveId.trim();
    }
}