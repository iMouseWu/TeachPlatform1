package com.zjut.teach.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zjut.teach.model.Teacher;

public class TeacherDaoImpl extends HibernateDaoSupport {
		public List<Teacher> getAllTeacherInfo(){
			String sql = "from Teacher as u";
			List<Teacher> list = getHibernateTemplate().find(sql);
			return list;
			}
		/*根据教师的名字返回该ID号寻找相应的教师，并且放入List中返回*/
		public List<Teacher> getOneTeacherInfo(String name){
			String sql = "from Teacher as u where u.tea_Name=?";
			List<Teacher> list = getHibernateTemplate().find(sql,name);
			return list;
		}
		/*根据教师的ID号返回该ID号寻找相应的教师，并且放入List中返回*/
		public List<Teacher> findTeacherInfo(String tea_Id){
			String sql = "from Teacher as u where u.username=?";
			List<Teacher> list = getHibernateTemplate().find(sql,tea_Id);
			return list;
		}

	}


