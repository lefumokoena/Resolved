package com.cmvrs.Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.cmvrs.dao.inte.AddressDao;
import com.cmvrs.dao.inte.AdminDao;
import com.cmvrs.dao.inte.PersonnelStatusDao;
import com.cmvrs.model.Address;
import com.cmvrs.model.Admin;
import com.cmvrs.model.PersonnelStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "hibernateTransactionManager")
@ContextConfiguration(locations = "classpath:cmvrs-servlet.xml")
public class SaveAdminTestCase {

		
	@Autowired
	private AddressDao addressDao;
	Address address = null;
	Long addressId = 0L;
	Address loadingAddressForAdmin = null;

	@Autowired
	private PersonnelStatusDao pStatusDao;
	PersonnelStatus pStatus = null;
	PersonnelStatus pStatus1 = null;
	Long pStatusId = 0L;
	Long pStatusId1 = 0L;
	List<PersonnelStatus> pStatusAccessList = null;

	@Autowired
	private AdminDao adminDao;
	Admin admin = null;
	Long adminId = 0L;
	List<Admin> adminAccessList = null;
	
	@Before
	public void setupForSavingAdminToDatabase() {
		// Address setup

		address = new Address();

		address.setStreetName("15 Blvd");
		address.setSurburb("Bellville");
		address.setTown("TygerVelly");
		address.setPostalCode("123");

		// End Address setup

		// Access Level Security Setup

		pStatus = new PersonnelStatus();
		pStatus.setAccessType("Admin");

		pStatus1 = new PersonnelStatus();
		pStatus1.setAccessType("User");

		pStatusAccessList = new ArrayList<>();

		pStatusAccessList.add(pStatus);
		pStatusAccessList.add(pStatus1);

		// End Access Level Security Setup

		// Admin Setup

		admin = new Admin();

		admin.setTitle("Mr");
		admin.setName("Jubile");
		admin.setSurname("Lethabo");
		admin.setIdNumber("5612121234764");
		admin.setUsername("JLethabo1");
		admin.setPassword("123456");
		admin.setEmail("jL@jL.com");
		admin.setMobilePhone("0981231234");
		admin.setHomePhone("9812421534");
		admin.setWorkPhone("0827461948");
		admin.setUserStatus("Active");

		adminAccessList =  new ArrayList<Admin>();
		
		adminAccessList.add(admin);
		
		// End Admin Setup
	}
	
	public void saveAddressToDatabaseAndSetToAdmin() {

		addressId = addressDao.saveAddress(address);
				
		assertTrue("Address Id Saved to the database successfully",	addressId > 0);
		
	}

	public void saveSecurityAccessTypeToDatabaseAndSetToAdmin() {
		
		pStatusId = pStatusDao.savePersonnelStatus(pStatus);

		assertTrue("Security access saved to the database", pStatusId > 0);

		pStatusId1 = pStatusDao.savePersonnelStatus(pStatus1);

		assertTrue("Security access saved to the database", pStatusId1 > 0);
		 
	}
	
	public void setAdminAddressAndSecurityAccess()
	{
		admin.setAddress(address);	
		admin.setPersonnelStatus(pStatusAccessList);
		pStatus.setAdmin(adminAccessList);
		pStatus1.setAdmin(adminAccessList);
	}
		
	public void saveAdminToDatabase() {
						
		adminId = adminDao.saveAdmin(admin);

		assertTrue("Admin saved to the database", adminId > 0);

	}
	
	@Test
	public void savedAdmin() {
		
		saveAddressToDatabaseAndSetToAdmin();
		
		saveSecurityAccessTypeToDatabaseAndSetToAdmin();
		
		setAdminAddressAndSecurityAccess();
		
		saveAdminToDatabase();
				
	}
		
	@After
	public void destroyObjectFromHeap() {
		address = null;
		pStatus = null;
		admin = null;
		pStatusAccessList = null;
	}	
}
