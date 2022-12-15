package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.DriverException;
import com.masai.driverService.DriverService;
import com.masai.model.Driver;

@RestController
@RequestMapping("/driverService")
public class DriverController {

	//Getting the Driver Service Layer connection using the @Autowired annotation
	
	@Autowired
	private DriverService dServe;
	
	
	//Adding the new driver informations using the @PostMapping annotation also checking the validations
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> registerDriver(@Valid @RequestBody Driver driver) throws DriverException{
		
		Driver addedDriver = dServe.insertDriver(driver);
		
		return new ResponseEntity<Driver>(addedDriver,HttpStatus.CREATED); 
		
	}
	
	
	
	
	
	//Deleting the driver informations from the DB using the @DeleteMapping annotation through the DriverId @PathVariable
	
	@DeleteMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> deleteDriverbyId(@PathVariable("driverId")Integer id) throws DriverException{
		
		Driver deletedDriver = dServe.deleteDriver(id);
		
		return new ResponseEntity<Driver>(deletedDriver,HttpStatus.OK); 
		
	}
	
	
	//Getting the driver informations from the DB using the @GetMapping annotation through the DriverId as @PathVariable
	
	@GetMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> getDriverbyId(@PathVariable("driverId")Integer id) throws DriverException{
		
		Driver getDriver = dServe.viewDriver(id);
		
		return new ResponseEntity<Driver>(getDriver,HttpStatus.OK); 
		
	}
	
	
	
	@PutMapping("/drivers")
	public ResponseEntity<Driver> updateDriver(@Valid @RequestBody Driver driver) throws DriverException{
		
		Driver updatedDriver = dServe.updateDriver(driver);
		
		return new ResponseEntity<Driver>(updatedDriver,HttpStatus.OK); 
		
	}
	
	
	public ResponseEntity<List<Driver>> getTopFiveDriver() throws DriverException{
		
		
		List<Driver> list = dServe.getTopFiveDrivers();
		
		
		return new ResponseEntity<>(list,HttpStatus.OK); 
	}
	
	
	
	
	
	
}
