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

import com.cmvrs.dao.inte.ReserveVideoDao;
import com.cmvrs.model.ReserveVideo;

@Repository("reserveVideoDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class ReserveVideoDaoImpl implements ReserveVideoDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveReserveVideo(ReserveVideo reserveVideo) {
		sessionFactory.openSession();
		sessionFactory.getCurrentSession().save(reserveVideo);
		return reserveVideo.getReserveId();
	}

	@Transactional(readOnly= true)
	public ReserveVideo getReserveVideo(Long reserveVideo) {
		
		return (ReserveVideo)sessionFactory.getCurrentSession().get(ReserveVideo.class, reserveVideo);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<ReserveVideo> findReserveVideoByDate(Date date) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ReserveVideo.class);

		criteria.add(Restrictions.like("bookingDate", date));
		
		return (List<ReserveVideo>)criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	public List<ReserveVideo> getAllReserveVideos() {
		return (List<ReserveVideo>)sessionFactory.getCurrentSession().createCriteria(ReserveVideo.class).list();
	}

	@Transactional(readOnly= false)
	public void updateReserveVideo(ReserveVideo reserveVideo) {
		sessionFactory.getCurrentSession().update(reserveVideo);
		
	}

}
