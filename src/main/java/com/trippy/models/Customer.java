//package com.trippy.models;
//
//import javax.persistence.CascadeType;
//import javax.persistence.ElementCollection;
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.annotations.Fetch;
//import org.springframework.stereotype.Service;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Service
//public class Customer extends User{
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer customerId;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	private TripBooking trip;
//	
//	@Embedded
//	@NotNull(message="User details are mandatory")
//	private User user;
//	
//
//	
//}