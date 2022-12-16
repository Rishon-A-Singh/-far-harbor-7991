package com.masai.cabService;

import java.util.List;

import com.masai.Exception.CabException;
import com.masai.model.Cab;

public interface CabService {
	
	public Cab insertCab(Cab cab)throws CabException;
	
	
	public Cab updateCab(Cab cab)throws CabException;

	
	public Cab deleteCab(Integer cabId)throws CabException;

	
	public List<Cab> viewCabsOfType(String carType)throws CabException;
	
	
	public Integer countCabsOfType(String carType)throws CabException;

}
