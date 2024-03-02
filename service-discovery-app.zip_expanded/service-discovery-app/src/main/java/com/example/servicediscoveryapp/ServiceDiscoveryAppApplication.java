package com.example.servicediscoveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//This acts like service discover and server port will be 8761 by default
//we must use @EnableEurekaServer on top of the main class.abstract
//we need to disable the client features like register with eureka = false
//and other is fetch registry = false


@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryAppApplication.class, args);
	}

}
