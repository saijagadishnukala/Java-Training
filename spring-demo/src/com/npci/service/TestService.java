package com.npci.service;

import org.springframework.context.*;
import org.springframework.context.support.*;

import com.npci.dao.EmployeeDao;

public class TestService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// consider this code is written in the service layer
		//referencing to the spring container which has all the objects
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//when you get the object you must downtype to the right type.
		//get bean is the factory methods that return object from the container
		//below code is abstracting the 
		
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("b1");
		employeeDao.store();

	}

}
