package com.zjut.teach.serviceimpl;

import java.util.List;

import com.zjut.teach.daoimpl.LoginDaoImpl;
import com.zjut.teach.model.Student;
import com.zjut.teach.model.Teacher;
import com.zjut.teach.model.User;

public class LoginServiceImpl {
	private LoginDaoImpl loginDao;
	

	public LoginDaoImpl getLoginDao() {
		return loginDao;
	}


	public void setLoginDao(LoginDaoImpl loginDao) {
		this.loginDao = loginDao;
	}


	public List<Student> loginstudent(String usernsame,String password){
		List<Student> list=loginDao.getStudent(usernsame,password);
		return list;
	}
	public List<Teacher> loginteacher(String usernsame,String password){
		List<Teacher> list=loginDao.getTeacher(usernsame,password);
		return list;
	}
		
		
	}
	
	

