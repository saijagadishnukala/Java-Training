package com.npci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.npci.dao.EmployeeDao;
import com.npci.service.EmployeeService;


@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		EmployeeDao dao = (EmployeeDao)context.getBean("employeeDaoV2");
		dao.store();
		EmployeeService es = (EmployeeService)context.getBean("employeeService");
		es.save();
	}

}
