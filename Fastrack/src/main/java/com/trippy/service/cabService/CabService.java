package com.trippy.service.cabService;

import java.util.List;

import com.trippy.exception.CabException;
import com.trippy.models.Cab;

public interface CabService {
	
	public Cab insertCab(Cab cab)throws CabException;
	
	
	public Cab updateCab(Cab cab)throws CabException;

	
	public Cab deleteCab(Integer cabId)throws CabException;

	
	public List<Cab> viewCabsOfType(String carType)throws CabException;
	
	
	public Integer countCabsOfType(String carType)throws CabException;

}
