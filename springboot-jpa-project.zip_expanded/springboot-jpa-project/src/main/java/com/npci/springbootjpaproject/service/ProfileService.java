package com.npci.springbootjpaproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.npci.springbootjpaproject.beans.Contact;
import com.npci.springbootjpaproject.beans.Profile;
import com.npci.springbootjpaproject.exceptions.ProfileNotFoundException;


public interface ProfileService {
	// methods to call Profile Dao Methods
	
	public Profile store(Profile profile);//must call dao.save(Profile)
	public Profile fetchProfile(int id) throws ProfileNotFoundException;// must call findById(Id) method
	public List<Profile> findProfiles();// must call findAll() method
	
	public Profile findProfile(long phone) throws ProfileNotFoundException; // calls dao.findPhone(phone) method
	// calls findProfile and dao.save(Profile)
	public Profile updateProfilePhone(int id,long phone) throws ProfileNotFoundException;
	
	public void deleteProfile(int id) throws ProfileNotFoundException;
	
	public Profile updateNameByPhone(long phone,String name) throws ProfileNotFoundException;
	
	public Contact saveContact(Contact contact,int pid);

}
