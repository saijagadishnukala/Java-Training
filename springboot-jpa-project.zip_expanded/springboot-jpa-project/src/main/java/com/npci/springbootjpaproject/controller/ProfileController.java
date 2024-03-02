package com.npci.springbootjpaproject.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.npci.springbootjpaproject.beans.Contact;
import com.npci.springbootjpaproject.beans.Profile;
import com.npci.springbootjpaproject.exceptions.ProfileNotFoundException;
import com.npci.springbootjpaproject.service.ProfileService;

@RestController
@RequestMapping("/jpaProject")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@PostMapping(path="/saveProfile",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveProfile(@RequestBody Profile profile){
		//Storing the profile
		return ResponseEntity.status(201).body(service.store(profile));
	}
	
	
	@GetMapping("/findProfile/{id}")
	public ResponseEntity<Object> findProfileapi(@PathVariable int id){
		try {
			return ResponseEntity.status(200).body(service.fetchProfile(id));
		}catch(ProfileNotFoundException e) {
			Map<String,String> map = new HashMap<>();
			map.put("Error: ", e.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	
	@GetMapping("/showProfileByPhone/{phone}")
	public ResponseEntity<Object> findProfileByPhone(@PathVariable long phone){
		try {
			return ResponseEntity.status(200).body(service.findProfile(phone));
		}catch(ProfileNotFoundException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@GetMapping("/removeProfile/{id}")
	public void deleteProfile(@PathVariable int id){
		try {
			service.deleteProfile(id);
		}catch(ProfileNotFoundException e) {
			e.getStackTrace();
		}
		
	}
	
	@GetMapping("/showProfileList")
	public ResponseEntity<Object> showProfiles(){
		
		return ResponseEntity.status(200).body(service.findProfiles());
	}
	
	
	@GetMapping("/updateNameUsingPhone/{phone}/{name}")
	public ResponseEntity<Object> updateNameByPhone(@PathVariable long phone,@PathVariable String name){
		try {
			return ResponseEntity.status(200).body(service.updateNameByPhone(phone, name));
		}catch(ProfileNotFoundException e) {
			Map<String, String> map = new HashMap<>();
			map.put("Hello: ",e.getMessage());
			return ResponseEntity.status(404).body(map);
			
		}
	}
	
	@GetMapping("/updatePhoneById/{id}/{phone}")
	public ResponseEntity<Object> updatePhoneById(@PathVariable int id,@PathVariable long phone){
		try {
			return ResponseEntity.status(200).body(service.updateProfilePhone(id, phone));
		}catch(ProfileNotFoundException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping("/saveContact/{profileId}")
	public ResponseEntity<Object> saveContact(@RequestBody Contact contact,@PathVariable int profileId){
		return ResponseEntity.status(200).body(service.saveContact(contact, profileId));
	}
	
	
	
}
