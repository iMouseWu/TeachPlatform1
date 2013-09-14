package com.zjut.teach.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zjut.teach.model.Student;
import com.zjut.teach.model.Teacher;
import com.zjut.teach.model.User;
import com.zjut.teach.serviceimpl.*;
public class LoginAction extends ActionSupport{
	
	private String loginway;
	private LoginServiceImpl loginServiceImpl;
	private String username;
	private String password;
	public String getLoginway() {
		return loginway;
	}
	public void setLoginway(String loginway) {
		this.loginway = loginway;
	}
	public LoginServiceImpl getLoginServiceImpl() {
		return loginServiceImpl;
	}
	public void setLoginServiceImpl(LoginServiceImpl loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}
	public String execute() throws Exception { 
		String a = new String(loginway.getBytes("ISO-8859-1"),"UTF-8");
		if(a.equals("Ñ§Éú")){
			List<Student> list = loginServiceImpl.loginstudent(username,password);
			if(!list.isEmpty()){
				Student student = list.get(0);
				ActionContext context = ActionContext.getContext(); 
			    Map session = context.getSession();
			    session.put("user",student);
				return this.SUCCESS;
				}
				else{
				return this.LOGIN;
				}
		}else{
			List<Teacher> list = loginServiceImpl.loginteacher(username,password);
			if(!list.isEmpty())
			{
				Teacher teacher = list.get(0);
				ActionContext context = ActionContext.getContext(); 
			    Map session = context.getSession();
			    session.put("user",teacher);
				return this.SUCCESS;
				}
				else
				return this.LOGIN;
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
