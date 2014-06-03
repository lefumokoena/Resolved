package com.cmvrs.dao.inte;

import java.util.Date;
import java.util.List;

import com.cmvrs.model.ReserveVideo;

public interface ReserveVideoDao {

	Long saveReserveVideo(ReserveVideo reserveVideo);
	ReserveVideo getReserveVideo(Long reserveVideo);
	List<ReserveVideo> findReserveVideoByDate(Date date);
	List<ReserveVideo> getAllReserveVideos();
	void updateReserveVideo(ReserveVideo reserveVideo);
	
}
