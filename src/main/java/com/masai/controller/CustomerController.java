package com.masai.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
//@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	
	@PostMapping("/users")
	public ResponseEntity<Customer> saveUser(@RequestBody Customer customer) throws CustomerException {

	Customer savedUser= cService.createUser(customer);
		
	
	return new ResponseEntity<Customer>(savedUser,HttpStatus.CREATED);
	}


	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException {
		return new ResponseEntity<Customer>(cService.updateUser(customer),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletecustomer/{Id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("Id") Integer customerId) throws CustomerException {
		return new ResponseEntity<Customer>(cService.deleteUser(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/viewAllcustomer")
	public ResponseEntity <List<Customer>> viewCustomer()throws CustomerException{
		
		return new ResponseEntity<List<Customer>>(cService.viewUsers(),HttpStatus.OK);
	}

	@GetMapping("/viewcustomer/{Id}")
	public ResponseEntity <Customer> viewCustomer(@PathVariable("Id") Integer customerId)throws CustomerException{
		
		return new ResponseEntity<Customer>(cService.viewUserById(customerId),HttpStatus.OK);
	}

}
