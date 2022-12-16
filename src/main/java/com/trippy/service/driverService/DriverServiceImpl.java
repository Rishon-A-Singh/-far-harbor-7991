package com.trippy.service.driverService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trippy.exception.DriverException;
import com.trippy.models.Driver;
import com.trippy.repository.DriverRepo;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepo dal;

	@Override
	public Driver insertDriver(Driver driver) throws DriverException{
		
		System.out.println("service");
		System.out.println(driver);
		
		Driver addedDriver = dal.save(driver);
		if(addedDriver==null) {
			throw new DriverException("Enter valid driver informations.........!");
		}
		System.out.println(addedDriver);
		return addedDriver;
	}

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException {
		 Driver deletedDriver = dal.findById(driverId).get();
		 
		 if(deletedDriver==null) {
			 throw new DriverException("Driver not found with the ID : "+driverId);
		 }
		 else {
			 dal.deleteById(driverId);
		 }
		return deletedDriver;
	}

	@Override
	public Driver viewDriver(Integer driverId) throws DriverException {
		Driver getDriver = dal.findById(driverId).get();
		 if(getDriver==null) {
			 throw new DriverException("Driver not found with the ID : "+driverId);
		 }
		 return getDriver;
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException {
		Driver getDriver = dal.findById(driver.getDriverId()).get();
		
		if(getDriver==null) {
			 throw new DriverException("Driver not found with the ID : "+driver.getDriverId());
		}
		
		Driver updatedDriver = dal.save(driver);
		
		return updatedDriver;

		
	}

	@Override
	public List<Driver> getTopFiveDrivers() throws DriverException {
		
		List<Driver> topList = dal.findByRatingTopFive();
		
		if(topList.size()==0) {
			 throw new DriverException("List Empty.......!");

		}
		
		return topList;
		
	}
	
	
	
	
	

}
