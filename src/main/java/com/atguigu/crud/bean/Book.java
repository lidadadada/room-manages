package com.atguigu.crud.bean;

import java.util.Date;

public class Book {
    private Integer serialNum;

    private Integer prePeopleId;

    private String preRoomNum;

    private String preTheme;

    private Date preDay;

    private Date preStartTime;

    private Date preEndTime;

    private Integer preJion;

    private String preMemberPath;

    private String prePicturePath;

    private String other;

    private PeopleInfo peopleInfo;

    
    private int ApplyState;		//该用户申请该会议的状态   0：未申请，1：审核中，2：已加入
    public int getApplyState() {
		return ApplyState;
	}

	public void setApplyState(int applyState) {
		ApplyState = applyState;
	}

	@Override
	public String toString() {
		return "Book [serialNum=" + serialNum + ", prePeopleId=" + prePeopleId + ", preRoomNum=" + preRoomNum
				+ ", preTheme=" + preTheme + ", preDay=" + preDay + ", preStartTime=" + preStartTime + ", preEndTime="
				+ preEndTime + ", preJion=" + preJion + ", preMemberPath=" + preMemberPath + ", prePicturePath="
				+ prePicturePath + ", other=" + other + ", peopleInfo=" + peopleInfo.toString() + "]";
	}

	public PeopleInfo getPeopleInfo() {
		return peopleInfo;
	}

	public void setPeopleInfo(PeopleInfo peopleInfo) {
		this.peopleInfo = peopleInfo;
	}

	public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getPrePeopleId() {
        return prePeopleId;
    }

    public void setPrePeopleId(Integer prePeopleId) {
        this.prePeopleId = prePeopleId;
    }

    public String getPreRoomNum() {
        return preRoomNum;
    }

    public void setPreRoomNum(String preRoomNum) {
        this.preRoomNum = preRoomNum == null ? null : preRoomNum.trim();
    }

    public String getPreTheme() {
        return preTheme;
    }

    public void setPreTheme(String preTheme) {
        this.preTheme = preTheme == null ? null : preTheme.trim();
    }

    public Date getPreDay() {
        return preDay;
    }

    public void setPreDay(Date preDay) {
        this.preDay = preDay;
    }

    public Date getPreStartTime() {
        return preStartTime;
    }

    public void setPreStartTime(Date preStartTime) {
        this.preStartTime = preStartTime;
    }

    public Date getPreEndTime() {
        return preEndTime;
    }

    public void setPreEndTime(Date preEndTime) {
        this.preEndTime = preEndTime;
    }

    public Integer getPreJion() {
        return preJion;
    }

    public void setPreJion(Integer preJion) {
        this.preJion = preJion;
    }

    public String getPreMemberPath() {
        return preMemberPath;
    }

    public void setPreMemberPath(String preMemberPath) {
        this.preMemberPath = preMemberPath == null ? null : preMemberPath.trim();
    }

    public String getPrePicturePath() {
        return prePicturePath;
    }

    public void setPrePicturePath(String prePicturePath) {
        this.prePicturePath = prePicturePath == null ? null : prePicturePath.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}