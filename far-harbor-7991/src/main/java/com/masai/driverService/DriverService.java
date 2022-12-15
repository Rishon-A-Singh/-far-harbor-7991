package com.masai.driverService;

import java.util.List;

import javax.validation.Valid;

import com.masai.Exception.DriverException;
import com.masai.model.Driver;

public interface DriverService {
	
	public Driver insertDriver(Driver driver)throws DriverException;

	
	public Driver deleteDriver(Integer driverId)throws DriverException;

	
	public Driver viewDriver(Integer driverId)throws DriverException;
	
	
	public Driver updateDriver(Driver driver)throws DriverException;
	
	public List<Driver> getTopFiveDrivers()throws DriverException;


}
