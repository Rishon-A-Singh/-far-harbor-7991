package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerDao userDao;
	
	@Override
	public Customer createUser(Customer cus) throws CustomerException {

		Customer addedCustomer = userDao.save(cus);
		
		
		return addedCustomer;
		
	}

	@Override
	public Customer updateUser(Customer customer, String key) throws CustomerException {
		
		return null;
	}

	@Override
	public Customer deleteUser(Integer customerId, String key) throws CustomerException {
		
		return null;
	}

	@Override
	public List<Customer> viewUsers(String key) throws CustomerException {
	
		return null;
	}

	@Override
	public Customer viewUserById(Integer customerId, String key) throws CustomerException {
		
		return null;
	}

	
}
