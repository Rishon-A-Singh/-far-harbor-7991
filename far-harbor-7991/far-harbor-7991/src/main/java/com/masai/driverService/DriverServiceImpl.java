package com.masai.driverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.DriverException;
import com.masai.model.Driver;
import com.masai.repository.DataAccessLayer;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DataAccessLayer dal;

	@Override
	public Driver insertDriver(Driver driver) throws DriverException{
		
		Driver addedDriver = dal.save(driver);
		if(addedDriver==null) {
			throw new DriverException("Enter valid driver informations.........!");
		}
		
		return addedDriver;
	}
	
	
	
	
	

}
