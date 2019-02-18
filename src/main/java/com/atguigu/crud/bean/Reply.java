package com.atguigu.crud.bean;

import java.util.Date;

public class Reply {
    private Integer replyId;

    private Integer replyPeoId;

    private String replyPeoIdName;

    private Integer replyToPlyId;

    private Integer replyToPlyPeoId;

    private String replyToPlyPeoName;

    private Date replytTime;
    
    private String replyMessage;

    @Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyPeoId=" + replyPeoId + ", replyPeoIdName=" + replyPeoIdName
				+ ", replyToPlyId=" + replyToPlyId + ", replyToPlyPeoId=" + replyToPlyPeoId + ", replyToPlyPeoName="
				+ replyToPlyPeoName + ", replytTime=" + replytTime + ", replyMessage=" + replyMessage + "]";
	}

	public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyPeoId() {
        return replyPeoId;
    }

    public void setReplyPeoId(Integer replyPeoId) {
        this.replyPeoId = replyPeoId;
    }

    public String getReplyPeoIdName() {
        return replyPeoIdName;
    }

    public void setReplyPeoIdName(String replyPeoIdName) {
        this.replyPeoIdName = replyPeoIdName == null ? null : replyPeoIdName.trim();
    }

    public Integer getReplyToPlyId() {
        return replyToPlyId;
    }

    public void setReplyToPlyId(Integer replyToPlyId) {
        this.replyToPlyId = replyToPlyId;
    }

    public Integer getReplyToPlyPeoId() {
        return replyToPlyPeoId;
    }

    public void setReplyToPlyPeoId(Integer replyToPlyPeoId) {
        this.replyToPlyPeoId = replyToPlyPeoId;
    }

    public String getReplyToPlyPeoName() {
        return replyToPlyPeoName;
    }

    public void setReplyToPlyPeoName(String replyToPlyPeoName) {
        this.replyToPlyPeoName = replyToPlyPeoName == null ? null : replyToPlyPeoName.trim();
    }

    public Date getReplytTime() {
        return replytTime;
    }

    public void setReplytTime(Date replytTime) {
        this.replytTime = replytTime;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage == null ? null : replyMessage.trim();
    }
}