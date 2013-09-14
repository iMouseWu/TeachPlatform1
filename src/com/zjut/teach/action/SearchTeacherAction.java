package com.zjut.teach.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zjut.teach.daoimpl.TeacherDaoImpl;
import com.zjut.teach.model.Teacher;
import com.zjut.teach.serviceimpl.LoginServiceImpl;
import com.zjut.teach.serviceimpl.TeacherServiceImpl;

public class SearchTeacherAction extends ActionSupport {
	  private TeacherServiceImpl teacherServiceImpl;
	  private String context;
	
	
	   public TeacherServiceImpl getTeacherServiceImpl() {
		return teacherServiceImpl;
	}


	public void setTeacherServiceImpl(TeacherServiceImpl teacherServiceImpl) {
		this.teacherServiceImpl = teacherServiceImpl;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public String getAllTeaInfo() throws Exception {
		context = teacherServiceImpl.getAllTeacherInfoHtml();
		return "allteacherinfo";
		   
		
	}
	public String getOneTeaInfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		context = teacherServiceImpl.getOneTeacherInfoHtml(name);
		return "oneteacherinfo";
	}
	
	
	
	

}
