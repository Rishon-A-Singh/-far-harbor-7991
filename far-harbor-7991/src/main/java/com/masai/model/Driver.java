package com.masai.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Service
public class Driver extends User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer driverId;
	
	
	@NotNull(message = "License Number cannot be null!")
	@NotBlank(message = "License Number be blank!")
	private String licenseNo;
	
	@Pattern(regexp = "[1]{1-5}", message = "Rate your experience within 1-5")
	private Float rating;
	
	@NotNull(message = "User data is mandatory")
	@Embedded
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@ElementCollection(fetch = FetchType.EAGER)
//	private Set<Cab> cab = new HashSet<>();
	private Cab cab;

}


