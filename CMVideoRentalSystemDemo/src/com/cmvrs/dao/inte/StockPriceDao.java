package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.StockPrice;

public interface StockPriceDao {
	
	Long saveStockPrice(StockPrice stockPrice);
	StockPrice findByPriceType(String priceType);
	StockPrice getStockPrice(Long stockPrice);
	List<StockPrice> getAllStockPrices();
	void updateStockPrice(StockPrice stockPrice);
}
