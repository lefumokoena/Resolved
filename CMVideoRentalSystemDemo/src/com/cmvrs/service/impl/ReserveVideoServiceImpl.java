package com.cmvrs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.ReserveVideoDao;
import com.cmvrs.model.ReserveVideo;
import com.cmvrs.service.service.ReserveVideoService;

@Service("reserveVideoService")
@Transactional(propagation = Propagation.SUPPORTS)
public class ReserveVideoServiceImpl implements ReserveVideoService
{

	@Autowired
	private ReserveVideoDao reserveVideoDao; 
	
	
	public Long saveReserveVideo(ReserveVideo reserveVideo) {
	
		return reserveVideoDao.saveReserveVideo(reserveVideo);
	}

	
	public ReserveVideo getReserveVideo(Long reserveVideo) {
	
		return reserveVideoDao.getReserveVideo(reserveVideo);
	}

	
	public List<ReserveVideo> findReserveVideoByDate(Date date) {
	
		return reserveVideoDao.findReserveVideoByDate(date);
	}

	
	public List<ReserveVideo> getAllReserveVideos() {
	
		return reserveVideoDao.getAllReserveVideos();
	}

	
	public void updateReserveVideo(ReserveVideo reserveVideo) {
	reserveVideoDao.updateReserveVideo(reserveVideo);
		
	}

}
