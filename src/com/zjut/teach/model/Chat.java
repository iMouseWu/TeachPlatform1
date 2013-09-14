package com.zjut.teach.model;

public class Chat {
	private int id;
	private String message;
	private String mes_Name;
	private String mes_date;
	public String getMes_date() {
		return mes_date;
	}
	public void setMes_date(String mes_date) {
		this.mes_date = mes_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMes_Name() {
		return mes_Name;
	}
	public void setMes_Name(String mes_Name) {
		this.mes_Name = mes_Name;
}
}