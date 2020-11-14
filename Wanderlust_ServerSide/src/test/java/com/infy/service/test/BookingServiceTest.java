package com.infy.service.test;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyInt;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.dao.BookingDAO;
import com.infy.dao.UserDAO;
import com.infy.model.Booking;
import com.infy.model.Destination;
import com.infy.model.Users;
import com.infy.dao.PackageDAO;
import com.infy.service.BookingServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {
	
	@Mock
	BookingDAO bookingDAO;
	
	@Mock
	UserDAO userDAO;
	
	@Mock
	PackageDAO packageDao;
	
	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();	
	
	@SuppressWarnings("deprecation")
	@Test
	public void emptyBookingList() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("BookingService.BOOKING_NOT_FOUND");
		when(bookingServiceImpl.cancelBooking(anyInt())).thenReturn(Mockito.anyObject());
		bookingServiceImpl.cancelBooking(1006);
	}
}
