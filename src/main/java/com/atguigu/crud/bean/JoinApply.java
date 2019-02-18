package com.atguigu.crud.bean;

public class JoinApply {
    private Integer joinId;

    private Integer joinPeopleId;

    private Integer joinBookId;

    private Integer joinBookOwnerId;

    private Integer joinDealState;

    private String joinOther;

    public Integer getJoinId() {
        return joinId;
    }

    public void setJoinId(Integer joinId) {
        this.joinId = joinId;
    }

    public Integer getJoinPeopleId() {
        return joinPeopleId;
    }

    public void setJoinPeopleId(Integer joinPeopleId) {
        this.joinPeopleId = joinPeopleId;
    }

    public Integer getJoinBookId() {
        return joinBookId;
    }

    public void setJoinBookId(Integer joinBookId) {
        this.joinBookId = joinBookId;
    }

    public Integer getJoinBookOwnerId() {
        return joinBookOwnerId;
    }

    public void setJoinBookOwnerId(Integer joinBookOwnerId) {
        this.joinBookOwnerId = joinBookOwnerId;
    }

    public Integer getJoinDealState() {
        return joinDealState;
    }

    public void setJoinDealState(Integer joinDealState) {
        this.joinDealState = joinDealState;
    }

    public String getJoinOther() {
        return joinOther;
    }

    public void setJoinOther(String joinOther) {
        this.joinOther = joinOther == null ? null : joinOther.trim();
    }
}