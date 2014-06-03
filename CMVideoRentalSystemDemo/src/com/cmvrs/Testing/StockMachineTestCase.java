package com.cmvrs.Testing;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.cmvrs.dao.inte.MachineDao;
import com.cmvrs.dao.inte.StockPriceDao;
import com.cmvrs.model.Machine;
import com.cmvrs.model.StockPrice;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "hibernateTransactionManager")
@ContextConfiguration(locations = "classpath:cmvrs-servlet.xml")
public class StockMachineTestCase {

	@Autowired
	private StockPriceDao stockPriceDoa;
	
	StockPrice stockPrice1;
	StockPrice stockPrice2;
		
	Long stockPriceId1 = 0L;
	Long stockPriceId2 = 0L;
		
	@Autowired
	private MachineDao machineDao;
	Machine machine1;
	Machine machine2;
	
	Long machineId1 = 0L;
	Long machineId2 = 0L;
	
	
	@Before
	public void setupForSavingStockPriceAndMachineToDatabase() {
	
	//StockPrice setup	
		
	stockPrice1 = new StockPrice();
	stockPrice2 = new StockPrice();
		
	stockPrice1.setPriceType("Video Machine");
	stockPrice1.setPrice(30);
	
	stockPrice2.setPriceType("DVD Machine");
	stockPrice2.setPrice(30);
	
	//End Stock Price setup
	
	//Machine Setup
	
	machine1 = new Machine();
	
	machine1.setMachineType("Video Machine");
	machine1.setName("LG");
	machine1.setDescription("Plays video cassettes");
	machine1.setNumOfCopies(6);
	machine1.setNumOfCopiesDamaged(0);
	machine1.setModelNumber("LQ-X9G-01");
	
	
	machine2 = new Machine();
	
	machine2.setMachineType("DVD Machine");
	machine2.setName("Sony");
	machine2.setDescription("Plays dvd's ");
	machine2.setNumOfCopies(6);
	machine2.setNumOfCopiesDamaged(0);
	machine2.setModelNumber("KQ-W9P-11");
	
	//End Video Setup
	
	}
		
	public void savedStockPriceToDatabase() {
				
		stockPriceId1 = stockPriceDoa.saveStockPrice(stockPrice1);
		
		assertTrue("Stock price saved to the database",stockPriceId1 > 0);
		
		stockPriceId2 = stockPriceDoa.saveStockPrice(stockPrice2);
		
		assertTrue("Stock price saved to the database",stockPriceId2 > 0);
		
		}
	
	public void saveMachineToDatabase()
	{
		machineId1 = machineDao.saveMachine(machine1);
		
		assertTrue("Machine saved to the database",machineId1 > 0);
		
		machineId2 = machineDao.saveMachine(machine2);
		
		assertTrue("Machine saved to the database",machineId2 > 0);	
	}
	
	public void setMachineToPrice()
	{
		machine1.setStockPrice(stockPrice1);
		machine2.setStockPrice(stockPrice2);
		
	}
	
	@Test
	public void saveVideoStock()
	{
		savedStockPriceToDatabase();
		
		setMachineToPrice();
		
		saveMachineToDatabase();
	}
	
	@After
	public void destroyObjectFromHeap() {
		
		stockPrice1 = null;
		stockPrice2 = null;
		
		machine1 = null;
		machine2 = null;
		
	}	
}
