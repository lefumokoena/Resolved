package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.StockPriceDao;
import com.cmvrs.model.StockPrice;

@Repository("stockPriceDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class StockPriceDaoImpl implements StockPriceDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveStockPrice(StockPrice stockPrice) {
		
		sessionFactory.openSession();
		sessionFactory.getCurrentSession().saveOrUpdate(stockPrice);
		
		return stockPrice.getPriceID();
	}

	@Transactional
	public StockPrice findByPriceType(String priceType) {
			
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StockPrice.class);
		
		criteria.add(Restrictions.eq("priceType", priceType));
				
		return (StockPrice) criteria.uniqueResult();
	}

	@Transactional(readOnly= true)
	public StockPrice getStockPrice(Long stockPrice) {
		
		return (StockPrice)sessionFactory.getCurrentSession().get(StockPrice.class,stockPrice );
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<StockPrice> getAllStockPrices() {
		return (List<StockPrice>)sessionFactory.getCurrentSession().createCriteria(StockPrice.class).list();
	}

	@Transactional(readOnly= false)
	public void updateStockPrice(StockPrice stockPrice) {
		sessionFactory.getCurrentSession().update(stockPrice);		
	}
}
