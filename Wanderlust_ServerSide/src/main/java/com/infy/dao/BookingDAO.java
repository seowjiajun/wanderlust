package com.infy.dao;

import java.util.List;

import com.infy.model.Booking;

public interface BookingDAO {
	
	public Booking getBookingByBookingId(Integer bookingId) throws Exception;

	public List<Booking> getBookings(Integer userId) throws Exception;
	
	public Booking makeBooking(Booking booking) throws Exception;
	
	public void cancelBooking(Integer bookingId) throws Exception;
}
