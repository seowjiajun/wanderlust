package com.infy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.model.Destination;
import com.infy.service.PackageService;

@CrossOrigin
@RestController
@RequestMapping(value = "Wanderlust_Server/PackageAPI")
public class PackageAPI {

	@Autowired
	private PackageService packageService;

	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/getPackages")
	public ResponseEntity<List<Destination>> getPackages() throws Exception {
		try {
			List<Destination> destinationList = packageService.getPackages(null);
			return new ResponseEntity<List<Destination>>(destinationList, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(exception.getMessage()));
		}
	}
	
	@GetMapping(value = "/getPackageDeals")
	public ResponseEntity<List<Destination>> getPackageDeals() throws Exception {
		try {
			List<Destination> destinationList = packageService.getPackageDeals();
			return new ResponseEntity<List<Destination>>(destinationList, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(exception.getMessage()));
		}
	}
	
	@GetMapping(value = "/getPackageById/{destinationId}")
	public ResponseEntity<Destination> getPackageById(@PathVariable String destinationId) throws Exception {
		try {
			Destination destination = packageService.getPackageById(destinationId);
			return new ResponseEntity<Destination>(destination, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()));
		}
	}
	
	@GetMapping(value = "/getPackages/{destinationName}")
	public ResponseEntity<List<Destination>> getPackages(@PathVariable String destinationName) throws Exception {
		try {
			List<Destination> destinationList = packageService.getPackages(destinationName);
			return new ResponseEntity<List<Destination>>(destinationList, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(exception.getMessage()));
		}
	}
}
