package com.atguigu.crud.bean;

public class PeopleInfo {
    private Integer peoSerialNum;

    private Integer peoEmployeeId;

    private String peoEmployeeName;

    private String peoPassword;

    private String peoPhone;

    private String peoPost;

    private String peoAddress;

    private String peoEmail;

    private String peoImagePath;

    private String peoOther;

    public Integer getPeoSerialNum() {
        return peoSerialNum;
    }

    public void setPeoSerialNum(Integer peoSerialNum) {
        this.peoSerialNum = peoSerialNum;
    }

    public Integer getPeoEmployeeId() {
        return peoEmployeeId;
    }

    public void setPeoEmployeeId(Integer peoEmployeeId) {
        this.peoEmployeeId = peoEmployeeId;
    }

    public String getPeoEmployeeName() {
        return peoEmployeeName;
    }

    public void setPeoEmployeeName(String peoEmployeeName) {
        this.peoEmployeeName = peoEmployeeName == null ? null : peoEmployeeName.trim();
    }

    public String getPeoPassword() {
        return peoPassword;
    }

    public void setPeoPassword(String peoPassword) {
        this.peoPassword = peoPassword == null ? null : peoPassword.trim();
    }

    public String getPeoPhone() {
        return peoPhone;
    }

    public void setPeoPhone(String peoPhone) {
        this.peoPhone = peoPhone == null ? null : peoPhone.trim();
    }

    public String getPeoPost() {
        return peoPost;
    }

    public void setPeoPost(String peoPost) {
        this.peoPost = peoPost == null ? null : peoPost.trim();
    }

    public String getPeoAddress() {
        return peoAddress;
    }

    public void setPeoAddress(String peoAddress) {
        this.peoAddress = peoAddress == null ? null : peoAddress.trim();
    }

    public String getPeoEmail() {
        return peoEmail;
    }

    public void setPeoEmail(String peoEmail) {
        this.peoEmail = peoEmail == null ? null : peoEmail.trim();
    }

    public String getPeoImagePath() {
        return peoImagePath;
    }

    public void setPeoImagePath(String peoImagePath) {
        this.peoImagePath = peoImagePath == null ? null : peoImagePath.trim();
    }

    public String getPeoOther() {
        return peoOther;
    }

    public void setPeoOther(String peoOther) {
        this.peoOther = peoOther == null ? null : peoOther.trim();
    }
}