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

import com.masai.Exception.CabException;
import com.masai.Exception.DriverException;
import com.masai.cabService.CabService;
import com.masai.model.Cab;
import com.masai.model.Driver;

@RestController
@RequestMapping("/cabService")
public class CabController {

	@Autowired
	private CabService cabServe;
	
	

	@PostMapping("/cabs")
	public ResponseEntity<Cab> registerCab(@Valid @RequestBody Cab cab) throws CabException{
		
		Cab addedCab = cabServe.insertCab(cab);
		
		return new ResponseEntity<Cab>(addedCab,HttpStatus.CREATED); 
		
	}
	
	
	
	@PutMapping("/cabs")
	public ResponseEntity<Cab> updateCab(@Valid @RequestBody Cab cab) throws CabException{
		
		Cab updatedCab = cabServe.updateCab(cab);
		
		return new ResponseEntity<Cab>(updatedCab,HttpStatus.OK); 
		
	}
	
	
	@DeleteMapping("/cabs/{cabId}")
	public ResponseEntity<Cab> deleteCabbyId(@PathVariable("cabId")Integer id) throws CabException{
		
		Cab deletedCab = cabServe.deleteCab(id);
		
		return new ResponseEntity<Cab>(deletedCab,HttpStatus.OK); 
		
	}
	
	
	@GetMapping("/cabs/{carType}")
	public ResponseEntity<List<Cab>> viewcabsOfType(@PathVariable("carType")String cartype) throws CabException{
		
		List<Cab> list = cabServe.viewCabsOfType(cartype);
		
		return new ResponseEntity<>(list,HttpStatus.OK); 
		
	}
	
	@GetMapping("/cabCount/{carType}")
	public ResponseEntity<Integer> countcabsOfType(@PathVariable("carType")String cartype) throws CabException{
		
		Integer count = cabServe.countCabsOfType(cartype);
		
		return new ResponseEntity<>(count,HttpStatus.OK); 
		
	}
	
	
	
}
