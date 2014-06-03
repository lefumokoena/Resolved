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

import com.cmvrs.dao.inte.StockPriceDao;
import com.cmvrs.dao.inte.VideoDao;
import com.cmvrs.model.StockPrice;
import com.cmvrs.model.Video;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "hibernateTransactionManager")
@ContextConfiguration(locations = "classpath:cmvrs-servlet.xml")
public class StockVideoTestCase {

	@Autowired
	private StockPriceDao stockPriceDoa;
	
	StockPrice stockPrice1;
	StockPrice stockPrice2;
			
	Long stockPriceId1 = 0L;
	Long stockPriceId2 = 0L;
		
	@Autowired
	private VideoDao videoDao;
	Video video1;
	Video video2;
	Video video3;
	Video video4;
	Video video5;
	
	Long videoId1 = 0L;
	Long videoId2 = 0L;
	Long videoId3 = 0L;
	Long videoId4 = 0L;
	
		
	@Before
	public void setupForSavingStockPriceVideoToDatabase() throws ParseException {
	
	//StockPrice setup	
		
	stockPrice1 = new StockPrice();
	stockPrice2 = new StockPrice();
			
	stockPrice1.setPriceType("New Release");
	stockPrice1.setPrice(16);
	
	stockPrice2.setPriceType("Old Release");
	stockPrice2.setPrice(12);
			
	//End Stock Price setup
	
	//Video Setup
	
	video1 = new Video();
	video2 = new Video();
	video3 = new Video();
	video4 = new Video();
	video5 = new Video();
	
	video1.setVideoType("DVD");
	video1.setName("Hulk");
	video1.setDescription("Hulk is the green mean machine ass kicker");
	video1.setAgeRestriction("16");
	video1.setNumOfCopies(5);
	video1.setNumOfCopiesDamaged(0);
	
	Calendar c1 = Calendar.getInstance();
	
	c1.set(2014, 04,13);
	
	Date releaseDate1 = c1.getTime();
		
	video1.setReleaseDate(releaseDate1);
		
	video2.setVideoType("DVD");
	video2.setName("Million Dollar Baby ");
	video2.setDescription("Legends of boxing");
	video2.setAgeRestriction("A");
	video2.setNumOfCopies(12);
	video2.setNumOfCopiesDamaged(0);
	
	Calendar c2 = Calendar.getInstance();
	
	c2.set(2012, 04,13);
	
	Date releaseDate2 = c2.getTime();
		
	video2.setReleaseDate(releaseDate2);
		
	video3.setVideoType("Video");
	video3.setName("Hulk");
	video3.setDescription("Hulk is the green mean machine ass kicker");
	video3.setAgeRestriction("16");
	video3.setNumOfCopies(5);
	video3.setNumOfCopiesDamaged(0);
	
	Calendar c3 = Calendar.getInstance();
	
	c3.set(2014, 04,13);
	
	Date releaseDate3 = c3.getTime();
		
	video3.setReleaseDate(releaseDate3);
	
	video4.setVideoType("Video");
	video4.setName("Million Dollar Baby ");
	video4.setDescription("Legends of boxing");
	video4.setAgeRestriction("A");
	video4.setNumOfCopies(12);
	video4.setNumOfCopiesDamaged(0);
	
	Calendar c4 = Calendar.getInstance();
	
	c4.set(2012, 04,13);
	
	Date releaseDate4 = c4.getTime();
		
	video4.setReleaseDate(releaseDate4);
		
	//End Video Setup
	
	}
		
	public void savedStockPriceToDatabase() {
				
		stockPriceId1 = stockPriceDoa.saveStockPrice(stockPrice1);
		
		assertTrue("Stock price saved to the database",stockPriceId1 > 0);
		
		stockPriceId2 = stockPriceDoa.saveStockPrice(stockPrice2);
		
		assertTrue("Stock price saved to the database",stockPriceId2 > 0);
		
		
	}
	
	public void saveVideosToDatabase()
	{
		videoId1 = videoDao.saveVideo(video1);
		
		assertTrue("Video saved to the database",videoId1 > 0);
		
		videoId2 = videoDao.saveVideo(video2);
		
		assertTrue("Video saved to the database",videoId2 > 0);
	
		videoId3 = videoDao.saveVideo(video3);
		
		assertTrue("Video saved to the database",videoId3 > 0);
		
		videoId4 = videoDao.saveVideo(video4);
		
		assertTrue("Video saved to the database",videoId4 > 0);
	
	}
	
	public void setVideoToPrice()
	{
		video1.setStockPrice(stockPrice1);
		video2.setStockPrice(stockPrice2);
		video3.setStockPrice(stockPrice1);
		video4.setStockPrice(stockPrice2);
	}
	
	@Test
	public void saveVideoStock()
	{
		savedStockPriceToDatabase();
		
		setVideoToPrice();
		
		saveVideosToDatabase();
	}
	
	@After
	public void destroyObjectFromHeap() {
		
		stockPrice1 = null;
		stockPrice2 = null;
		
		video1 = null;
		video2 = null;
		video3 = null;
		video4 = null;
		
	}	
}
