package com.infy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.PackageDAO;
import com.infy.model.Destination;

@Service(value = "packageService")
@Transactional
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageDAO packageDAO;

	@Override
	public List<Destination> getPackages(String destinationName) throws Exception {
		List<Destination> destinationList = packageDAO.getPackages(destinationName);
		if (destinationList.isEmpty())
			throw new Exception("PackageService.EMPTY_DESTINATION_LIST");
		return destinationList;
	}
	
	@Override
	public List<Destination> getPackageDeals() throws Exception {
		List<Destination> destinationList = packageDAO.getPackageDeals();
		if (destinationList.isEmpty())
			throw new Exception("PackageService.EMPTY_DESTINATION_LIST");
		return destinationList;
	}
	
	@Override
	public Destination getPackageById(String destinationId) throws Exception {
		Destination destination = packageDAO.getPackageByDestinationId(destinationId);
		if (destination == null)
			throw new Exception("PackageService.DESTIONATION_NOT_FOUND");
		return destination;
	}
}
