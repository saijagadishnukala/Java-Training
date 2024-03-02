package com.npci.springbootjpaproject.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.npci.springbootjpaproject.beans.Profile;


public interface ProfileDao extends JpaRepository<Profile, Integer> {
	
	//extend Jpa repository you get save(T), findAll(), findById(ID) and so on
	// you can also create custom query methods which are also automatically implemented
	@Query("select p from Profile p where p.phone=?1")
	public Optional<Profile> findByPhone(long phone);
	
	//service layer calls findByPhone method Optional<Profile> = findByPhone() like op.orElseThrow(()->exception-object): returns profile or throws ProfileNotFoundException
	
	@Modifying
	@Query("update Profile p set p.name=?2 where p.phone=?1")
	public int updateNameByPhone(long phone,String name);
	

}
