package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.VideoDao;
import com.cmvrs.model.Video;

@Repository("videoDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class VideoDaoImpl implements VideoDao
{

	@Autowired
	private SessionFactory sessionFactory ;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveVideo(Video video) {
		sessionFactory.openSession();
		
		sessionFactory.getCurrentSession().save(video);
		
		return video.getMovieId();
	}

	@Transactional(readOnly= true)
	public Video getVideo(Long video) {
		
		return (Video)sessionFactory.getCurrentSession().get(Video.class, video);
	}

	
	@SuppressWarnings("unchecked")
	public List<Video> findVideoByName(String name) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Video.class);
		
		criteria.add(Restrictions.eq("name", name));
		
		return (List<Video>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	
	public List<Video> getAllVideos() {
		return (List<Video>)sessionFactory.getCurrentSession().createCriteria(Video.class).list();
	}

	@Transactional(readOnly= false)
	public void updateVideo(Video video) {
		sessionFactory.getCurrentSession().update(video);
		
	}

}
