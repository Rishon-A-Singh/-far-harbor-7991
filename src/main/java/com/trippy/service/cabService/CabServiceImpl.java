package com.trippy.service.cabService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trippy.exception.CabException;
import com.trippy.models.Cab;
import com.trippy.repository.CabRepo;


@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabRepo cabRepo;

	@Override
	public Cab insertCab(Cab cab) throws CabException {
		Cab addedCab = cabRepo.save(cab);
		if(addedCab==null) {
			throw new CabException("Enter valid Cab informations.........!");
		}
		
		return addedCab;
	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {
		Cab getCab = cabRepo.findById(cab.getCabId()).get();
		
		if(getCab==null) {
			 throw new CabException("Cab not found with the ID : "+cab.getCabId());
		}
		
		Cab updatedCab = cabRepo.save(cab);
		
		return updatedCab;

	}

	@Override
	public Cab deleteCab(Integer cabId) throws CabException {
		Cab deletedCab = cabRepo.findById(cabId).get();
		 
		 if(deletedCab==null) {
			 throw new CabException("Cab not found with the ID : "+cabId);
		 }
		 else {
			 cabRepo.deleteById(cabId);
		 }
		return deletedCab;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {
		List<Cab> cabList= cabRepo.findByCarType(carType);
		
		if(cabList.size()==0) {
			throw new CabException("Cab list empty of cab type : "+ carType);
		}
		return cabList;
		
	}

	@Override
	public Integer countCabsOfType(String carType) throws CabException {
		Integer count = cabRepo.countByCarType(carType);
		
		if(count==0) {
			throw new CabException("Cabs not found of cab type : "+ carType);
		}
		
		return count;
	}

	
	
	
	
}
