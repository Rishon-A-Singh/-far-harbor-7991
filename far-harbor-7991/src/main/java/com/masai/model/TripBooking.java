package com.masai.model;

public class TripBooking {

	
	private Integer tripBooking;
	private Integer customerId;
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	private Boolean status;
	private Float distanceInKm;
	private Float bill;
	
	public TripBooking() {
		
	}

	public Integer getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(Integer tripBooking) {
		this.tripBooking = tripBooking;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(Float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public Float getBill() {
		return bill;
	}

	public void setBill(Float bill) {
		this.bill = bill;
	}

	public TripBooking(Integer tripBooking, Integer customerId, Driver driver, String fromLocation, String toLocation,
			Boolean status, Float distanceInKm, Float bill) {
		super();
		this.tripBooking = tripBooking;
		this.customerId = customerId;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "TripBooking [tripBooking=" + tripBooking + ", customerId=" + customerId + ", fromLocation="
				+ fromLocation + ", toLocation=" + toLocation + ", status=" + status + ", distanceInKm=" + distanceInKm
				+ ", bill=" + bill + "]";
	}
	
	
	
}
