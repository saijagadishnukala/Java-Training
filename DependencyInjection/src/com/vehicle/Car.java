package com.vehicle;

import com.service.VehicleService;

public class Car implements Vehicle{
	
	private VehicleService vs;
	
	//below is the setter injection using setter method to set the object for vehicleservice and setter method should be created for the field vs
	public void setVs(VehicleService vehicleservice) {
		this.vs=vehicleservice;
	}

	@Override
	public String getMileage() {
		// TODO Auto-generated method stub
		System.out.println("calling method implemented inside petrolservice class from inside Car class method: "+vs.getService());
		return "20kmpl";
	}

}
