package com.example.demo.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.CleaningService;
import com.example.demo.service.PetrolService;
import com.example.demo.service.VehicleService;

@Controller
public class Bus implements Vehicle{
	
	@Autowired
	private CleaningService ps;

	@Override
	public String mileage() {
		// TODO Auto-generated method stub
		System.out.println(ps.getService());
		return "20kmpl";
	}

}
