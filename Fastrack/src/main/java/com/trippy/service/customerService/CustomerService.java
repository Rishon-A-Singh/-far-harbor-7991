package com.trippy.service.customerService;

import java.util.List;

import com.trippy.exception.CustomerException;
import com.trippy.models.Customer;
import com.trippy.models.Driver;

public interface CustomerService {
	
	
	
	public Customer insertCustomer(Customer customer)throws CustomerException;

	
	public Customer deleteCustomer(Integer customerId)throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;

	
	public List<Customer> viewCustomer()throws CustomerException;
	
	public Customer viewCustomerwithId(Integer customerId)throws CustomerException;
	
	
	public Customer validateCustomer(String userName,String password)throws CustomerException;

	
	
	
	
	


}
