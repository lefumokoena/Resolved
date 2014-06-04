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
	Address address1 = null;
	Address address2 = null;
	Address address3 = null;
	
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
	Customer customer1 = null;
	Customer customer2 = null;
	Customer customer3 = null;

	
	Long customerId = 0L;
	List<Customer> custAccessList = null;
	
	@Autowired
	private AccountDao accountDao;
	
	Account account = null;
	Account account1 = null;
	Account account2 = null;
	Account account3 = null;
	
	Long accountId = 0L;
	
	@Before
	public void setupForSavingAdminToDatabase() {
		// Address setup

		address = new Address();
		address1 = new Address();
		address2 = new Address();
		address3 = new Address();

		address1.setStreetName("90 Park");
		address1.setSurburb("Camps Bay");
		address1.setTown("Cape Town");
		address1.setPostalCode("3324");


		address2.setStreetName("Central Park");
		address2.setSurburb("NY");
		address2.setTown("Cape Town");
		address2.setPostalCode("5300");

		address3.setStreetName("Menlo Park");
		address3.setSurburb("LA");
		address3.setTown("Cape Town");
		address3.setPostalCode("1000");

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
		
		// End Access Level Security Setup

		// Admin Setup

		customer = new Customer();
		customer1 = new Customer();
		customer2 = new Customer();
		customer3 = new Customer();

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

		
		customer1.setTitle("Mrs");
		customer1.setName("Julie");
		customer1.setSurname("Friendly");
		customer1.setIdNumber("564222121234764");
		customer1.setUsername("JFriendly");
		customer1.setPassword("123451678");
		customer1.setEmail("jf@jf.com");
		customer1.setMobilePhone("0581231234");
		customer1.setHomePhone("9845421534");
		customer1.setWorkPhone("08454461948");
		customer1.setUserStatus("Active");

		customer2.setTitle("Miss");
		customer2.setName("Lolly");
		customer2.setSurname("Smithinson");
		customer2.setIdNumber("5642231934764");
		customer2.setUsername("JSmithn");
		customer2.setPassword("1234516789");
		customer2.setEmail("ls@ls.com");
		customer2.setMobilePhone("05812331234");
		customer2.setHomePhone("98454215434");
		customer2.setWorkPhone("084544619448");
		customer2.setUserStatus("Active");

		customer3.setTitle("Miss");
		customer3.setName("Gill");
		customer3.setSurname("Stronghold");
		customer3.setIdNumber("6642221934764");
		customer3.setUsername("GHlds");
		customer3.setPassword("1234567892");
		customer3.setEmail("gs@gs.com");
		customer3.setMobilePhone("05812331234");
		customer3.setHomePhone("98454215434");
		customer3.setWorkPhone("084544619448");
		customer3.setUserStatus("Active");
		
		custAccessList =  new ArrayList<Customer>();
		
		custAccessList.add(customer);
		custAccessList.add(customer1);
		custAccessList.add(customer2);
		custAccessList.add(customer3);
		
		// End Admin Setup
		
		//Account setup
		
		account = new Account();
		account1 = new Account();
		account2 = new Account();
		account3 = new Account();
		
		account.setAccountType("Standard");
		account.setBalance(0.0);
		account.setStatus("Active");
		account.setOwing(0.0);
		
		account1.setAccountType("Standard");
		account1.setBalance(20.0);
		account1.setStatus("Active");
		account1.setOwing(-30.0);

		account2.setAccountType("Standard");
		account2.setBalance(0.0);
		account2.setStatus("Active");
		account2.setOwing(-1.90);

		account3.setAccountType("Standard");
		account3.setBalance(434.0);
		account3.setStatus("Active");
		account3.setOwing(-23.0);

		//End Account setup
	}
	
	public void saveAddressToDatabaseAndSet() {

		addressId = addressDao.saveAddress(address);
				
		assertTrue("Address Saved to the database successfully",	addressId > 0);
				
		addressId = addressDao.saveAddress(address1);
		
		assertTrue("Address Saved to the database successfully",	addressId > 0);
		
		addressId = addressDao.saveAddress(address2);
		
		assertTrue("Address Saved to the database successfully",	addressId > 0);
		
		addressId = addressDao.saveAddress(address3);
		
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
		
		customer1.setAddress(address1);	
		customer1.setPersonnelStatus(pStatusAccessList);

		customer2.setAddress(address2);	
		customer2.setPersonnelStatus(pStatusAccessList);

		customer3.setAddress(address3);	
		customer3.setPersonnelStatus(pStatusAccessList);

		
		pStatus.setCustomer(custAccessList);
		
		customer.setAccount(account);
		customer1.setAccount(account1);
		customer2.setAccount(account2);
		customer3.setAccount(account3);
		
	}
		
	public void saveCustomerToDatabase() {
						
		customerId = customerDao.saveCustomer(customer);
		
		assertTrue("Customer saved to the database", customerId > 0L);
		
		customerId = customerDao.saveCustomer(customer1);
		
		assertTrue("Customer saved to the database", customerId > 0L);

		customerId = customerDao.saveCustomer(customer2);
		
		assertTrue("Customer saved to the database", customerId > 0L);
		
		customerId = customerDao.saveCustomer(customer3);
		
		assertTrue("Customer saved to the database", customerId > 0L);
	}
	
	
	
	public void saveCustomerAccount()
	{
		accountId = accountDao.saveAccount(account);
		
		assertTrue("Account saved successfully", accountId > 0);
		
		accountId = accountDao.saveAccount(account1);
		
		assertTrue("Account saved successfully", accountId > 0);
		
		accountId = accountDao.saveAccount(account2);
		
		assertTrue("Account saved successfully", accountId > 0);
		
		accountId = accountDao.saveAccount(account3);
		
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
		address1 = null;
		address2 = null;
		address3 = null;
		
		pStatus = null;
		
		customer = null;
		customer1 = null;
		customer2 = null;
		customer3 = null;
		
		pStatusAccessList = null;
		
		account = null;
		account1 = null;
		account2 = null;
		account3 = null;
	}	
}
