package com.masai.controller;

import java.time.LocalDateTime;
import java.util.List;

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

import com.masai.model.Admin;
import com.masai.service.AdminService;
import com.trippy.exception.TripBookingException;
import com.trippy.models.TripBooking;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> register(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.adminRegister(admin), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Admin> update(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.update(admin), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Admin> delete(@PathVariable("id") Integer adminId){
		return new ResponseEntity<Admin>(adminService.deleteAdmin(adminId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllTrip/{id}")
	public ResponseEntity<List<TripBooking>> getAllTrip(@PathVariable("id") Integer customerId) throws TripBookingException{
		return new ResponseEntity<List<TripBooking>>(adminService.getAllTripBooking(customerId), HttpStatus.OK);
	}
	
	@GetMapping("getTripCabWise")
	public ResponseEntity<List<TripBooking>> getTripCabWise() throws TripBookingException {
		return new ResponseEntity<List<TripBooking>>(adminService.getTripCabWise(), HttpStatus.OK);
	}
	
	@GetMapping("/getTripByCustomer")
	public ResponseEntity<List<TripBooking>> getTripByCustomer() throws TripBookingException{
		return new ResponseEntity<List<TripBooking>>(adminService.getTripCustomerWise(), HttpStatus.OK);
	}
	
	@GetMapping("getTripDateWise")
	public ResponseEntity<List<TripBooking>> getTripDateWise() throws TripBookingException {
		return new ResponseEntity<List<TripBooking>>(adminService.getTripDateWise(), HttpStatus.OK);
	}
	
	@GetMapping("/getTripForDays")
	public ResponseEntity<List<TripBooking>> getTripForDays(@PathVariable("id") Integer customerId, @RequestParam LocalDateTime fromDate, @RequestParam LocalDateTime toDate) throws TripBookingException{
		return new ResponseEntity<List<TripBooking>>(adminService.getAllTripForDays(customerId, fromDate, toDate), HttpStatus.OK);
	}

}