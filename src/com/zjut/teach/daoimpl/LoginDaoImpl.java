package com.zjut.teach.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.*;

import com.zjut.teach.model.Student;
import com.zjut.teach.model.Teacher;
import com.zjut.teach.model.User;

public class LoginDaoImpl extends HibernateDaoSupport {
	public List<Student> getStudent(String username,String password){
		String sql = "from Student as u where u.username=? and u.password=?";
		List<Student> list = getHibernateTemplate().find(sql, username,password);
		return list;
	}
	public List<Teacher> getTeacher(String username,String password){
		String sql = "from Teacher as u where u.username=? and u.password=?";
		List<Teacher> list = getHibernateTemplate().find(sql, username,password);
		return list;
	}
	
}
