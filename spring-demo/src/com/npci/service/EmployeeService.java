package com.npci.service;

import com.npci.dao.EmployeeDao;

public class EmployeeService {
	//even in service layer also we must have an interface with multiple service implementation
	//for demo purpose we are not creating service interface
	private EmployeeDao dao;
	//if we create object for the v1 and v2 class it is tightly coupled thats why we created
	//object for interface.

	
	//generate setter method for dao
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	public void save() {
		System.out.println("-------service in save() is called--------------");
		dao.store();
	}
	
	
	
	

}
