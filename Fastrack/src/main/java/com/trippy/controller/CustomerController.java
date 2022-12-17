package com.trippy.controller;

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

import com.trippy.exception.CustomerException;
import com.trippy.models.Customer;
import com.trippy.service.customerService.CustomerService;

@RestController
@RequestMapping("/customerService")
public class CustomerController{
	
	@Autowired
	private CustomerService custServe;

	
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws CustomerException{
		
		
		Customer addedCustomer = custServe.insertCustomer(customer);
		
		return new ResponseEntity<Customer>(addedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@RequestParam(required = false) String key) throws CustomerException{
		
		Customer updatedCustomer = custServe.updateCustomer(customer,key);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer customerId) throws CustomerException{
		
		Customer deletedCustomer = custServe.deleteCustomer(customerId);
		
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	
    @GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() throws CustomerException{
		
		List<Customer> list = custServe.viewCustomer();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomersById(@PathVariable Integer customerId) throws CustomerException{
		
		Customer customer = custServe.viewCustomerwithId(customerId);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<Customer> getCustomersById(@RequestParam("userName") String username ,@RequestParam("password") String password) throws CustomerException{
		
		Customer foundedCustomer = custServe.validateCustomer(username, password);
		
		return new ResponseEntity<>(foundedCustomer,HttpStatus.OK);
	}
	
	
}
