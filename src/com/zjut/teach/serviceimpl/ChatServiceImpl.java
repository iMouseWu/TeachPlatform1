package com.zjut.teach.serviceimpl;

import java.util.List;

import com.zjut.teach.daoimpl.ChatDaoImpl;
import com.zjut.teach.daoimpl.StudentDaoImpl;
import com.zjut.teach.daoimpl.TeacherDaoImpl;
import com.zjut.teach.model.Chat;
import com.zjut.teach.model.Chat_User;
import com.zjut.teach.model.Student;
import com.zjut.teach.model.Teacher;
import com.zjut.teach.model.User;

public class ChatServiceImpl {
	private ChatDaoImpl chatDaoImpl;
	private StudentDaoImpl studentDaoImpl;
	private TeacherDaoImpl teacherDaoImpl;
	public TeacherDaoImpl getTeacherDaoImpl() {
		return teacherDaoImpl;
	}
	public void setTeacherDaoImpl(TeacherDaoImpl teacherDaoImpl) {
		this.teacherDaoImpl = teacherDaoImpl;
	}
	public ChatDaoImpl getChatDaoImpl() {
		return chatDaoImpl;
	}
	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}
	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
	public void setChatDaoImpl(ChatDaoImpl chatDaoImpl) {
		this.chatDaoImpl = chatDaoImpl;
	}
	public List<Chat> getMessage(){
		List<Chat> list = chatDaoImpl.getMessage();
		return list;
	}
	public void insertMessage(Chat chat){
		chatDaoImpl.insertMessage(chat);
	}
	public List<Chat_User> getChatUser(){
		List<Chat_User> list = chatDaoImpl.getChatUser();
		return list;
	}
	/*判断登陆的是学生还是教师,如果是学生就返回true，如果是教师的话就返回false*/
	public boolean getIdentity(User user){
		//如果limitauthority的值是2的话就返回false
		if(user.getLimitauthority().equals("2")){
			return false;
		}else{
			return true;
		}
	}
	public Student getStudentInfo(String stu_Id){
		List<Student> list = studentDaoImpl.findStudentInfo(stu_Id);
		return list.get(0);
	}
	public Teacher getTeacherInfo(String tea_Id){
		List<Teacher> list = teacherDaoImpl.findTeacherInfo(tea_Id);
		return list.get(0);
	}
	public void insertChatUser(Chat_User chat_user){
		chatDaoImpl.insertChatUser(chat_user);
	}
}
