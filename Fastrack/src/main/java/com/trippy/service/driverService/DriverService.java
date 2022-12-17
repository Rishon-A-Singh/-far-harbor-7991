package com.trippy.service.driverService;

import java.util.List;

import com.trippy.exception.DriverException;
import com.trippy.models.Driver;

public interface DriverService {
	
	public Driver insertDriver(Driver driver)throws DriverException;

	
	public Driver deleteDriver(Integer driverId)throws DriverException;

	
	public Driver viewDriver(Integer driverId)throws DriverException;
	
	
	public Driver updateDriver(Driver driver,String key)throws DriverException;
	
	public List<Driver> getTopFiveDrivers()throws DriverException;


}
