package com.vehicle;


import com.service.VehicleService;

public class Bus implements Vehicle {
	
	private VehicleService vehicleservice;
//	//the above line will create the object for the implclass mentioned in the config.xml file.
//	
//	//below line is the constructor of bus which will initialize the object for vehicle service class of the type mentioned in config.xml
//	//below method is called as constructor injection
	public Bus(VehicleService vehicleservice) {
		this.vehicleservice=vehicleservice;
	}

	@Override
	public String getMileage() {
		// TODO Auto-generated method stub
		System.out.println("calling method implemented inside petrolservice class from inside Bus class method: "+vehicleservice.getService());
		return "30kmpl";
	}

}





//