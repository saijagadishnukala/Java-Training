package com.npci.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//by default id is its classname but first letter with lowercase
//i.e employeeDaoV1 is the id.
@Primary
public class EmployeeDaoV1 implements EmployeeDao{

	@Override
	public void store() {
		// TODO Auto-generated method stub
		
		System.out.println("========in EmployeeDaoV1 class===========");
		
	}

}
