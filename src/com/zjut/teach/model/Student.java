package com.zjut.teach.model;

public class Student extends User {
	private int id;
	private String stu_Name;
	private String stu_Phone;
	private String stu_QQ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStu_Name() {
		return stu_Name;
	}
	public void setStu_Name(String stu_Name) {
		this.stu_Name = stu_Name;
	}
	public String getStu_Phone() {
		return stu_Phone;
	}
	public void setStu_Phone(String stu_Phone) {
		this.stu_Phone = stu_Phone;
	}
	public String getStu_QQ() {
		return stu_QQ;
	}
	public void setStu_QQ(String stu_QQ) {
		this.stu_QQ = stu_QQ;
	}

}
