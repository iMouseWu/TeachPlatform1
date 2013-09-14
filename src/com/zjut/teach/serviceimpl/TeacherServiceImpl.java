package com.zjut.teach.serviceimpl;

import java.util.List;
import com.zjut.teach.daoimpl.TeacherDaoImpl;
import com.zjut.teach.model.Teacher;

public class TeacherServiceImpl 
{
	private TeacherDaoImpl teacherDaoImpl;
	private String context;

	public TeacherDaoImpl getTeacherDaoImpl() {
		return teacherDaoImpl;
	}

	public void setTeacherDaoImpl(TeacherDaoImpl teacherDaoImpl) {
		this.teacherDaoImpl = teacherDaoImpl;
	}
	public String getAllTeacherInfoHtml(){
		List<Teacher> list = teacherDaoImpl.getAllTeacherInfo();
		context = "<Teachers>";
		for(Teacher teacher:list){
			String tea_Id = teacher.getUsername();
			String tea_Password = teacher.getPassword();
			String tea_Name = teacher.getTea_Name();
			String tea_Phone = teacher.getTea_Phone();
			String tea_QQ = teacher.getTea_QQ();
			context += "<teacher>";
			context = context + "<tea_Id>" + tea_Id + "</tea_Id>";
			context = context + "<tea_Password>" + tea_Password + "</tea_Password>";
			context = context + "<tea_Name>" + tea_Name + "</tea_Name>";
			context = context + "<tea_Phone>" + tea_Phone + "</tea_Phone>";
			context = context + "<tea_QQ>" + tea_QQ + "</tea_QQ>";
			context +="</teacher>";
		}
		context += "</Teachers>";
	return context;
	}
	public String getOneTeacherInfoHtml(String name){
		List<Teacher> list = teacherDaoImpl.getOneTeacherInfo(name);
		context = "<Teachers>";
		for(Teacher teacher:list){
			String tea_Id = teacher.getUsername();
			String tea_Password = teacher.getPassword();
			String tea_Name = teacher.getTea_Name();
			String tea_Phone = teacher.getTea_Phone();
			String tea_QQ = teacher.getTea_QQ();
			context += "<teacher>";
			context = context + "<tea_Id>" + tea_Id + "</tea_Id>";
			context = context + "<tea_Password>" + tea_Password + "</tea_Password>";
			context = context + "<tea_Name>" + tea_Name + "</tea_Name>";
			context = context + "<tea_Phone>" + tea_Phone + "</tea_Phone>";
			context = context + "<tea_QQ>" + tea_QQ + "</tea_QQ>";
			context +="</teacher>";
		}
		context += "</Teachers>";
		return context;
		
	}

}
