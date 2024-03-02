package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PetrolService implements VehicleService{

	@Override
	public String getService() {
		// TODO Auto-generated method stub
		return "Petrol is filled";
	}
	
}
