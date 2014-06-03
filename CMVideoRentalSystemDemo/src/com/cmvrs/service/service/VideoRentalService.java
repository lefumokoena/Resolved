package com.cmvrs.service.service;

import java.util.Date;
import java.util.List;

import com.cmvrs.model.VideoRental;

public interface VideoRentalService {

	Long saveVideoRental(VideoRental videoRental);
	VideoRental getVideoRental(Long videoRental);
	List<VideoRental> findVideoRentalByDate(Date date);
	List<VideoRental> getAllVideoRentals();
	void updateVideoRental(VideoRental videoRental);
	
}
