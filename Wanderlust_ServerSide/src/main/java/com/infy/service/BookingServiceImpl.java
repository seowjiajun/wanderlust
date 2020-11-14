package com.infy.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.BookingDAO;
import com.infy.dao.PackageDAO;
import com.infy.dao.UserDAO;
import com.infy.model.Booking;

@Service(value = "bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PackageDAO packageDAO;

	@Autowired
	private BookingDAO bookingDAO;

	@Override
	public List<Booking> getBookings(Integer userId) throws Exception {
		if (userDAO.getUserByUserId(userId) == null) {
			throw new Exception("BookingService.USER_NOT_FOUND");
		}
		List<Booking> bookingList = bookingDAO.getBookings(userId);
		if (bookingList.isEmpty()) {
			throw new Exception("BookingService.EMPTY_BOOKING_LIST");
		}
		return bookingList;
	}
	
	@Override
	public Booking makeBooking(Booking booking) throws Exception {
		if (userDAO.getUserByUserId(booking.getUser().getUserId()) == null) {
			throw new Exception("BookingService.USER_NOT_FOUND");
		}
		if (packageDAO.getPackageByDestinationId(booking.getDestination().getDestinationId()) == null) {
			throw new Exception("BookingService.DESTINATION_NOT_FOUND");
		}
		if (booking.getCheckIn().isAfter(booking.getCheckOut())) {
			throw new Exception("BookingService.INVALID_CHECK_DATES");
		}
		if (booking.getCheckIn().isBefore(LocalDate.now()) || booking.getCheckOut().isBefore(LocalDate.now())) {
			throw new Exception("BookingService.PAST_CHECK_DATES");
		}
		if (booking.getNoOfPeople() <= 0 || booking.getNoOfPeople() > 5) {
			throw new Exception("BookingService.INVALID_NO_OF_PEOPLE");
		}
		if (packageDAO.getPackageByDestinationId(booking.getDestination().getDestinationId()).getAvailability() - booking.getNoOfPeople() < 0) {
			throw new Exception("BookingService.INSUFFICIENT_AVAILABILITY");
		}
		if (booking.getTimeOfBooking() == null) {
			booking.setTimeOfBooking(LocalDateTime.now());
		}
		booking = bookingDAO.makeBooking(booking);
		return booking;
	}
	
	@Override 
	public Booking cancelBooking(Integer bookingId) throws Exception {
		Booking booking = bookingDAO.getBookingByBookingId(bookingId);
		if (booking == null) {
			throw new Exception("BookingService.BOOKING_NOT_FOUND");
		}
		if (LocalDate.now().isAfter(booking.getCheckIn()) || LocalDate.now().isAfter(booking.getCheckOut())) {
			throw new Exception("BookingService.CANCEL_BOOKING_DATE_RESTRICTION");
		}
		bookingDAO.cancelBooking(bookingId);
		return booking;
	}
}
