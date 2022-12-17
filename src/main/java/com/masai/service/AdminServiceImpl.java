package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repository.AdminDao;
import com.trippy.exception.TripBookingException;
import com.trippy.models.TripBooking;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin adminRegister(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		if(admin==null) {
			throw new AdminException("Unable to Register");
		}
		adminDao.save(admin);
		return admin;
		
	}

	@Override
	public Admin update(Admin admin) throws AdminException {
		Optional<Admin> opt = adminDao.findById(admin.getAdminId());
		if(opt.isPresent()) {
			opt.get().setUser(admin.getUser());
			adminDao.save(opt.get());
		}else {
			throw new AdminException("Update Failed....");
		}
		return opt.get();
	}

	@Override
	public Admin deleteAdmin(Integer AdminId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> opt = adminDao.findById(AdminId);
		if(opt.isPresent()) {
			adminDao.delete(opt.get());
		}else {
			throw new AdminException("Delete Failed...");
		}
		return opt.get();
	}

	@Override
	public List<TripBooking> getAllTripBooking(Integer customerId) throws TripBookingException {
		// TODO Auto-generated method stub
		List<TripBooking> tripBookings = adminDao.findByCustomerId(customerId);
		if(tripBookings.size()==0) {
			throw new TripBookingException("Trip not Found");
		}
		return tripBookings;
	}

	@Override
	public List<TripBooking> getTripCabWise() throws TripBookingException {
		// TODO Auto-generated method stub
		List<TripBooking> tripBookings = adminDao.findCabWise();
		if(tripBookings.size()==0) {
			throw new TripBookingException("Trip not Found");
		}
		return tripBookings;
	}

	@Override
	public List<TripBooking> getTripCustomerWise() throws TripBookingException {
		// TODO Auto-generated method stub
		List<TripBooking> tripBookings = adminDao.findByCustomerName();
		if(tripBookings.size()==0) {
			throw new TripBookingException("Trip not Found");
		}
		return tripBookings;
	}

	@Override
	public List<TripBooking> getTripDateWise() throws TripBookingException {
		List<TripBooking> tripBookings = adminDao.findByDate();
		if(tripBookings.size()==0) {
			throw new TripBookingException("Trip not Found");
		}
		return tripBookings;
	}

	@Override
	public List<TripBooking> getAllTripForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws TripBookingException {
		// TODO Auto-generated method stub
		List<TripBooking> tripBookings = adminDao.findTripForDays(customerId, fromDate, toDate);
		if(tripBookings.size()==0) {
			throw new TripBookingException("Trip not Found");
		}
		return tripBookings;
	}

	

}