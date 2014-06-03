package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.VideoDao;
import com.cmvrs.model.Video;
import com.cmvrs.service.service.VideoService;

@Service("videoService")
@Transactional(propagation = Propagation.SUPPORTS)
public class VideoServiceImpl implements VideoService
{

	@Autowired
	private VideoDao videoDao;
	
	@Override
	public Long saveVideo(Video video) {
	
		return videoDao.saveVideo(video);
	}

	
	public Video getVideo(Long video) {
	
		return videoDao.getVideo(video);
	}

	
	public List<Video> findVideoByName(String name) {
	
		return videoDao.findVideoByName(name);
	}

	
	public List<Video> getAllVideos() {
	
		return videoDao.getAllVideos();
	}

	
	public void updateVideo(Video video) {
	videoDao.updateVideo(video);		
	}

}
