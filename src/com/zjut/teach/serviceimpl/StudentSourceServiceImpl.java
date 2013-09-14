package com.zjut.teach.serviceimpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.zjut.teach.daoimpl.StudentDaoImpl;
import com.zjut.teach.model.Student;
import com.zjut.teach.model.Teacher;

public class StudentSourceServiceImpl {
	public StudentDaoImpl studentDaoImpl;
	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}
	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
	public String content;
	public String getPerInfoHtml(){
		ActionContext context = ActionContext.getContext(); 
	    Map session = context.getSession();
	    Student oldstudent = (Student)session.get("user");
	    List<Student> list = studentDaoImpl.findStudentInfo(oldstudent.getUsername());
	    Student student = list.get(0);
	    System.out.println(student);
	    content = "<Students>";
	    String stu_Id = student.getUsername();
		String stu_Password = student.getPassword();
		String stu_Name = student.getStu_Name();
		String stu_Phone = student.getStu_Phone();
		String stu_QQ = student.getStu_QQ();
		content += "<student>";
		content = content + "<stu_Id>" + stu_Id + "</stu_Id>";
		content = content + "<stu_Password>" + stu_Password + "</stu_Password>";
		content = content + "<stu_Name>" + stu_Name + "</stu_Name>";
		content = content + "<stu_Phone>" + stu_Phone + "</stu_Phone>";
		content = content + "<stu_QQ>" + stu_QQ + "</stu_QQ>";
		content +="</student>";
		content += "</Students>";
	    return content;
	}
	public void modifyPerInfo(Student student){
		studentDaoImpl.modifyStudentInfo(student);
	} 
	public List<Student> findmodifyPer(String stu_Id){
		List<Student> list = studentDaoImpl.findStudentInfo(stu_Id);
		return list;
	}
	public String  viewDownloads(){
		File file = new File("F:/apache-tomcat-7.0.37/webapps/TeachPlatform/Resources");
		String[] a = file.list();
		if(a.length>0){
		content = "<DownLoads>";
		for(int i=0;i<a.length;i++){
		content+="<p>"+a[i]+"</p>";
	    }
		}else{
			content = "<DownLoads>";
			content+="<p>"+" "+"</p>";
		}
		content+="</DownLoads>";
		return content;
	}
	

}
