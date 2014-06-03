package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.StockPriceDao;
import com.cmvrs.model.StockPrice;
import com.cmvrs.service.service.StockPriceService;

@Service("stockPriceService")
@Transactional(propagation = Propagation.SUPPORTS)
public class StockPriceServiceImpl implements StockPriceService
{

	@Autowired
	private StockPriceDao stockPriceDao; 
	
	
	public Long saveStockPrice(StockPrice stockPrice) {
	
		return stockPriceDao.saveStockPrice(stockPrice);
	}

	
	public StockPrice findByPriceType(String priceType) {
	
		return stockPriceDao.findByPriceType(priceType);
	}

	
	public StockPrice getStockPrice(Long stockPrice) {
	
		return stockPriceDao.getStockPrice(stockPrice);
	}

	
	public List<StockPrice> getAllStockPrices() {
	
		return stockPriceDao.getAllStockPrices();
	}

	
	public void updateStockPrice(StockPrice stockPrice) {
	stockPriceDao.updateStockPrice(stockPrice);
		
	}

}
