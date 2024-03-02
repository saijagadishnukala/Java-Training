package com.example.demo.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.demo.service.VehicleService;

@Controller
public class Car implements Vehicle{
	
	@Autowired
	@Qualifier("cleaningService")
	private VehicleService vs;

	@Override
	public String mileage() {
		// TODO Auto-generated method stub
		System.out.println(vs.getService());
		return "30kmpl";
	}

}
