package com.zjut.teach.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zjut.teach.model.Student;

public class LoginInterceptor extends AbstractInterceptor {
	
	
	public String intercept(ActionInvocation arg0) throws Exception {

		Map session = arg0.getInvocationContext().getSession();
		Student student = (Student)session.get("student");
		if(student == null){
			return "error";
			
		}else{
			return arg0.invoke();
			
		}
		 
	}


}
