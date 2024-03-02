package com.npci.beans;

import java.time.LocalDate;

public class Profile {
	private int id;
	private String name;
	private LocalDate dob;
	private long phone;
	
	//Generate parameterized & default constructor both.
	
	public Profile(String name, LocalDate dob, long phone) {
		super();
		this.name = name;
		this.dob = dob;
		this.phone = phone;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
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
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setId(int int1) {
		// TODO Auto-generated method stub
		this.id=int1;
		
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	

}
