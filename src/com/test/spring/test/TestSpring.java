package com.test.spring.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zjut.teach.action.LoginAction;

public class TestSpring {
public static void main(String[] args){
	
	try{
		ApplicationContext ctx=new FileSystemXmlApplicationContext("applicationContext.xml");
	
	LoginAction action=(LoginAction)ctx.getBean("loginAction");
	System.out.println(action.execute());
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
}
}
