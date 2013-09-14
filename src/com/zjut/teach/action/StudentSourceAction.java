package com.zjut.teach.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zjut.teach.model.Student;
import com.zjut.teach.serviceimpl.StudentSourceServiceImpl;

public class StudentSourceAction extends ActionSupport {
	private StudentSourceServiceImpl studentSourceServiceImpl;
	private String context;
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public StudentSourceServiceImpl getStudentSourceServiceImpl() {
		return studentSourceServiceImpl;
	}

	public void setStudentSourceServiceImpl(StudentSourceServiceImpl studentSourceServiceImpl) {
		this.studentSourceServiceImpl = studentSourceServiceImpl;
	}

	public String getLoginSession(){
		context = studentSourceServiceImpl.getPerInfoHtml();
		return "Perinfo";
	}
	public String modifyStudentInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stu_Id = request.getParameter("stu_Id");
		//String stu_Password = request.getParameter("stu_Password");
		String stu_Name = request.getParameter("stu_Name");
		String stu_Phone = request.getParameter("stu_Phone");
		String stu_QQ = request.getParameter("stu_QQ");
		Student student = (Student)studentSourceServiceImpl.findmodifyPer(stu_Id).get(0);
		student.setStu_Name(stu_Name);
		student.setStu_Phone(stu_Phone);
		student.setStu_QQ(stu_QQ);
		studentSourceServiceImpl.modifyPerInfo(student);
		return "modifysucceed";
	}
	public String viewDownloads(){
		context = studentSourceServiceImpl.viewDownloads();
		return "viewdownloads";
	}

}
