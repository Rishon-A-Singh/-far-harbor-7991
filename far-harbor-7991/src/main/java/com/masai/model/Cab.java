package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Service
public class Cab {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer cabId;
	 
	 @NotNull(message = "Car type cannot be null!")
	 @NotBlank
	 private String carType;

	 @NotNull(message = "Rate Per/Km cannot be null!")
	 @NotBlank
	 private Float perKmRate;
	
	 @OneToOne(cascade = CascadeType.ALL,mappedBy = "cab")
	 private Driver driver;
}
