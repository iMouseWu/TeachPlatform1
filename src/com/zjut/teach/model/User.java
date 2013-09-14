package com.zjut.teach.model;

public class User {
	protected String limitauthority;
	protected String password;
	protected String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLimitauthority() {
		return limitauthority;
	}

	public void setLimitauthority(String limitauthority) {
		this.limitauthority = limitauthority;
	}
	
}