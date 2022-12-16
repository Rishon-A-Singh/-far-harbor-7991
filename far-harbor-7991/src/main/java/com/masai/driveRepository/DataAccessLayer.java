package com.masai.driveRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Driver;


@Repository
public interface DataAccessLayer extends JpaRepository<Driver, Integer> {
	
	
	
	@Query(value = "select * from Driver d where d.rating >= 4.5 LIMIT 5",nativeQuery = true)
	public List<Driver> findByRatingTopFive();

}
