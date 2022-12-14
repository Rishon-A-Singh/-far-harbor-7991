package com.masai.service;

import java.util.List;

import com.masai.exception.TripBookingException;
import com.masai.model.TripBooking;

public interface TripBookingService {

	public TripBooking insertTripBooking(TripBooking tripbooking) throws TripBookingException;
	public TripBooking updateTripBooking(TripBooking tripbooking) throws TripBookingException;
	public TripBooking deleteTripBooking(TripBooking tripbooking) throws TripBookingException;
	public List<TripBooking> viewAllTripCustomers(Integer customerId) throws TripBookingException;
	public TripBooking calculateBill(Integer customerId) throws TripBookingException;
	
	
	
}
