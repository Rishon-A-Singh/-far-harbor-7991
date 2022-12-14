package com.masai.driverService;

import javax.validation.Valid;

import com.masai.Exception.DriverException;
import com.masai.model.Driver;

public interface DriverService {
	
	public Driver insertDriver(@Valid Driver driver)throws DriverException;





}
