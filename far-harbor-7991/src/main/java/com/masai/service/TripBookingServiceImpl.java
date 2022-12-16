package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.TripBookingException;
import com.masai.model.TripBooking;
import com.masai.repository.TripBookingDao;

@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	private TripBookingDao tdao;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripbooking) throws TripBookingException {
		TripBooking regdTrip = tdao.save(tripbooking);
		return regdTrip;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripbooking) throws TripBookingException {
		Optional<TripBooking> opt = tdao.findById(tripbooking.getTripBooking());
		if(opt.isEmpty()) { throw new TripBookingException("that trip booking does not exist!");}
		TripBooking tb = opt.get();
		return tb;
	}

	@Override
	public TripBooking deleteTripBooking(TripBooking tripbooking) throws TripBookingException {
		Optional<TripBooking> opt = tdao.findById(tripbooking.getTripBooking());
		if(opt.isEmpty()) { throw new TripBookingException("that trip booking does not exist!");}
		TripBooking tb = opt.get();
		tdao.delete(tb);
		return tb;
	}

	@Override
	public List<TripBooking> viewAllTripCustomers(Integer customerId) throws TripBookingException {
		List<TripBooking> trips = tdao.findAll();
		if(trips.isEmpty()) throw new TripBookingException("There are no products");
		else return trips;
	}

	@Override
	public TripBooking calculateBill(Integer customerId) throws TripBookingException {
		
		return null;
	}

}
