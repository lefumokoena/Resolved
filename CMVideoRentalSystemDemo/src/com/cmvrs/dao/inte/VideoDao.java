package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.Video;

public interface VideoDao {
	
	Long saveVideo(Video video);
	Video getVideo(Long video);
	List<Video> findVideoByName(String name);
	List<Video> getAllVideos();
	void updateVideo(Video video);

}
