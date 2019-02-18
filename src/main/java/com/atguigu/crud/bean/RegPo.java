package com.atguigu.crud.bean;

public class RegPo {
	private Integer empid;
	private String empname;
	private String pass1;
	private String pass2;
	private String phone;
	private String vali;
	
	@Override
	public String toString() {
		return "RegPo [empid=" + empid + ", empname=" + empname + ", pass1=" + pass1 + ", pass2=" + pass2 + ", phone="
				+ phone + ", vali=" + vali + "]";
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVali() {
		return vali;
	}
	public void setVali(String vali) {
		this.vali = vali;
	}
}
