package com.cmvrs.Testing;

import static org.junit.Assert.assertTrue;

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

import com.cmvrs.dao.inte.AccountDao;
import com.cmvrs.dao.inte.AddressDao;
import com.cmvrs.dao.inte.CustomerDao;
import com.cmvrs.dao.inte.PersonnelStatusDao;
import com.cmvrs.model.Account;
import com.cmvrs.model.Address;
import com.cmvrs.model.Customer;
import com.cmvrs.model.PersonnelStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "hibernateTransactionManager")
@ContextConfiguration(locations = "classpath:cmvrs-servlet.xml")
public class SaveCustomerTestCase {

		
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
	private CustomerDao customerDao;
	Customer customer = null;
	Long customerId = 0L;
	List<Customer> custAccessList = null;
	
	@Autowired
	private AccountDao accountDao;
	Account account = null;
	Long accountId = 0L;
	
	@Before
	public void setupForSavingAdminToDatabase() {
		// Address setup

		address = new Address();

		address.setStreetName("90 Park");
		address.setSurburb("Camps Bay");
		address.setTown("Cape Town");
		address.setPostalCode("9000");

		// End Address setup

		// Access Level Security Setup

		pStatus = new PersonnelStatus();
		pStatus.setAccessType("Customer");

		pStatusAccessList = new ArrayList<>();

		pStatusAccessList.add(pStatus);
		pStatusAccessList.add(pStatus1);

		// End Access Level Security Setup

		// Admin Setup

		customer = new Customer();

		customer.setTitle("Mr");
		customer.setName("Happy");
		customer.setSurname("Friendly");
		customer.setIdNumber("56122121234764");
		customer.setUsername("HFriendly");
		customer.setPassword("1234567");
		customer.setEmail("hf@hf.com");
		customer.setMobilePhone("0981231234");
		customer.setHomePhone("9812421534");
		customer.setWorkPhone("0827461948");
		customer.setUserStatus("Active");

		custAccessList =  new ArrayList<Customer>();
		
		custAccessList.add(customer);
		
		// End Admin Setup
		
		//Account setup
		
		account = new Account();
		
		account.setAccountType("Standard");
		account.setBalance(0.0);
		account.setStatus("Active");
		account.setOwing(0.0);
		//End Account setup
	}
	
	public void saveAddressToDatabaseAndSet() {

		addressId = addressDao.saveAddress(address);
				
		assertTrue("Address Saved to the database successfully",	addressId > 0);
		
	}

	public void saveSecurityAccessTypeToDatabase() {
		
		pStatusId = pStatusDao.savePersonnelStatus(pStatus);

		assertTrue("Security access saved to the database", pStatusId > 0);
		 
	}
	
	public void setCustomerAddressAndSecurityAccess()
	{
		customer.setAddress(address);	
		customer.setPersonnelStatus(pStatusAccessList);
		pStatus.setCustomer(custAccessList);
		
		customer.setAccount(account);
		
		
	}
		
	public void saveCustomerToDatabase() {
						
		customerId = customerDao.saveCustomer(customer);
		
		assertTrue("Customer saved to the database", customerId > 0L);

	}
	
	
	
	public void saveCustomerAccount()
	{
		accountId = accountDao.saveAccount(account);
		
		assertTrue("Account saved successfully", accountId > 0);
	}
	
	@Test
	public void savedCustomer() {
		
		saveAddressToDatabaseAndSet();
		
		saveCustomerAccount();
		
		saveSecurityAccessTypeToDatabase();
		
		setCustomerAddressAndSecurityAccess();
				
		saveCustomerToDatabase();
		
		
	}
		
	@After
	public void destroyObjectFromHeap() {
		address = null;
		pStatus = null;
		customer = null;
		pStatusAccessList = null;
		account = null;
	}	
}
