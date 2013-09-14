package com.zjut.teach.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zjut.teach.model.Chat;
import com.zjut.teach.model.Chat_User;
import com.zjut.teach.model.Student;

public class ChatDaoImpl extends HibernateDaoSupport{
	public List<Chat> getMessage(){
		String sql = "from Chat";
		List<Chat> list = getHibernateTemplate().find(sql);
		return list;
	}
	public void insertMessage(Chat chat){
		getHibernateTemplate().save(chat);
	}
	public void insertChatUser(Chat_User chat_user){
		getHibernateTemplate().save(chat_user);
	}
	public List<Chat_User> getChatUser(){
		String sql = "from Chat_User";
		List<Chat_User> list = getHibernateTemplate().find(sql);
		return list;
	}

}
