package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
    public Customer createUser(Customer customer)throws CustomerException;
	
	public Customer updateUser(Customer customer)throws CustomerException;
	
	public Customer deleteUser(Integer customerId) throws CustomerException;
	
	public List<Customer> viewUsers() throws CustomerException; 
	
	public Customer viewUserById(Integer customerId) throws CustomerException;
	

}
