package com.infy.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer noOfPeople;
	private Float totalCost;
	private LocalDateTime timeOfBooking;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DESTINATION_ID")
	private DestinationEntity destination;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private UserEntity user;
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public LocalDate getCheckIn() {
		return checkIn;
	}
	
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	
	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	public Integer getNoOfPeople() {
		return noOfPeople;
	}
	
	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	
	public Float getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
	
	public LocalDateTime getTimeOfBooking() {
		return timeOfBooking;
	}
	
	public void setTimeOfBooking(LocalDateTime timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}
	
	public DestinationEntity getDestination() {
		return destination;
	}
	
	public void setDestination(DestinationEntity destination) {
		this.destination = destination;
	}
	
	public UserEntity getUser() {
		return user;
	}
	
	public void setUser(UserEntity user) {
		this.user = user;
	}
}