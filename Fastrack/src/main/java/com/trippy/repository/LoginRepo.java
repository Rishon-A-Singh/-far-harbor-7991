package com.trippy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trippy.models.CurrentUserSession;


@Repository
public interface LoginRepo extends JpaRepository<CurrentUserSession, Integer>{
	
	public  CurrentUserSession  findByUuid(String uuid); 

}
