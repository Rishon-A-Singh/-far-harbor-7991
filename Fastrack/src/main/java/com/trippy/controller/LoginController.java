package com.trippy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trippy.exception.LoginException;
import com.trippy.models.LoginDTO;
import com.trippy.service.loginService.LoginService;

@RestController
@RequestMapping("/User")
public class LoginController {
	
	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/loginCustomer")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoCustomerAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/logoutCustomer")
	public ResponseEntity<String> logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
	
		String result = customerLogin.logOutFromCustomerAccount(key);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	@PostMapping("/loginDriver")
	public ResponseEntity<String> logInDriver(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoDriverAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/logoutDriver")
	public ResponseEntity<String> logoutDriver(@RequestParam(required = false) String key) throws LoginException {
	
		String result = customerLogin.logOutFromDriverAccount(key);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> logInAdmin(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoAdminAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/logoutAdmin")
	public ResponseEntity<String> logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
	
		String result = customerLogin.logOutFromAdminAccount(key);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}

}
