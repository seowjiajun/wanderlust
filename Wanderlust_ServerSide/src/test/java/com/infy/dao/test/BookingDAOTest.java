package com.infy.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.BookingDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class BookingDAOTest {

	@Autowired
	BookingDAO bookingDAO;

	@Test
	public void invalidGetBookingByBookingId() throws Exception{
		Assert.assertNull(bookingDAO.getBookingByBookingId(1010));
	}
	
	@Test
	public void validGetBookingByBookingId() throws Exception{
		Assert.assertNotNull(bookingDAO.getBookingByBookingId(1001));
	}
	
	@Test
	public void invalidGetBookingsBookings() throws Exception{
		Assert.assertTrue(bookingDAO.getBookings(110).isEmpty());
	}
	
	@Test
	public void validGetBookings() throws Exception{
		Assert.assertFalse(bookingDAO.getBookings(101).isEmpty());
	}
}