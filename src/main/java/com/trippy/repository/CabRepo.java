package com.trippy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trippy.models.Cab;


@Repository
public interface CabRepo extends JpaRepository<Cab, Integer>{
	
	public List<Cab> findByCarType(String cabType);
	
	@Query("select count(c) from Cab c where c.carType = ?1")
	public Integer countByCarType(String cabType);


	
}
