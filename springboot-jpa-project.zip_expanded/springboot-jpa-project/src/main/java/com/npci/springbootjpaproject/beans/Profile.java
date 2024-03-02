package com.npci.springbootjpaproject.beans;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {
	// @Id & @Generated value is used on primary key variable

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // automatically maps to id column
	// name and dob and phone will not have @Id and @GeneratedValue annotations
	private String name; // maps to name column because column name is same as variable name
	private LocalDate dob;// maps to dob column
	private Long phone;// maps to phone column

	// One to Many associate with contact : List<Contact>

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pid")
	private List<Contact> contactlist;

	public List<Contact> getContactlist() {
		return contactlist;
	}

	public void setContactlist(List<Contact> contactlist) {
		this.contactlist = contactlist;
	}

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

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}
