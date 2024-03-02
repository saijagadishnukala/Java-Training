package com.npci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.npci.dao.EmployeeDao;

@Service
public class EmployeeService {
	//even in service layer also we must have an interface with multiple service implementation
	//for demo purpose we are not creating service interface
	@Autowired
	private EmployeeDao dao;
	//if we create object for the v1 and v2 class it is tightly coupled thats why we created
	//object for interface.

	
	//generate setter method for dao
	
	public void save() {
		System.out.println("-------service in save() is called--------------");
		dao.store();
	}
	
	
	
	

}
