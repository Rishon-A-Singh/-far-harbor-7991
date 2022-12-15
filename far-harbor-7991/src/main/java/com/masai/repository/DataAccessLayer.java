package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Driver;


@Repository
public interface DataAccessLayer extends JpaRepository<Driver, Integer> {
	
	
	
	@Query("select d from Driver where d.rating >= 4.5 LIMIT 5")
	public List<Driver> findByRatingTopFive();

}
