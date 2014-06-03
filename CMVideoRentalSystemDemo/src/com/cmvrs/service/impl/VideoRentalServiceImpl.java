package com.cmvrs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.VideoRentalDao;
import com.cmvrs.model.VideoRental;
import com.cmvrs.service.service.VideoRentalService;

@Service("videoRentalService")
@Transactional(propagation = Propagation.SUPPORTS)
public class VideoRentalServiceImpl implements VideoRentalService
{
	@Autowired
	private VideoRentalDao videoRentalDao;
	
	
	public Long saveVideoRental(VideoRental videoRental) {
	
		return videoRentalDao.saveVideoRental(videoRental);
	}

	
	public VideoRental getVideoRental(Long videoRental) {
	
		return videoRentalDao.getVideoRental(videoRental);
	}

	
	public List<VideoRental> findVideoRentalByDate(Date date) {
	
		return videoRentalDao.findVideoRentalByDate(date);
	}

	
	public List<VideoRental> getAllVideoRentals() {
	
		return videoRentalDao.getAllVideoRentals();
	}

	
	public void updateVideoRental(VideoRental videoRental) {
	
		videoRentalDao.updateVideoRental(videoRental);		
	}

}
