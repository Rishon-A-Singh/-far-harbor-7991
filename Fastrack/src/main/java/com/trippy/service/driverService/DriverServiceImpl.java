package com.trippy.service.driverService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trippy.exception.CustomerException;
import com.trippy.exception.DriverException;
import com.trippy.models.CurrentUserSession;
import com.trippy.models.Driver;
import com.trippy.repository.DriverRepo;
import com.trippy.repository.LoginRepo;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepo driveRepo;
	
	@Autowired
	private LoginRepo login;

	@Override
	public Driver insertDriver(Driver driver) throws DriverException{
		
		
		Driver existingDriver= driveRepo.findByMobile(driver.getMobile());
				
		if(driver!=null) {
			throw new DriverException("Driver already regsistered.........!");
		}
		
		Driver addedDriver = driveRepo.save(driver);
		
		return addedDriver;
	}

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException {
		 Driver deletedDriver = driveRepo.findById(driverId).get();
		 
		 if(deletedDriver==null) {
			 throw new DriverException("Driver not found with the ID : "+driverId);
		 }
		 else {
			 driveRepo.deleteById(driverId);
		 }
		return deletedDriver;
	}

	@Override
	public Driver viewDriver(Integer driverId) throws DriverException {
		Driver getDriver = driveRepo.findById(driverId).get();
		 if(getDriver==null) {
			 throw new DriverException("Driver not found with the ID : "+driverId);
		 }
		 return getDriver;
	}

	@Override
	public Driver updateDriver(Driver driver,String key) throws DriverException {
		
		
		CurrentUserSession loggedInUser= login.findByUuid(key);
		
		
		if(loggedInUser == null) {
			throw new DriverException("Please provide a valid key to update a Driver");
		}
		
		if(driver.getDriverId() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return driveRepo.save(driver);
		}
		else
			throw new DriverException("Invalid Driver Details, please login first");
	

//		Driver getDriver = driveRepo.findById(driver.getDriverId()).get();
//		
//		if(getDriver==null) {
//			 throw new DriverException("Driver not found with the ID : "+driver.getDriverId());
//		}
//		
//		Driver updatedDriver = driveRepo.save(getDriver);
//		
//		return updatedDriver;

		
	}

	@Override
	public List<Driver> getTopFiveDrivers() throws DriverException {
		
		List<Driver> topList = driveRepo.findByRatingTopFive();
		
		if(topList.size()==0) {
			 throw new DriverException("List Empty.......!");

		}
		
		return topList;
		
	}
	
	
	
	
	

}
