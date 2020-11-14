package com.infy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.model.Booking;
import com.infy.service.BookingService;

@CrossOrigin
@RestController
@RequestMapping(value = "Wanderlust_Server/BookingAPI")
public class BookingAPI {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private Environment environment;

	@GetMapping(value = "/getBookings/{userId}")
	public ResponseEntity<List<Booking>> getBooking(@PathVariable Integer userId) throws Exception {
		try {
			List<Booking> bookingList = bookingService.getBookings(userId);
			return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()));
		}
	}

	@RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
	public ResponseEntity<Booking> registerUser(@RequestBody Booking booking) {
		try {
			booking = bookingService.makeBooking(booking);
			return new ResponseEntity<Booking>(booking, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(exception.getMessage()));
		}
	}

	@GetMapping(value = "/cancelBooking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable Integer bookingId) throws Exception {
		try {
			Booking booking = bookingService.cancelBooking(bookingId);
			return new ResponseEntity<Booking>(booking, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()));
		}
	}
}
