package com.npci.springws.service;

import java.util.List;

import com.npci.springws.beans.Profile;
import com.npci.springws.exceptions.ProfileNotFoundException;

public interface ProfileService {
	
	//store profile and return the stored profile
	
	public Profile store(Profile profile);
	
	//fetch all the profiles
	
	public List<Profile> fetchProfiles();
	
	public Profile fetchProfile(int id) throws ProfileNotFoundException;
	
	//Other methods that can be implemented
	//fetchProfile(int), updateProfile(int,Profile), deleteProfile(int)

}
