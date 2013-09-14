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
		/*���ݽ�ʦ�����ַ��ظ�ID��Ѱ����Ӧ�Ľ�ʦ�����ҷ���List�з���*/
		public List<Teacher> getOneTeacherInfo(String name){
			String sql = "from Teacher as u where u.tea_Name=?";
			List<Teacher> list = getHibernateTemplate().find(sql,name);
			return list;
		}
		/*���ݽ�ʦ��ID�ŷ��ظ�ID��Ѱ����Ӧ�Ľ�ʦ�����ҷ���List�з���*/
		public List<Teacher> findTeacherInfo(String tea_Id){
			String sql = "from Teacher as u where u.username=?";
			List<Teacher> list = getHibernateTemplate().find(sql,tea_Id);
			return list;
		}

	}


