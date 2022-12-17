package com.trippy.service.loginService;

import com.trippy.exception.LoginException;
import com.trippy.models.LoginDTO;

public interface LoginService {
	
	public String logIntoCustomerAccount(LoginDTO dto)throws LoginException;

	public String logOutFromCustomerAccount(String key)throws LoginException, LoginException;
	
	
	public String logIntoDriverAccount(LoginDTO dto)throws LoginException;

	public String logOutFromDriverAccount(String key)throws LoginException, LoginException;

	
	public String logIntoAdminAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAdminAccount(String key)throws LoginException, LoginException;

	

}
