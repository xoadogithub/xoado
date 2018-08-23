package com.xoado.FilingCabinet.bean;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.xoado.protocol.HandoverType;

import net.sf.json.JSONArray;


public class TblHandoverRecord {
    private String handoverId;

    private Object handout;

    private Object recipient;

    private String handoverType;

    private Object handoverContent;

    private Object express;

    private Object expressprogress;

    private Object progress;

    private String handoverState;

    private Date handoverDate;

    private Date completeDate;

    private Object comments;

    private String businesslabel;

    private String taskid;

    private Object location;

    public String getHandoverId() {
        return handoverId;
    }

    public void setHandoverId(String handoverId) {
        this.handoverId = handoverId == null ? null : handoverId.trim();
    }

    public Object getHandout() {
        return handout;
    }

    public void setHandout(Object handout) {
        this.handout = handout;
    }

    public Object getRecipient() {
        return recipient;
    }

    public void setRecipient(Object recipient) {
        this.recipient = recipient;
    }

    public String getHandoverType() {
        return handoverType;
    }

    public void setHandoverType(String handoverType) {
        this.handoverType = handoverType == null ? null : handoverType.trim();
    }

    public Object getHandoverContent() {
        return handoverContent;
    }

    public void setHandoverContent(Object handoverContent) {
        this.handoverContent = handoverContent;
    }

    public Object getExpress() {
        return express;
    }

    public void setExpress(Object express) {
        this.express = express;
    }

    public Object getExpressprogress() {
        return expressprogress;
    }

    public void setExpressprogress(Object expressprogress) {
        this.expressprogress = expressprogress;
    }

    public Object getProgress() {
        return progress;
    }

    public void setProgress(Object progress) {
        this.progress = progress;
    }

    public String getHandoverState() {
        return handoverState;
    }

    public void setHandoverState(String handoverState) {
        this.handoverState = handoverState == null ? null : handoverState.trim();
    }

    public Date getHandoverDate() {
        return handoverDate;
    }

    public void setHandoverDate(Date handoverDate) {
        this.handoverDate = handoverDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public String getBusinesslabel() {
        return businesslabel;
    }

    public void setBusinesslabel(String businesslabel) {
        this.businesslabel = businesslabel == null ? null : businesslabel.trim();
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

	@Override
	public String toString() {
		return "TblHandoverRecord [handoverId=" + handoverId + ", handout=" + handout + ", recipient=" + recipient
				+ ", handoverType=" + handoverType + ", handoverContent=" + handoverContent + ", express=" + express
				+ ", expressprogress=" + expressprogress + ", progress=" + progress + ", handoverState=" + handoverState
				+ ", handoverDate=" + handoverDate + ", completeDate=" + completeDate + ", comments=" + comments
				+ ", businesslabel=" + businesslabel + ", taskid=" + taskid + ", location=" + location + "]";
	}
    
    /**
     * 交接
     */
	
	public TblHandoverRecord ReceiveData(String handoverid,Object handout, Object recipient,Object archiveJson, String Comments, String Businesslabel,
			String task_id, Date date,Object array,Object location,HttpServletRequest request){		
		this.setHandoverId(handoverid);
		this.setHandout(handout.toString());
		this.setRecipient(recipient.toString());
		this.setHandoverType(HandoverType.direct.toString());
		this.setHandoverContent(archiveJson.toString());
		this.setExpress(null);
		this.setExpressprogress(null);
		this.setProgress(array.toString());
		this.setHandoverState(HandoverType.complete.toString());
		this.setHandoverDate(date);
		this.setCompleteDate(date);
		JSONArray commentsJson = new JSONArray();
		commentsJson.add(Comments);
		this.setComments(commentsJson.toString());
		this.setBusinesslabel(Businesslabel);
		this.setTaskid(task_id);
		this.setLocation(location.toString());
		return this;		
	}
}