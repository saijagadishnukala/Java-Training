package com.npci.springwswebwar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApi {
	
	@GetMapping("/firstapi") //URL: http://localhost:8080/api/firstapi
	public ResponseEntity<Object> greet(){
		return ResponseEntity.status(200).body("First api called");
	}

}
