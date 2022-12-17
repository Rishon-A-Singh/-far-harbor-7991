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
		
		Optional<Customer> existing = userDao.findByUserMobile(cus.getUser().getMobile());

		if (existing.isPresent()) {

			System.out.println("Customer is already present");
			throw new CustomerException("A Customer already exist with this mobile number in the Database");
		}

		return userDao.save(cus);

		
	}

	@Override
	public Customer updateUser(Customer customer) throws CustomerException {
		
		Optional<Customer> opt = userDao.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			
			opt.get().setUser(customer.getUser());
			
			userDao.save(opt.get());
		}
		else {
			throw new CustomerException("Customer is not updated");
		}
		return opt.get();
	}

	@Override
	public Customer deleteUser(Integer customerId) throws CustomerException {
		
         Optional<Customer> opt = userDao.findById(customerId);
		
		if(opt.isPresent()) {
			
			userDao.delete(opt.get());
		}
		else {
			throw new CustomerException("Customer is not updated");
		}
		return opt.get();
		
	}

	@Override
	public List<Customer> viewUsers() throws CustomerException {
	
		List<Customer> list = userDao.findAll();
		
		if(list.size()==0) {
			throw new CustomerException("users does not find");
		}
		return list;
	}

	@Override
	public Customer viewUserById(Integer customerId) throws CustomerException {
		
         Optional<Customer> list = userDao.findById(customerId);
		
		if(list.isPresent()==false) {
			throw new CustomerException("users does not find");
		}
		return list.get();
		
	}

	
}
