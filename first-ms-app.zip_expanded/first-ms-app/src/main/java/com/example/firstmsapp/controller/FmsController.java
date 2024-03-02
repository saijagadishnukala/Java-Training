package com.example.firstmsapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstms/api")
public class FmsController {
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello, this is a microservice";
	}
	
}
