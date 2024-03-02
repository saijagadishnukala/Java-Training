package com.npci.springbootjpaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.springbootjpaproject.beans.Contact;
import com.npci.springbootjpaproject.beans.Profile;
import com.npci.springbootjpaproject.dao.ContactDao;
import com.npci.springbootjpaproject.dao.ProfileDao;
import com.npci.springbootjpaproject.exceptions.ProfileNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	//injecting the profiledao
	@Autowired
	private ProfileDao dao; //spring injects auto implemented Dao Layer
	
	@Autowired
	private ContactDao contactdao;

	@Override
	public Profile store(Profile profile) {
		// TODO Auto-generated method stub
		return dao.save(profile); // saves and returns the saved entity
	}

	@Override
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		return dao.findById(id).orElseThrow(()->new ProfileNotFoundException("Profile with id "+id+" not found"));
	}

	@Override
	public List<Profile> findProfiles() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Profile findProfile(long phone) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		return dao.findByPhone(phone).orElseThrow(()->new ProfileNotFoundException("Profile with phone "+phone+" not found"));
	}

	@Override
	public Profile updateProfilePhone(int id, long phone) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		Profile p = fetchProfile(id);
		p.setPhone(phone);
		return dao.save(p); //save can update if id is already present
	}

	@Override
	public void deleteProfile(int id) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		Profile p = fetchProfile(id);
		dao.delete(p);
	}

	@Transactional
	@Override
	public Profile updateNameByPhone(long phone, String name) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		dao.updateNameByPhone(phone, name);
		return findProfile(phone);
		
	}

	@Override
	public Contact saveContact(Contact contact, int pid) {
		// TODO Auto-generated method stub
		contact.setPid(pid);
		return contactdao.save(contact);
	}

}
