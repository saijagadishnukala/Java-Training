package com.npci.springbootjpaproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.springbootjpaproject.beans.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {
	
}
