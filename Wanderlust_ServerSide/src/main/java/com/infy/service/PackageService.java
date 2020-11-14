package com.infy.service;

import java.util.List;

import com.infy.model.Destination;

public interface PackageService {
	
	public List<Destination> getPackages(String destinationName) throws Exception;
	
	public List<Destination> getPackageDeals() throws Exception;
	
	public Destination getPackageById(String destinationId) throws Exception;
}
