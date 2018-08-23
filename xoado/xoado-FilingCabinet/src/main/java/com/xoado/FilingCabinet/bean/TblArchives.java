package com.xoado.FilingCabinet.bean;

import java.util.Date;

import com.xoado.FilingCabinet.bean.TblArchives;

import net.sf.json.JSONObject;

public class TblArchives {
    private String archiveId;

    private String archiveName;

    private Object ownerOrg;

    private Object ownerUser;

    private Object comments;

    private Object attachmentPicture;

    private Object attachmentDocument;

    private Date createTime;

    private Object creater;

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId == null ? null : archiveId.trim();
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName == null ? null : archiveName.trim();
    }

    public Object getOwnerOrg() {
        return ownerOrg;
    }

    public void setOwnerOrg(Object ownerOrg) {
        this.ownerOrg = ownerOrg;
    }

    public Object getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(Object ownerUser) {
        this.ownerUser = ownerUser;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public Object getAttachmentPicture() {
        return attachmentPicture;
    }

    public void setAttachmentPicture(Object attachmentPicture) {
        this.attachmentPicture = attachmentPicture;
    }

    public Object getAttachmentDocument() {
        return attachmentDocument;
    }

    public void setAttachmentDocument(Object attachmentDocument) {
        this.attachmentDocument = attachmentDocument;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Object getCreater() {
        return creater;
    }

    public void setCreater(Object creater) {
        this.creater = creater;
    }   
    
    
    
    
    @Override
	public String toString() {
		return "TblArchives [archiveId=" + archiveId + ", archiveName=" + archiveName + ", ownerOrg=" + ownerOrg
				+ ", ownerUser=" + ownerUser + ", comments=" + comments + ", attachmentPicture=" + attachmentPicture
				+ ", attachmentDocument=" + attachmentDocument + ", createTime=" + createTime + ", creater=" + creater
				+ "]";
	}

	public static TblArchives addArchives(
			String archives_Id,
			String archive_Name,
			String owner_Orgid,
    		String owner_Orgname,
    		String owner_Userid,
    		String owner_Username,
    		Object comments,
    		Date date,
    		String userId,
    		String userName
){
    	JSONObject jsonObject = new JSONObject();
    	TblArchives archives = new TblArchives();
		archives.setArchiveId(archives_Id);
		archives.setArchiveName(archive_Name);
		jsonObject.put("owner_orgid", owner_Orgid);
		jsonObject.put("owner_name", owner_Orgname);
		archives.setOwnerOrg(jsonObject.toString());
		jsonObject=new JSONObject();
		jsonObject.put("owner_userid",owner_Userid);
		jsonObject.put("owner_username", owner_Username);
		archives.setOwnerUser(jsonObject.toString());
		jsonObject=new JSONObject();
		jsonObject.put("comments", comments);
		archives.setComments(jsonObject.toString());
		archives.setCreateTime(date);
		jsonObject=new JSONObject();
		jsonObject.put("create_id", userId);
		jsonObject.put("create_name", userName);
		archives.setCreater(jsonObject.toString());
		return archives;
    	
    }
}