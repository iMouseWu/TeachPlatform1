package com.zjut.teach.model;

public class Teacher extends User{
	private int id;
	private String tea_Name;
	private String tea_Phone;
	private String tea_QQ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTea_Name() {
		return tea_Name;
	}
	public void setTea_Name(String tea_Name) {
		this.tea_Name = tea_Name;
	}
	public String getTea_Phone() {
		return tea_Phone;
	}
	public void setTea_Phone(String tea_Phone) {
		this.tea_Phone = tea_Phone;
	}
	public String getTea_QQ() {
		return tea_QQ;
	}
	public void setTea_QQ(String tea_QQ) {
		this.tea_QQ = tea_QQ;
	}
	
}
