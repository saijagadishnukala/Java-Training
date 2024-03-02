package com.npci.dao;

import org.springframework.context.*;
import org.springframework.context.support.*;
public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Datasource ds = (Datasource)context.getBean("b3");
		
		System.out.println("-----------------printing values of 3 variables--------------");
		System.out.println(ds.getPasswords());
		System.out.println(ds.getUsername());
		System.out.println(ds.getUrl());
		

	}

}
