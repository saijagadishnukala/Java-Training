package com.npci.controller;

import org.springframework.context.*;
import org.springframework.context.support.*;

import com.npci.service.EmployeeService;
public class TestController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeService service = (EmployeeService)context.getBean("b2");
		service.save();

	}

}
