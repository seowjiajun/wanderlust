package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.BookingEntity;
import com.infy.entity.DestinationEntity;
import com.infy.entity.UserEntity;
import com.infy.model.Booking;
import com.infy.model.Destination;
import com.infy.model.Details;
import com.infy.model.Itinerary;
import com.infy.model.Users;

@Repository(value = "bookingDAO")
public class BookingDAOImpl implements BookingDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Booking getBookingByBookingId(Integer bookingId) throws Exception {
		Booking booking = null;
		BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
		if (bookingEntity != null) {
			booking = new Booking();
			booking.setBookingId(bookingEntity.getBookingId());
			booking.setCheckIn(bookingEntity.getCheckIn());
			booking.setCheckOut(bookingEntity.getCheckOut());
			booking.setNoOfPeople(bookingEntity.getNoOfPeople());
			booking.setTotalCost(bookingEntity.getTotalCost());
			booking.setTimeOfBooking(bookingEntity.getTimeOfBooking());
			Destination destination = new Destination();
			destination.setDestinationId(bookingEntity.getDestination().getDestinationId());
			destination.setContinent(bookingEntity.getDestination().getContinent());
			destination.setDestinationName(bookingEntity.getDestination().getDestinationName());
			destination.setImageUrl(bookingEntity.getDestination().getImageUrl());
			destination.setNoOfNights(bookingEntity.getDestination().getNoOfNights());
			destination.setFlightCharge(bookingEntity.getDestination().getFlightCharge());
			destination.setChargePerPerson(bookingEntity.getDestination().getChargePerPerson());
			destination.setDiscount(bookingEntity.getDestination().getDiscount());
			destination.setAvailability(bookingEntity.getDestination().getAvailability());
			if (bookingEntity.getDestination().getDetails() != null) {
				Details details = new Details();
				details.setDetailsId(bookingEntity.getDestination().getDetails().getDetailsId());
				details.setAbout(bookingEntity.getDestination().getDetails().getAbout());
				details.setPackageInclusion(bookingEntity.getDestination().getDetails().getPackageInclusion());
				details.setHighlights(bookingEntity.getDestination().getDetails().getHighlights());
				details.setPace(bookingEntity.getDestination().getDetails().getPace());
				if (bookingEntity.getDestination().getDetails().getItinerary() != null) {
					Itinerary itinerary = new Itinerary();
					itinerary.setItineraryId(bookingEntity.getDestination().getDetails().getItinerary().getItineraryId());
					itinerary.setFirstDay(bookingEntity.getDestination().getDetails().getItinerary().getFirstDay());
					itinerary.setRestOfDays(bookingEntity.getDestination().getDetails().getItinerary().getRestOfDays());
					itinerary.setLastDay(bookingEntity.getDestination().getDetails().getItinerary().getLastDay());
					details.setItinerary(itinerary);
				}
				destination.setDetails(details);
			}
			booking.setDestination(destination);
			Users user = new Users();
			user.setUserId(bookingEntity.getUser().getUserId());
			user.setUserName(bookingEntity.getUser().getUserName());
			user.setEmailId(bookingEntity.getUser().getEmailId());
			user.setContactNumber(bookingEntity.getUser().getContactNumber());
			user.setPassword(null);
			booking.setUser(user);
		}
		return booking;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getBookings(Integer userId) throws Exception {
		List<Booking> bookingList = new ArrayList<Booking>();
		UserEntity userEntity = entityManager.find(UserEntity.class, userId);
		Users user = new Users();
		user.setUserId(userEntity.getUserId());
		user.setUserName(userEntity.getUserName());
		user.setEmailId(userEntity.getEmailId());
		user.setContactNumber(userEntity.getContactNumber());
		user.setPassword(null);
		Query query = entityManager.createQuery("SELECT b FROM BookingEntity b WHERE b.user.userId = :userId");
		query.setParameter("userId", userId);
		List<BookingEntity> bookingEntities = query.getResultList();
		for (BookingEntity bookingEntity : bookingEntities) {
			Booking booking = new Booking();
			booking.setBookingId(bookingEntity.getBookingId());
			booking.setCheckIn(bookingEntity.getCheckIn());
			booking.setCheckOut(bookingEntity.getCheckOut());
			booking.setNoOfPeople(bookingEntity.getNoOfPeople());
			booking.setTotalCost(bookingEntity.getTotalCost());
			booking.setTimeOfBooking(bookingEntity.getTimeOfBooking());
			Destination destination = new Destination();
			destination.setDestinationId(bookingEntity.getDestination().getDestinationId());
			destination.setContinent(bookingEntity.getDestination().getContinent());
			destination.setDestinationName(bookingEntity.getDestination().getDestinationName());
			destination.setImageUrl(bookingEntity.getDestination().getImageUrl());
			destination.setNoOfNights(bookingEntity.getDestination().getNoOfNights());
			destination.setFlightCharge(bookingEntity.getDestination().getFlightCharge());
			destination.setChargePerPerson(bookingEntity.getDestination().getChargePerPerson());
			destination.setDiscount(bookingEntity.getDestination().getDiscount());
			destination.setAvailability(bookingEntity.getDestination().getAvailability());
			if (bookingEntity.getDestination().getDetails() != null) {
				Details details = new Details();
				details.setDetailsId(bookingEntity.getDestination().getDetails().getDetailsId());
				details.setAbout(bookingEntity.getDestination().getDetails().getAbout());
				details.setPackageInclusion(bookingEntity.getDestination().getDetails().getPackageInclusion());
				details.setHighlights(bookingEntity.getDestination().getDetails().getHighlights());
				details.setPace(bookingEntity.getDestination().getDetails().getPace());
				if (bookingEntity.getDestination().getDetails().getItinerary() != null) {
					Itinerary itinerary = new Itinerary();
					itinerary.setItineraryId(bookingEntity.getDestination().getDetails().getItinerary().getItineraryId());
					itinerary.setFirstDay(bookingEntity.getDestination().getDetails().getItinerary().getFirstDay());
					itinerary.setRestOfDays(bookingEntity.getDestination().getDetails().getItinerary().getRestOfDays());
					itinerary.setLastDay(bookingEntity.getDestination().getDetails().getItinerary().getLastDay());
					details.setItinerary(itinerary);
				}
				destination.setDetails(details);
			}
			booking.setDestination(destination);
			booking.setUser(user);
			bookingList.add(booking);
		}
		return bookingList;
	}
	
	@Override
	public Booking makeBooking(Booking booking) {
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setCheckIn(booking.getCheckIn());
		bookingEntity.setCheckOut(booking.getCheckOut());
		bookingEntity.setNoOfPeople(booking.getNoOfPeople());
		bookingEntity.setTotalCost(booking.getTotalCost());
		bookingEntity.setTimeOfBooking(booking.getTimeOfBooking());
		UserEntity userEntity = entityManager.find(UserEntity.class, booking.getUser().getUserId());
		bookingEntity.setUser(userEntity);
		DestinationEntity destinationEntity = entityManager.find(DestinationEntity.class, booking.getDestination().getDestinationId());
		bookingEntity.setDestination(destinationEntity);
		destinationEntity.setAvailability(destinationEntity.getAvailability() - booking.getNoOfPeople());
		bookingEntity.setDestination(destinationEntity);
		entityManager.persist(bookingEntity);
		booking.setBookingId(bookingEntity.getBookingId());
		Destination destination = new Destination();
		destination.setDestinationId(bookingEntity.getDestination().getDestinationId());
		destination.setContinent(bookingEntity.getDestination().getContinent());
		destination.setDestinationName(bookingEntity.getDestination().getDestinationName());
		destination.setImageUrl(bookingEntity.getDestination().getImageUrl());
		destination.setNoOfNights(bookingEntity.getDestination().getNoOfNights());
		destination.setFlightCharge(bookingEntity.getDestination().getFlightCharge());
		destination.setChargePerPerson(bookingEntity.getDestination().getChargePerPerson());
		destination.setDiscount(bookingEntity.getDestination().getDiscount());
		destination.setAvailability(bookingEntity.getDestination().getAvailability());
		if (bookingEntity.getDestination().getDetails() != null) {
			Details details = new Details();
			details.setDetailsId(bookingEntity.getDestination().getDetails().getDetailsId());
			details.setAbout(bookingEntity.getDestination().getDetails().getAbout());
			details.setPackageInclusion(bookingEntity.getDestination().getDetails().getPackageInclusion());
			details.setHighlights(bookingEntity.getDestination().getDetails().getHighlights());
			details.setPace(bookingEntity.getDestination().getDetails().getPace());
			if (bookingEntity.getDestination().getDetails().getItinerary() != null) {
				Itinerary itinerary = new Itinerary();
				itinerary.setItineraryId(bookingEntity.getDestination().getDetails().getItinerary().getItineraryId());
				itinerary.setFirstDay(bookingEntity.getDestination().getDetails().getItinerary().getFirstDay());
				itinerary.setRestOfDays(bookingEntity.getDestination().getDetails().getItinerary().getRestOfDays());
				itinerary.setLastDay(bookingEntity.getDestination().getDetails().getItinerary().getLastDay());
				details.setItinerary(itinerary);
			}
			destination.setDetails(details);
		}
		booking.setDestination(destination);
		Users user = new Users();
		user.setUserId(userEntity.getUserId());
		user.setUserName(userEntity.getUserName());
		user.setEmailId(userEntity.getEmailId());
		user.setContactNumber(userEntity.getContactNumber());
		user.setPassword(null);
		booking.setUser(user);
		return booking;
	}
	
	@Override
	public void cancelBooking(Integer bookingId) {
		BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
		DestinationEntity destinationEntity = bookingEntity.getDestination();
		destinationEntity.setAvailability(destinationEntity.getAvailability() + bookingEntity.getNoOfPeople());
		bookingEntity.setDestination(null);
		bookingEntity.setUser(null);
		entityManager.remove(bookingEntity);
	}
}
