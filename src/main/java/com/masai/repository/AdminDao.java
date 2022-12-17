package com.masai.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Admin;
import com.trippy.models.TripBooking;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{
	
	@Query("select t from TripBooking t where t.customerId=?1")
	public List<TripBooking> findByCustomerId(Integer customerId);

	@Query("select t from TripBooking inner join Customer c on t.customerId=c.customerId order by c.userName")
	public List<TripBooking> findByCustomerName();

	@Query("select t from TripBooking t order by t.fromDateTime")
	public List<TripBooking> findByDate();

	@Query("select t, c from Driver d inner join TripBooking t on t.driverId=d.driverId inner join Cab c on c.cabId=d.cabId order by c.cabId")
	public List<TripBooking> findCabWise();

	@Query("select t from TripBooking t where t.customerId=?1 between t.fromDate=?2 and t.toDate=?3")
	public List<TripBooking> findTripForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate);
}