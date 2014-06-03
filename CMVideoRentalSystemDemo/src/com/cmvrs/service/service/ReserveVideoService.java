package com.cmvrs.service.service;

import java.util.Date;
import java.util.List;

import com.cmvrs.model.ReserveVideo;

public interface ReserveVideoService {

	Long saveReserveVideo(ReserveVideo reserveVideo);
	ReserveVideo getReserveVideo(Long reserveVideo);
	List<ReserveVideo> findReserveVideoByDate(Date date);
	List<ReserveVideo> getAllReserveVideos();
	void updateReserveVideo(ReserveVideo reserveVideo);
	
}
