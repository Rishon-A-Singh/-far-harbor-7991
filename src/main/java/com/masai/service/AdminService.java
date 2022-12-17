package com.masai.service;

import java.util.List;
import java.util.Optional;

import com.masai.model.AdminDTO;
import com.masai.exception.AdminException;
import com.masai.exception.LoginException;
import com.masai.model.Admin;
//import com.masai.model.CompletedTrips;
//import com.masai.model.Customer;
//import com.masai.model.Driver;
//
public interface AdminService {

	public Admin adminRegister(Admin admin) throws AdminException;

	public Admin update(Admin admin) throws AdminException;

	public Admin deleteAdmin(Integer AdminId) throws AdminException;
	
//	public List<CompletedTrips> getTripsByCustomerId(Integer customerId, String key);
//	
//	public List<CompletedTrips> getAllTrips(String key);
//	
//	public List<Driver> getListOfDrivers(String key);
//	
//	public List<Customer> getListOfCustomers(String key);
	
}
