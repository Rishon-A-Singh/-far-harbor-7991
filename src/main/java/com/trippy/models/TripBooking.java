package com.trippy.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
public class TripBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	@NotNull
	@NotEmpty
	@NotBlank
	private String fromLocation;
	@NotNull
	@NotEmpty
	@NotBlank
	private String toLocation;
	@NotNull
	private LocalDateTime toDateTime;
	@NotNull
	private LocalDateTime fromDateTime;
	@NotNull
	private Boolean status;
	@NotNull
	@Min(3)
	private Float distanceInKm;
	@NotNull
	private Float bill;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "trip")
	@ElementCollection(fetch = FetchType.EAGER)
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;
	
}