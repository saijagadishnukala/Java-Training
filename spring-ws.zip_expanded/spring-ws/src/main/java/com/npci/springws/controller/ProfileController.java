package com.npci.springws.controller;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npci.springws.beans.Profile;
import com.npci.springws.exceptions.ProfileNotFoundException;
import com.npci.springws.service.ProfileService;

//we are going to handle profile data like id name and phone no and dob


@RestController
@RequestMapping("/v1/api")        //http://ip:port/v1/api/
public class ProfileController {
	//below method is for testing webservice
	//ResonseEntity: It is an object that can maintain https status code, content
	
	
	//Profile controller depends on profileservice
	
	@Autowired
	private ProfileService service;
	
	//HTTP methods for different operations
	
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeapi(@RequestBody Profile profile){
		//@RequestBody takes the JSON and maps to the profile object and initialize all the properties
		Profile p = service.store(profile);
		return ResponseEntity.status(201).body(p);
		//201: HHTP response code for CREATE
	}
	
	@GetMapping(path="/getProfile",produces=MediaType.APPLICATION_JSON_VALUE) // produces parameter is optional
	public ResponseEntity<Object> fetchapi(){
		List<Profile> profiles = service.fetchProfiles();
		return ResponseEntity.status(200).body(profiles);
	}
	
	@GetMapping(path="/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		try {
			Profile p = service.fetchProfile(id);
			return ResponseEntity.status(200).body(p);
		}
		catch(ProfileNotFoundException e) {
			Map<String,String> map = new HashMap<>();
			map.put("error message: ", e.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	
	
	@GetMapping(path="/greet/{username}?{desig}")        //http://ip:port/v1/api/greet/
	// We can give the url without path parameter also @GetMapping("/greet"), but we use path when we are passing multiple parameters in getmapping method
	//by default it produces JSON if we have a java object in response
	public ResponseEntity<Object> greetings(
			@PathVariable("username") String name,
			// "required" parameter should be false if the data is optional 
			@RequestParam(value="desig",required = true) String desig){
		Map<String,Object> map = new HashMap<>();
		map.put("message", "Hello, Rest, username= "+ name +" ,designation= " + desig);
		map.put("time", LocalDateTime.now());
		
		//200:OK, 201:created, 404: NOT FOUND
		//status will accept HTTP status code and body accepts the content of the response
		return ResponseEntity.status(400).body(map);
	}
}
