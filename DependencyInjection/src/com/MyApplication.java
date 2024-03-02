package com;

import org.springframework.context.support.*;

import com.service.VehicleService;
import com.vehicle.Vehicle;

import org.springframework.context.*;


public class MyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Vehicle a = (Vehicle)context.getBean("bus");
		System.out.println(a.getMileage());
		
		Vehicle b = (Vehicle)context.getBean("car");
		System.out.println(b.getMileage());
	}

}

//Vehicle vs = new Car();
//Vehicle vs1 = new Bus();