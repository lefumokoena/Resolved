package com.cmvrs.Testing;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
	private AdminDao adminDao;
	Admin admin;
	Long adminId = 0L;
	
	@Autowired
	private CustomerDao custDao;
	Customer cust;
	Long custId = 0L;
	
	@Autowired
	private VideoDao videoDao;
	Video video;
	Long videoId = 0L;
	
	@Autowired
	private PersonnelStatusDao pStatusDao;
	PersonnelStatus pStatus;
	Long pStatusId = 0L;
	
	@Autowired
	private VideoRentalDao vRentalDao;
	VideoRental vRental;
	Long vRentalId = 0L;
	
	/*
	 * 
	  	Before executing this test case, execute 
		SaveAdminTestCase,
		SaveCustomerTestCase,
		StockMachineTestCase,
		StockVideoTestCase
	*/
	
	@Before
	public void setupForRentingVideoLoadInfo() throws ParseException {
	
		
	}
		
		
	@After
	public void destroyObjectFromHeap() {
		
		
	}	
}
