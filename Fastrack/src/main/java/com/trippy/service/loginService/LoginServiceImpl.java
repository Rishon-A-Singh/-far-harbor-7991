package com.trippy.service.loginService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trippy.exception.LoginException;
import com.trippy.models.Admin;
import com.trippy.models.CurrentUserSession;
import com.trippy.models.Customer;
import com.trippy.models.Driver;
import com.trippy.models.LoginDTO;
import com.trippy.repository.AdminRepo;
import com.trippy.repository.CustomerRepo;
import com.trippy.repository.DriverRepo;
import com.trippy.repository.LoginRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	private CustomerRepo customerRepo;;
	
	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public String logIntoCustomerAccount(LoginDTO dto) throws LoginException {
		Customer existingCustomer= customerRepo.findByMobile(dto.getMobileNo());
	
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
						 
		}	
		
		CurrentUserSession validCustomerSessionOpt =  loginRepo.findById(existingCustomer.getCustomerId()).get();		
		
		if(validCustomerSessionOpt==null) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
					
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			loginRepo.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
			
	}

	@Override
	public String logOutFromCustomerAccount(String key) throws LoginException, LoginException {
		CurrentUserSession validCustomerSession = loginRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		loginRepo.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}

	@Override
	public String logIntoDriverAccount(LoginDTO dto) throws LoginException {
		Driver existingDriver= driverRepo.findByMobile(dto.getMobileNo());
		
		if(existingDriver == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
						 
		}	
		
		CurrentUserSession validDriverSessionOpt =  loginRepo.findById(existingDriver.getDriverId()).get();		
		
		if(validDriverSessionOpt==null) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingDriver.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
					
			CurrentUserSession currentUserSession = new CurrentUserSession(existingDriver.getDriverId(),key,LocalDateTime.now());
			
			loginRepo.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
			
	}

	@Override
	public String logOutFromDriverAccount(String key) throws LoginException, LoginException {
		
		CurrentUserSession validDriverSession = loginRepo.findByUuid(key);
		
		
		if(validDriverSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		loginRepo.delete(validDriverSession);
		
		
		return "Logged Out !";
	}

	@Override
	public String logIntoAdminAccount(LoginDTO dto) throws LoginException {
		Admin existingAdmin= adminRepo.findByMobile(dto.getMobileNo());
		
		if(existingAdmin == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
						 
		}	
		
		CurrentUserSession validAdminSessionOpt =  loginRepo.findById(existingAdmin.getAdminId()).get();		
		
		if(validAdminSessionOpt==null) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingAdmin.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
					
			CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			
			loginRepo.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logOutFromAdminAccount(String key) throws LoginException, LoginException {
		CurrentUserSession validAdminSession = loginRepo.findByUuid(key);
		
		
		if(validAdminSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		loginRepo.delete(validAdminSession);
		
		
		return "Logged Out !";
	}
	


}
