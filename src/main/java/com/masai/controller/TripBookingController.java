package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.TripBookingException;
import com.masai.model.TripBooking;
import com.masai.service.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private TripBookingService tServ;
	
	@PostMapping("/trip")
	public ResponseEntity<TripBooking> insertTripBooking(@RequestBody TripBooking tripBooking) throws TripBookingException{
		TripBooking insertedTrip = tServ.insertTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(insertedTrip, HttpStatus.CREATED);
	}
	
//	public ResponseEntity<TripBooking> 
}
