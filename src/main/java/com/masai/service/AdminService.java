package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import com.trippy.exception.TripBookingException;
import com.trippy.models.TripBooking;
import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {

	public Admin adminRegister(Admin admin) throws AdminException;

	public Admin update(Admin admin) throws AdminException;

	public Admin deleteAdmin(Integer AdminId) throws AdminException;
	
	public List<TripBooking> getAllTripBooking(Integer customerId) throws TripBookingException;
	
	public List<TripBooking> getTripCabWise() throws TripBookingException;
	
	public List<TripBooking> getTripCustomerWise() throws TripBookingException;
	
	public List<TripBooking> getTripDateWise() throws TripBookingException;
	
	public List<TripBooking> getAllTripForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate) throws TripBookingException;
	
}
