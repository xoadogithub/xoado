package com.xoado.tools.bean;

import java.util.Date;

public class TblCurrentArchives extends TblCurrentArchivesKey {
    private String ownertype;

    private Integer quantity;

    private String status;

    private Object holdfrom;

    private Date holddate;

    private String taskid;

    private String handoverId;

    public String getOwnertype() {
        return ownertype;
    }

    public void setOwnertype(String ownertype) {
        this.ownertype = ownertype == null ? null : ownertype.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Object getHoldfrom() {
        return holdfrom;
    }

    public void setHoldfrom(Object holdfrom) {
        this.holdfrom = holdfrom;
    }

    public Date getHolddate() {
        return holddate;
    }

    public void setHolddate(Date holddate) {
        this.holddate = holddate;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public String getHandoverId() {
        return handoverId;
    }

    public void setHandoverId(String handoverId) {
        this.handoverId = handoverId == null ? null : handoverId.trim();
    }
}