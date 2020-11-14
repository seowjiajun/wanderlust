package com.infy.dao;

import java.util.List;

import com.infy.model.Destination;

public interface PackageDAO {
	
	public Destination getPackageByDestinationId(String destinationId) throws Exception;

	public List<Destination> getPackages(String destinationName) throws Exception;
	
	public List<Destination> getPackageDeals() throws Exception;
}
