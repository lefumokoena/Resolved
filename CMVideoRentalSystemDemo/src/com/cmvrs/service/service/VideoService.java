package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Video;

public interface VideoService {

	Long saveVideo(Video video);
	Video getVideo(Long video);
	List<Video> findVideoByName(String name);
	List<Video> getAllVideos();
	void updateVideo(Video video);
	
}
