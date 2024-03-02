package com.npci.springws.beans;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Profile {
	
	//properties whose name must match with the json properties names.
	@JsonProperty("userid")
	private int id;
	
	
	private String name;
	private LocalDate dob;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate date) {
		this.dob = date;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
