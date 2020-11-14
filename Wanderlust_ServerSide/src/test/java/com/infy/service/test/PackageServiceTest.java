package com.infy.service.test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.dao.PackageDAO;
import com.infy.model.Destination;
import com.infy.model.Details;
import com.infy.model.Itinerary;
import com.infy.service.PackageServiceImpl;

@RunWith(SpringRunner.class)

@SpringBootTest
public class PackageServiceTest {
	
	@Mock 
	PackageDAO packageDAO;
	
	@InjectMocks
	PackageServiceImpl packageServiceImpl;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();	
	
	@Test
	public void emptyDestinationList() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("PackageService.EMPTY_DESTINATION_LIST");
		when(packageDAO.getPackages(Mockito.anyString())).thenReturn(new ArrayList<Destination>());
		packageServiceImpl.getPackages("Kenya");
	}
	
	@Test
	public void validGetPackages() throws Exception {
		List <Destination> dList = new ArrayList<Destination>();
		Destination destination = new Destination();
		destination.setDestinationId("D1011");
		destination.setContinent("Asia");
		destination.setDestinationName("Highlights of Japan: Tokyo to Kyoto");
		destination.setImageUrl("/assets/tokyo.jpg");
		destination.setNoOfNights(8);
		destination.setFlightCharge(500f);
		destination.setChargePerPerson(3349f);
		destination.setDiscount(0f);
		destination.setAvailability(30);
		Details details = new Details();
		details.setDetailsId("DL111");
		details.setAbout("Discover how centuries-old traditions coexist with cutting-edge culture.The traditional Japanese tea ceremony is the embodiment of Japanese hospitality, representing harmony, respect, purity, and tranquility. You'll experience this Zen aesthetic every day of your Japanese tour-and not only while drinking tea. Uncover ancient temples alongside futuristic cityscapes and witness how Japan's art, architecture, and day-to-day culture continue to reflect its time-honored philosophies.");
		details.setPackageInclusion("8 nights in handpicked hotels,8 breakfasts,4 lunch,3 dinners with beer or wine,5 guided sightseeing tours,Expert tour director & local guides,Private deluxe motor coach");
		details.setHighlights("Japan,Tokyo,Kyoto,Meiji Shrine, Mount Fuji,Lake Ashi,Hakone Open-Air Museum,High-speed bullet train ride,Golden Pavilion,Fushimi Inari complex,Nara,Osaka Castle");
		details.setPace("On this guided tour, you'll walk for about 2.5 hours daily across mostly flat terrain, including paved roads and gravel paths, with few hills. You may need to climb stairs when visiting temples.");
		Itinerary itinerary = new Itinerary();
		itinerary.setItineraryId("I1011");
		itinerary.setFirstDay("Travel day: Board your overnight flight to Tokyo.");
		itinerary.setRestOfDays("Kyoto,Meiji Shrine,Mount Fuji,Lake Ashi,Hakone Open-Air Museum,high-speed bullet train ride,Golden Pavilion");
		itinerary.setLastDay("Departure:Transfer to the airport for your flight home.");
		details.setItinerary(itinerary);
		destination.setDetails(details);
		dList.add(destination);
		Mockito.when(packageDAO.getPackages(anyString())).thenReturn(dList);
		packageServiceImpl.getPackages("Japan");
	}
}