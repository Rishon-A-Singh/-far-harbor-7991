//package com.trippy.models;
//
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//
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
//public class Admin extends User{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer adminId;
//	
//	@Embedded
//	@NotNull(message = "User data is mandatory")
//	private User user;
//
//
//}
