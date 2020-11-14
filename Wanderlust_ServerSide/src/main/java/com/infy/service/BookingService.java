package com.infy.service;

import java.util.List;

import com.infy.model.Booking;

public interface BookingService {

	public List<Booking> getBookings(Integer userId) throws Exception;
	
	public Booking makeBooking(Booking booking) throws Exception;
	
	public Booking cancelBooking(Integer bookingId) throws Exception;
}
