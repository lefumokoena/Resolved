package com.cmvrs.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.CustomerDao;
import com.cmvrs.dao.inte.VideoRentalDao;
import com.cmvrs.model.Customer;
import com.cmvrs.model.VideoRental;

@Repository("videoRentalDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class VideoRentalDaoImpl implements VideoRentalDao
{
	
		
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerDao custDao;
	Customer customer ;
	List<Customer> custList = null;
	
	VideoRental vRental;
	List<VideoRental> vRentalList;
		
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveVideoRental(VideoRental videoRental) {
		sessionFactory.openSession();
		sessionFactory.getCurrentSession().save(videoRental);
		return videoRental.getRentalId();
	}

	@Transactional(readOnly= true)
	public VideoRental getVideoRental(Long videoRental) {
		
		return (VideoRental)sessionFactory.getCurrentSession().get(VideoRental.class,videoRental );
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<VideoRental> findVideoRentalByDate(Date date) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(VideoRental.class);

		criteria.add(Restrictions.like("rentalDate", date));
		
		return (List<VideoRental>)criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<VideoRental> getAllVideoRentals() {
		return (List<VideoRental>)sessionFactory.getCurrentSession().createCriteria(VideoRental.class).list();
	}

	@Transactional(readOnly= false)
	public void updateVideoRental(VideoRental videoRental) {
		sessionFactory.getCurrentSession().update(videoRental);
		
	}


	public int verifyCustomerActivity(Long custId) {
		
		int approval = 0;
		
		customer = custDao.getCustomer(custId);
		
		if(customer != null)
		{			
				if(customer.getUserStatus().equals("Active"))
				{
					approval = 1;
				}
				else
				{
					approval = -1;
				}				
			}
		
		return approval;
	}

	
	public int verifyCustomerAmountOwing(int approval,Long custId) {
		
		int accountHealth = 0;
		
		if(approval == 1)
		{
			customer = custDao.getCustomer(custId);
		
			if(customer.getAccount().getOwing()>= 0.00)
			{
				accountHealth = 1;
			}
			else
			{
				accountHealth = -1;
			}
		}
		
		return accountHealth;
	}
	
	public int checkOutstandingMovies(Long custId,List<VideoRental> vRList) {
		
		int movieStatus  = 0;
				
		for(VideoRental vr : vRList)
		{
			if((vr.getCustomer().getPersonKey() == custId) & (vr.getMovieRentlStatus().equals("Returned")))
			{
				movieStatus = 1;
			}
			else
			{
				movieStatus = -1;
			}
			
		}
				
		return movieStatus;
	
	}
	
	

}
