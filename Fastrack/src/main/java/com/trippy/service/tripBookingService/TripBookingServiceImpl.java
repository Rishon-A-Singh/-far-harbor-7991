package com.trippy.service.tripBookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trippy.exception.CustomerException;
import com.trippy.exception.TripBookingException;
import com.trippy.models.Customer;
import com.trippy.models.TripBooking;
import com.trippy.repository.CustomerRepo;
import com.trippy.repository.TripBookingRepo;

@Service
public class TripBookingServiceImpl implements TripBookingService {
	
	@Autowired
	private TripBookingRepo tripRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public TripBooking insertTripBooking(TripBooking tripbooking) throws TripBookingException {
		TripBooking registeredTrip = tripRepo.save(tripbooking);
		
		if(registeredTrip ==null) {
			throw new TripBookingException("Enter valid Infromations...!");
		}
		
		return registeredTrip;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripbooking) throws TripBookingException {
		TripBooking getTrip = tripRepo.findById(tripbooking.getTripBookingId()).get();
		if(getTrip==null){
			throw new TripBookingException("that trip booking does not exist!");
			}
		
		TripBooking updatedTrip = tripRepo.save(getTrip);
		
		return updatedTrip;
	}

	@Override
	public TripBooking deleteTripBooking(TripBooking tripbooking) throws TripBookingException {
		TripBooking deletedTrip = tripRepo.findById(tripbooking.getTripBookingId()).get();
		if(deletedTrip==null) {
			throw new TripBookingException("that trip booking does not exist!");
			}
		tripRepo.delete(deletedTrip);
		return deletedTrip;
	}

	@Override
	public List<TripBooking> viewAllTripCustomers(Integer customerId) throws TripBookingException {
		
		List<TripBooking> list = tripRepo.getTrips(customerId);
		
		if(list.size()==0) {
			throw new TripBookingException("List does'nt exits..!");
		}
		
		return list;
	}

	@Override
	public Float calculateBill(Integer customerId) throws TripBookingException, CustomerException {
		
		Customer cust = customerRepo.findById(customerId).get();
		
		if(cust==null) {
			throw new CustomerException("Customer does'nt exits..!");
		}
		
		TripBooking found = cust.getTrip();
		

		if(found==null) {
			throw new TripBookingException("Trip does'nt exits..!");
		}
				
		return found.getBill();
	}


}
