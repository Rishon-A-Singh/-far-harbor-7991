package com.trippy.service.adminService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trippy.exception.AdminException;
import com.trippy.exception.TripBookingException;
import com.trippy.models.Admin;
import com.trippy.models.Cab;
import com.trippy.models.Customer;
import com.trippy.models.TripBooking;
import com.trippy.repository.AdminRepo;
import com.trippy.repository.CabRepo;
import com.trippy.repository.CustomerRepo;
import com.trippy.repository.TripBookingRepo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private TripBookingRepo tripRepo;

	@Autowired
	private CabRepo cabRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
			Admin registeredAdmin = adminRepo.save(admin);
			
			if(registeredAdmin ==null) {
				throw new AdminException("Enter valid Infromations...!");

			}
			return registeredAdmin;
	}

	@Override
	public Admin updateAdmin(Admin admin,String key) throws AdminException {
		Admin getAdmin = adminRepo.findById(admin.getAdminId()).get();
		if(getAdmin==null){
			throw new AdminException("Admin doesnt exists.....!");
			}
		
		Admin updatedAdmin = adminRepo.save(getAdmin);
		
		return updatedAdmin;
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		Admin deletedAdmin = adminRepo.findById(adminId).get();
		if(deletedAdmin==null) {
			throw new AdminException("Admin doesnt exists.....!");
			}
		adminRepo.delete(deletedAdmin);
		return deletedAdmin;
	}

	@Override
	public List<TripBooking> getAllTrip() throws AdminException {
		
		List<TripBooking> list  = tripRepo.findAll();
		if(list==null) {
			throw new AdminException("List doesnt exists.....!");
			}
		
		return list;
		
	}

	@Override
	public List<Cab> getAllCabs() throws AdminException {
		
		List<Cab> list  = cabRepo.findAll();
		if(list==null) {
			throw new AdminException("List doesnt exists.....!");
			}
		
		return list;
		
	}

	@Override
	public List<Customer> getAllCustomers() throws AdminException {
		
		List<Customer> list  = customerRepo.findAll();
		if(list==null) {
			throw new AdminException("List doesnt exists.....!");
			}
		
		return list;		
		
	}

	
		
	

}
