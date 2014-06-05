package com.cmvrs.Testing;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;

import com.cmvrs.dao.inte.AdminDao;
import com.cmvrs.dao.inte.CustomerDao;
import com.cmvrs.dao.inte.PersonnelStatusDao;
import com.cmvrs.dao.inte.StockPriceDao;
import com.cmvrs.dao.inte.VideoDao;
import com.cmvrs.dao.inte.VideoRentalDao;
import com.cmvrs.model.Admin;
import com.cmvrs.model.Customer;
import com.cmvrs.model.PersonnelStatus;
import com.cmvrs.model.StockPrice;
import com.cmvrs.model.Video;
import com.cmvrs.model.VideoRental;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "hibernateTransactionManager")
@ContextConfiguration(locations = "classpath:cmvrs-servlet.xml")
public class RentVideoTestCase {

	@Autowired
	private SessionFactory sessionFactory ;
	
	@Autowired
	private AdminDao adminDao;
	Admin admin;
	Long adminId = 5L;
	List<Admin> adminList = new ArrayList<Admin>();
	
	@Autowired
	private CustomerDao custDao;
	Customer cust;
	Long custId = 1L;
	List<Customer> custList = new ArrayList<Customer>();
	
	@Autowired
	private VideoDao videoDao;
	Video video;
	Long videoId = 2L;
	List<Video> videoList = new ArrayList<Video>();
	
	@Autowired
	private PersonnelStatusDao pStatusDao;
	PersonnelStatus pStatus;
	Long pStatusId = 1L;
	List<PersonnelStatus> pStatusList = new ArrayList<PersonnelStatus>();
	
	@Autowired
	private VideoRentalDao vRentalDao;
	VideoRental vRental;
	Long vRentalId = 2L;
	List<VideoRental> vRentalList = new ArrayList<VideoRental>();
	
	enum userStatus{Active, Deactivated}
	
	/*
	 * 
	  	Before executing this test case, execute 
		SaveAdminTestCase,
		SaveCustomerTestCase,
		StockMachineTestCase,
		StockVideoTestCase
	*/
		
	@Before
	public void setupForRentingVideoLoadInfo()  {
	
		
		
		admin = adminDao.getAdmin(adminId);
		adminList = adminDao.getAllAdmins();
				
		cust = custDao.getCustomer(custId);
		custList = custDao.getAllCustomers();
		
		video = videoDao.getVideo(videoId);
		videoList = videoDao.getAllVideos(); 
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2014, 04,13);
		
		Date hireDate = c2.getTime();
		Date returnDate = c1.getTime();

		

		vRental = new VideoRental();
		
		vRental.setVideo(video);
		vRental.setCustomer(cust);
		vRental.setCopyOfMovie(1);
		vRental.setRentalDate(hireDate);
		vRental.setReturnDate(returnDate);
		vRental.setMovieRentalStatus("Returned");
		
	
		
	}
	
	
	
	public void authenticateUser()
	{
		for(Admin adminR: adminList)
		{
			assertEquals(admin.getUsername(), adminR.getUsername());
			
			assertTrue(adminR.getUserStatus().equals(admin.getUserStatus()));
					
		}
				
	}
	@Ignore
	@Test
	public void verifyAdminRole()
	{
		
		assertNotNull(pStatusList);
		
		for(PersonnelStatus ps : pStatusList)
		{
			System.out.println(ps.getAccessId()+" User Role: "+ps.getAccessType());
			
			//assertEquals(admin., ps.getAccessType());
		}
	}
	
	
	public void loadAndVerifyUserAndAccountHealth()
	{
		
		int approval = 0;
		int accountHealth = 0;
		
		approval = vRentalDao.verifyCustomerActivity(custId);
		
		assertEquals("Customer is an active member",1, approval);
		
		accountHealth = vRentalDao.verifyCustomerAmountOwing(approval, custId);
		
		assertEquals("Customer does not have outstanding fees",1, accountHealth);
		
	}
		
	
	public void checkOutstandingRentals()
	{
		int movieStatus = 0;
				
		vRentalList = vRentalDao.getAllVideoRentals();
		
		assertNotNull(vRentalList);
		
		movieStatus = vRentalDao.checkOutstandingMovies(custId, vRentalList);
		
		assertEquals("Customer returned all his movies",1, movieStatus);		
			
		
	}
	
	@Test
	public void saveRental()
	{
		authenticateUser();
		
		loadAndVerifyUserAndAccountHealth();
		
		checkOutstandingRentals();
		
		vRentalId = vRentalDao.saveVideoRental(vRental);
		
	}
	
	@After
	public void destroyObjectFromHeap() {
		
		
	}	
}
