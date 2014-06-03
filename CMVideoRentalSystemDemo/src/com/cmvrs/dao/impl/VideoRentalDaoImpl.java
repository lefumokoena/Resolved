package com.cmvrs.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.VideoRentalDao;
import com.cmvrs.model.VideoRental;

@Repository("videoRentalDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class VideoRentalDaoImpl implements VideoRentalDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveVideoRental(VideoRental videoRental) {
		sessionFactory.openSession();
		sessionFactory.getCurrentSession().save(videoRental);
		return videoRental.getRentalId();
	}

	@Override
	public VideoRental getVideoRental(Long videoRental) {
		
		return (VideoRental)sessionFactory.getCurrentSession().get(VideoRental.class,videoRental );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoRental> findVideoRentalByDate(Date date) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(VideoRental.class);

		criteria.add(Restrictions.like("rentalDate", date));
		
		return (List<VideoRental>)criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoRental> getAllVideoRentals() {
		return (List<VideoRental>)sessionFactory.getCurrentSession().createCriteria(VideoRental.class).list();
	}

	@Override
	public void updateVideoRental(VideoRental videoRental) {
		// TODO Auto-generated method stub
		
	}

}
