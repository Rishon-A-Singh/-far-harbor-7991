package com.trippy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trippy.exception.AdminException;
import com.trippy.models.Admin;
import com.trippy.models.Cab;
import com.trippy.models.Customer;
import com.trippy.models.TripBooking;
import com.trippy.service.adminService.AdminService;

@RestController
@RequestMapping("/adminService")
public class AdminController {
	
	@Autowired
	private AdminService adminServe;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin) throws AdminException{
		
		Admin addedAdmin = adminServe.insertAdmin(admin);
		
		return new ResponseEntity<Admin>(addedAdmin,HttpStatus.CREATED); 
		
	}
	
	
	
	@PutMapping("/admin")
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin,@RequestParam(required = false)String key) throws AdminException{
		
		Admin updatedAdmin = adminServe.updateAdmin(admin,key);
		
		return new ResponseEntity<Admin>(updatedAdmin,HttpStatus.OK); 
		
	}
	
	
	@DeleteMapping("/admin/{adminId}")
	public ResponseEntity<Admin> deleteAdminbyId(@PathVariable("adminId")Integer id) throws AdminException{
		
		Admin deletedAdmin = adminServe.deleteAdmin(id);
		
		return new ResponseEntity<>(deletedAdmin,HttpStatus.OK); 
		
	}
	
	
	
	@GetMapping("/getTrips")
	public ResponseEntity<List<TripBooking>> getAllTrips() throws AdminException{
		
		List<TripBooking> list = adminServe.getAllTrip();
		
		return new ResponseEntity<>(list,HttpStatus.OK); 
		
	}
	
	@GetMapping("/getCabs")
	public ResponseEntity<List<Cab>> getAllCabs() throws AdminException{
		
		List<Cab> list = adminServe.getAllCabs();
		
		return new ResponseEntity<>(list,HttpStatus.OK); 
		
	}
	
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws AdminException{
		
		List<Customer> list = adminServe.getAllCustomers();
		
		return new ResponseEntity<>(list,HttpStatus.OK); 
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
