package com.zjut.teach.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zjut.teach.model.Student;

public class StudentDaoImpl extends HibernateDaoSupport {
	public void modifyStudentInfo(Student student){
		getHibernateTemplate().update(student);
	}
	public List<Student> findStudentInfo(String stu_Id ){
		String sql = "from Student as u where u.username=?";
		List<Student> list = getHibernateTemplate().find(sql,stu_Id);
		return list;
	}

}
