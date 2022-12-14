package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.DriverException;
import com.masai.driverService.DriverService;
import com.masai.model.Driver;

@RestController
@RequestMapping("/driverService")
public class DriverController {

	@Autowired
	private DriverService dServe;
	
	
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> registerCustomer(@Valid @RequestBody Driver driver) throws DriverException{
		
		Driver addedDriver = dServe.insertDriver(driver);
		
		return new ResponseEntity<Driver>(addedDriver,HttpStatus.CREATED); 
		
	}
}
