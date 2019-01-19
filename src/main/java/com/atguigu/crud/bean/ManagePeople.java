package com.atguigu.crud.bean;

public class ManagePeople {
    private String manageName;

    private String managePassword;

    private String managePhone;

    private Integer manageEmpid;

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName == null ? null : manageName.trim();
    }

    public String getManagePassword() {
        return managePassword;
    }

    public void setManagePassword(String managePassword) {
        this.managePassword = managePassword == null ? null : managePassword.trim();
    }

    public String getManagePhone() {
        return managePhone;
    }

    public void setManagePhone(String managePhone) {
        this.managePhone = managePhone == null ? null : managePhone.trim();
    }

    public Integer getManageEmpid() {
        return manageEmpid;
    }

    public void setManageEmpid(Integer manageEmpid) {
        this.manageEmpid = manageEmpid;
    }
}