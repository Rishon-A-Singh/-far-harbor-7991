//package com.trippy.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.trippy.exception.CustomerException;
//import com.trippy.exception.TripBookingException;
//import com.trippy.models.TripBooking;
//import com.trippy.service.tripBookingService.TripBookingService;
//
//@RestController
//@RequestMapping("/tripBooking")
//public class TripBookingController {
//	
//	@Autowired
//	private TripBookingService tripServe;
//	
//	
//	@PostMapping("/trip")
//	public ResponseEntity<TripBooking> insertTripBooking(@Valid @RequestBody TripBooking tripBooking) throws TripBookingException{
//		TripBooking insertedTrip = tripServe.insertTripBooking(tripBooking);
//		return new ResponseEntity<TripBooking>(insertedTrip, HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/trip")
//	public ResponseEntity<TripBooking> updateTripBookingHandler(@Valid @RequestBody TripBooking tripBooking) throws TripBookingException{
//		TripBooking updateTrip = tripServe.updateTripBooking(tripBooking);
//		return new ResponseEntity<TripBooking>(updateTrip, HttpStatus.ACCEPTED);
//	}
//	
//	@DeleteMapping("/trip")
//	public ResponseEntity<TripBooking> deleteTripBookingHandler(@RequestBody TripBooking tripBooking) throws TripBookingException{
//		TripBooking deletedTrip = tripServe.deleteTripBooking(tripBooking);
//		return new ResponseEntity<TripBooking>(deletedTrip, HttpStatus.OK);
//	}
//	
//	@GetMapping("/trip/{id}")
//	public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable("id") Integer customerId) throws TripBookingException{
//		List<TripBooking> list = tripServe.viewAllTripCustomers(customerId);
//		
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
//	
//	
//	
//	@GetMapping("/tripBill/{id}")
//	public ResponseEntity<Float> getBill(@PathVariable("id") Integer customerId) throws TripBookingException, CustomerException{
//		
//		Float price= tripServe.calculateBill(customerId);
//		
//		return new ResponseEntity<>(price, HttpStatus.OK);
//	}
//	
//	
//	
//
//}
