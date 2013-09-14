package com.zjut.teach.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON; 
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zjut.teach.model.Chat;
import com.zjut.teach.model.Chat_User;
import com.zjut.teach.model.Student;
import com.zjut.teach.model.Teacher;
import com.zjut.teach.model.User;
import com.zjut.teach.serviceimpl.ChatServiceImpl;

public class ChatAction extends ActionSupport{
	private String content;
	private ChatServiceImpl chatServiceImpl;
	private List list;
	public List<Chat> getList() {
		return list;
	}
	public void setList(List<Chat> list) {
		this.list = list;
	}
	@JSON(serialize=false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@JSON(serialize=false)
	public ChatServiceImpl getChatServiceImpl() {
		return chatServiceImpl;
	}
	public void setChatServiceImpl(ChatServiceImpl chatServiceImpl) {
		this.chatServiceImpl = chatServiceImpl;
	}
	public String execute(){
		Chat chat = new Chat();
		ActionContext context = ActionContext.getContext(); 
		Map session = context.getSession();
		User user =  (User)session.get("user");
		if(chatServiceImpl.getIdentity(user)){
			/*获取当前时间格式为:HH:mm:ss:*/
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Student student = chatServiceImpl.getStudentInfo(user.getUsername());
			chat.setMes_Name("学生-"+student.getStu_Name());
			chat.setMes_date(dateFormat.format(date));
			chat.setMessage(content);
		}else{
			/*获取当前时间格式为:HH:mm:ss:*/
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Teacher teacher = chatServiceImpl.getTeacherInfo(user.getUsername());
			chat.setMes_Name("教师-"+teacher.getTea_Name());
			chat.setMes_date(dateFormat.format(date));
			chat.setMessage(content);
		}
		chatServiceImpl.insertMessage(chat);
		reMessage();
		return "success";
	}
	public String reMessage(){
		list = chatServiceImpl.getMessage();
		return "success";
	}
	public String checkChatLogin(){
		ActionContext context = ActionContext.getContext(); 
		Map session = context.getSession();
		User user =  (User)session.get("user");
		Chat_User chat_user = new Chat_User();
		if(chatServiceImpl.getIdentity(user)){
			Student student = chatServiceImpl.getStudentInfo(user.getUsername());
			chat_user.setUsername("学生:"+student.getStu_Name());
		}else{
			Teacher teacher = chatServiceImpl.getTeacherInfo(user.getUsername());
			chat_user.setUsername("教师:"+teacher.getTea_Name());
		}
		chatServiceImpl.insertChatUser(chat_user);
		return "success";
	}
	public String reChat_User(){
		list = chatServiceImpl.getChatUser();
		return "success";
	}
	
}
