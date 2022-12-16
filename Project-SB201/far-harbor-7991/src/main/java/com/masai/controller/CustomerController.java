package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	
	@PostMapping("/users")
	public ResponseEntity<Customer> saveUser(@RequestBody Customer customer) throws CustomerException {
		
	Customer savedUser= cService.createUser(customer);
		
	
	return new ResponseEntity<Customer>(savedUser,HttpStatus.CREATED);
	}
//	@PostMapping("/register")
//	public Customer registerCustomer(@RequestBody Customer customer) throws CustomerException {
//		Customer newUser = cService.createUser(customer);
//		return newUser;
//
//	}

	
//	@PutMapping("/update/{mobile}")
//	public Customer updateCustomerByMobile(@RequestBody Customer customer, @PathVariable("mobile") String mobile,
//			@RequestParam String key) {
//		return cService.updateUser(customer, mobile, key);
//	}
//	
	

}
