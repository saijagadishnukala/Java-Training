package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CleaningService implements VehicleService{

	@Override
	public String getService() {
		// TODO Auto-generated method stub
		return "Vehicle is cleaned";
	}

}
