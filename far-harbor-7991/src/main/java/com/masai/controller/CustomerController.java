package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	
	@PostMapping("/users")
	public ResponseEntity<Customer> saveUser(@Valid @RequestBody Customer customer) throws CustomerException {
		
		Customer savedUser= CustomerService;
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	
	
	
	

}
