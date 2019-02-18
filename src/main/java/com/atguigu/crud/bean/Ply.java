package com.atguigu.crud.bean;

import java.util.Date;
import java.util.List;

public class Ply {
    private Integer plyId;

    private Integer plyPeoId;

    private String plyPeoName;

    private String plyPeoPicturePath;

    private Integer plyBookNum;

    private Date plyTime;

    private String plyMessage;

    private List<Reply> replys;
    
    @Override
	public String toString() {
    	String replyss = "";
    	if(replys!=null) {
    		for (Reply reply : replys) {
    			replyss+=reply.toString();
    		}
    	}
    	
		return "Ply [plyId=" + plyId + ", plyPeoId=" + plyPeoId + ", plyPeoName=" + plyPeoName + ", plyPeoPicturePath="
				+ plyPeoPicturePath + ", plyBookNum=" + plyBookNum + ", plyTime=" + plyTime + ", plyMessage="
				+ plyMessage + ", replys=" + replys + "]"+replyss;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public Integer getPlyId() {
        return plyId;
    }

    public void setPlyId(Integer plyId) {
        this.plyId = plyId;
    }

    public Integer getPlyPeoId() {
        return plyPeoId;
    }

    public void setPlyPeoId(Integer plyPeoId) {
        this.plyPeoId = plyPeoId;
    }

    public String getPlyPeoName() {
        return plyPeoName;
    }

    public void setPlyPeoName(String plyPeoName) {
        this.plyPeoName = plyPeoName == null ? null : plyPeoName.trim();
    }

    public String getPlyPeoPicturePath() {
        return plyPeoPicturePath;
    }

    public void setPlyPeoPicturePath(String plyPeoPicturePath) {
        this.plyPeoPicturePath = plyPeoPicturePath == null ? null : plyPeoPicturePath.trim();
    }

    public Integer getPlyBookNum() {
        return plyBookNum;
    }

    public void setPlyBookNum(Integer plyBookNum) {
        this.plyBookNum = plyBookNum;
    }

    public Date getPlyTime() {
        return plyTime;
    }

    public void setPlyTime(Date plyTime) {
        this.plyTime = plyTime;
    }

    public String getPlyMessage() {
        return plyMessage;
    }

    public void setPlyMessage(String plyMessage) {
        this.plyMessage = plyMessage == null ? null : plyMessage.trim();
    }
}