package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.TripBooking;

@Repository
public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{

}
