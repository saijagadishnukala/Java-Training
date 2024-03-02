package com.npci.springws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.npci.springws.beans.Profile;
import com.npci.springws.exceptions.ProfileNotFoundException;

@Service
public class ProfileServiceListImpl implements ProfileService{
	
	//This will store the Profile in_memory instead of database.
	//List<Profile> to maintain the profile

	private static List<Profile> inMemoryDb = new ArrayList<>();

	@Override
	public Profile store(Profile profile) {
		
		inMemoryDb.add(profile);
		return profile; //returns the stored profile
	}

	@Override
	public List<Profile> fetchProfiles() {
		return inMemoryDb; //return the list of maintained profiles
		
	}

	@Override
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		
		return inMemoryDb.stream().filter(x -> x.getId()==id).
		findFirst().
		orElseThrow(() -> new ProfileNotFoundException("Id "+id+" not found"));
	}
}
	
