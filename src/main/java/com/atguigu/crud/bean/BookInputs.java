package com.atguigu.crud.bean;

import java.util.Date;

public class BookInputs {
    private Integer serialNum;

    private Integer prePeopleId;

    private String preRoomNum;

    private String preTheme;

    private String preDay;

    private String preStartTime;

    private String preEndTime;

    private Integer preJion;

    private String preMemberPath;

    private String other;

    @Override
	public String toString() {
		return "BookInput [serialNum=" + serialNum + ", prePeopleId=" + prePeopleId + ", preRoomNum=" + preRoomNum
				+ ", preTheme=" + preTheme + ", preDay=" + preDay + ", preStartTime=" + preStartTime + ", preEndTime="
				+ preEndTime + ", preJion=" + preJion + ", preMemberPath=" + preMemberPath + ", other=" + other + "]";
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

   

    
    public String getPreDay() {
		return preDay;
	}

	public void setPreDay(String preDay) {
		this.preDay = preDay;
	}

	public String getPreStartTime() {
		return preStartTime;
	}

	public void setPreStartTime(String preStartTime) {
		this.preStartTime = preStartTime;
	}

	public String getPreEndTime() {
		return preEndTime;
	}

	public void setPreEndTime(String preEndTime) {
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}