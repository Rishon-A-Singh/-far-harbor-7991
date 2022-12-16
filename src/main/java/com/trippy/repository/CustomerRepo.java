//package com.trippy.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.trippy.models.Customer;
//
//public interface CustomerRepo extends JpaRepository<Customer, Integer>{
//	
//	
//	@Query("select c from Customer c where c.userName=?1 AND c.password=?2")
//	public Customer validateCustomer(String username,String password);
//
//}
