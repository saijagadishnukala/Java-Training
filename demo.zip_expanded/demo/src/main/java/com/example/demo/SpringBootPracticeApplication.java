package com.example.demo;

import java.beans.BeanProperty;
import java.beans.JavaBean;

import org.springframework.boot.SpringApplication;
import org.springframework.context.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.vehicle.Vehicle;

@SpringBootApplication
public class SpringBootPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootPracticeApplication.class, args);
		Vehicle vs = (Vehicle)context.getBean("car");
		System.out.println(vs.mileage());
		
		Vehicle vs1 = (Vehicle)context.getBean("bus");
		System.out.println(vs1.mileage());
		
		
	}

}
