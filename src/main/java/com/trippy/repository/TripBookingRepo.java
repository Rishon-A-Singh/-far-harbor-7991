//package com.trippy.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.trippy.models.TripBooking;
//
//public interface TripBookingRepo extends JpaRepository<TripBooking, Integer>{
//	
//	
//	@Query("select t from TripBooking t where t.customerId=?1")
//	public List<TripBooking> getTrips(Integer cId);
//	
//	@Query("select t from TripBooking t where t.customerId=?1")
//	public TripBooking getPrice(Integer cId);
//
//}
