package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.DestinationEntity;
import com.infy.model.Destination;
import com.infy.model.Details;
import com.infy.model.Itinerary;

@Repository(value = "packageDAO")
public class PackageDAOImpl implements PackageDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Destination getPackageByDestinationId(String destinationId) throws Exception {
		Destination destination = null;
		DestinationEntity destinationEntity = entityManager.find(DestinationEntity.class, destinationId);
		if (destinationEntity != null) {
			destination = new Destination();
			destination.setDestinationId(destinationEntity.getDestinationId());
			destination.setContinent(destinationEntity.getContinent());
			destination.setDestinationName(destinationEntity.getDestinationName());
			destination.setImageUrl(destinationEntity.getImageUrl());
			destination.setNoOfNights(destinationEntity.getNoOfNights());
			destination.setFlightCharge(destinationEntity.getFlightCharge());
			destination.setChargePerPerson(destinationEntity.getChargePerPerson());
			destination.setDiscount(destinationEntity.getDiscount());
			destination.setAvailability(destinationEntity.getAvailability());
			if (destinationEntity.getDetails() != null) {
				Details details = new Details();
				details.setDetailsId(destinationEntity.getDetails().getDetailsId());
				details.setAbout(destinationEntity.getDetails().getAbout());
				details.setPackageInclusion(destinationEntity.getDetails().getPackageInclusion());
				details.setHighlights(destinationEntity.getDetails().getHighlights());
				details.setPace(destinationEntity.getDetails().getPace());
				if (destinationEntity.getDetails().getItinerary() != null) {
					Itinerary itinerary = new Itinerary();
					itinerary.setItineraryId(destinationEntity.getDetails().getItinerary().getItineraryId());
					itinerary.setFirstDay(destinationEntity.getDetails().getItinerary().getFirstDay());
					itinerary.setRestOfDays(destinationEntity.getDetails().getItinerary().getRestOfDays());
					itinerary.setLastDay(destinationEntity.getDetails().getItinerary().getLastDay());
					details.setItinerary(itinerary);
				}
				destination.setDetails(details);
			}
		}
		return destination;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> getPackages(String destinationName) throws Exception {
		List<Destination> destinationList = new ArrayList<Destination>();
		Query query = entityManager.createQuery("SELECT d FROM DestinationEntity d" + (destinationName != null && !destinationName.isEmpty() ? " WHERE d.destinationName LIKE :destinationName OR d.continent LIKE :continent" : new String()) + " ORDER BY d.discount DESC");
		if (destinationName != null && !destinationName.isEmpty()) {
			query.setParameter("destinationName", "%" + destinationName + "%");
			query.setParameter("continent", "%" + destinationName + "%");
		}
		List<DestinationEntity> destinationEntities = query.getResultList();
		for (DestinationEntity destinationEntity : destinationEntities) {
			Destination destination = new Destination();
			destination.setDestinationId(destinationEntity.getDestinationId());
			destination.setContinent(destinationEntity.getContinent());
			destination.setDestinationName(destinationEntity.getDestinationName());
			destination.setImageUrl(destinationEntity.getImageUrl());
			destination.setNoOfNights(destinationEntity.getNoOfNights());
			destination.setFlightCharge(destinationEntity.getFlightCharge());
			destination.setChargePerPerson(destinationEntity.getChargePerPerson());
			destination.setDiscount(destinationEntity.getDiscount());
			destination.setAvailability(destinationEntity.getAvailability());
			if (destinationEntity.getDetails() != null) {
				Details details = new Details();
				details.setDetailsId(destinationEntity.getDetails().getDetailsId());
				details.setAbout(destinationEntity.getDetails().getAbout());
				details.setPackageInclusion(destinationEntity.getDetails().getPackageInclusion());
				details.setHighlights(destinationEntity.getDetails().getHighlights());
				details.setPace(destinationEntity.getDetails().getPace());
				if (destinationEntity.getDetails().getItinerary() != null) {
					Itinerary itinerary = new Itinerary();
					itinerary.setItineraryId(destinationEntity.getDetails().getItinerary().getItineraryId());
					itinerary.setFirstDay(destinationEntity.getDetails().getItinerary().getFirstDay());
					itinerary.setRestOfDays(destinationEntity.getDetails().getItinerary().getRestOfDays());
					itinerary.setLastDay(destinationEntity.getDetails().getItinerary().getLastDay());
					details.setItinerary(itinerary);
				}
				destination.setDetails(details);
			}
			destinationList.add(destination);
		}
		return destinationList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> getPackageDeals() throws Exception {
		List<Destination> destinationList = new ArrayList<Destination>();
		Query query = entityManager.createQuery("SELECT d FROM DestinationEntity d WHERE d.discount > 0 ORDER BY d.discount DESC");
		List<DestinationEntity> destinationEntities = query.getResultList();
		for (DestinationEntity destinationEntity : destinationEntities) {
			Destination destination = new Destination();
			destination.setDestinationId(destinationEntity.getDestinationId());
			destination.setContinent(destinationEntity.getContinent());
			destination.setDestinationName(destinationEntity.getDestinationName());
			destination.setImageUrl(destinationEntity.getImageUrl());
			destination.setNoOfNights(destinationEntity.getNoOfNights());
			destination.setFlightCharge(destinationEntity.getFlightCharge());
			destination.setChargePerPerson(destinationEntity.getChargePerPerson());
			destination.setDiscount(destinationEntity.getDiscount());
			destination.setAvailability(destinationEntity.getAvailability());
			if (destinationEntity.getDetails() != null) {
				Details details = new Details();
				details.setDetailsId(destinationEntity.getDetails().getDetailsId());
				details.setAbout(destinationEntity.getDetails().getAbout());
				details.setPackageInclusion(destinationEntity.getDetails().getPackageInclusion());
				details.setHighlights(destinationEntity.getDetails().getHighlights());
				details.setPace(destinationEntity.getDetails().getPace());
				if (destinationEntity.getDetails().getItinerary() != null) {
					Itinerary itinerary = new Itinerary();
					itinerary.setItineraryId(destinationEntity.getDetails().getItinerary().getItineraryId());
					itinerary.setFirstDay(destinationEntity.getDetails().getItinerary().getFirstDay());
					itinerary.setRestOfDays(destinationEntity.getDetails().getItinerary().getRestOfDays());
					itinerary.setLastDay(destinationEntity.getDetails().getItinerary().getLastDay());
					details.setItinerary(itinerary);
				}
				destination.setDetails(details);
			}
			destinationList.add(destination);
		}
		return destinationList;
	}
}
