package com.xoado.FilingCabinet.bean;

import java.util.Date;

import com.xoado.FilingCabinet.bean.TblCurrentArchives;
import com.xoado.protocol.ArchivesStatus;

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
    
    
    
    @Override
	public String toString() {
		return "TblCurrentArchives [ownertype=" + ownertype + ", quantity=" + quantity + ", status=" + status
				+ ", holdfrom=" + holdfrom + ", holddate=" + holddate + ", taskid=" + taskid + ", handoverId="
				+ handoverId + "]";
	}

	public static TblCurrentArchives addCurrentArchives(String userId,String archivesId){
//    	个人添加
    	TblCurrentArchives tblCurrentArchives = new TblCurrentArchives();
    	tblCurrentArchives.setOwnerid(userId);
    	tblCurrentArchives.setArchiveId(archivesId);
    	tblCurrentArchives.setOwnertype(ArchivesStatus.person.toString());
//    	tblCurrentArchives.setQuantity(0);   可以为0
    	tblCurrentArchives.setStatus(ArchivesStatus.temporary.toString());
    	tblCurrentArchives.setHoldfrom(null);
    	tblCurrentArchives.setHolddate(new Date());
    	tblCurrentArchives.setTaskid(null);
    	tblCurrentArchives.setHandoverId(null);
		return tblCurrentArchives;
    }
    public static void main(String[] args) {
		System.out.println();
	}
}