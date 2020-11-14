package com.infy.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.PackageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class PackageDAOTest {

	@Autowired
	PackageDAO packageDAO;

	@Test
	public void invalidDestinationName() throws Exception {
		Assert.assertTrue(packageDAO.getPackages("Abc").isEmpty());
	}
	
	@Test
	public void validDestination() throws Exception{
		Assert.assertFalse(packageDAO.getPackages("Singapore").isEmpty());
	}
	
	@Test
	public void invalidDestinationId() throws Exception{
		Assert.assertNull(packageDAO.getPackageByDestinationId("D1015"));
	}
	
	@Test
	public void validDestinationId() throws Exception{
		Assert.assertNotNull(packageDAO.getPackageByDestinationId("D1001"));
	}
}