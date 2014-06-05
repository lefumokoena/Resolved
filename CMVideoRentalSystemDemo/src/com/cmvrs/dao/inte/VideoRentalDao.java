package com.cmvrs.dao.inte;

import java.util.Date;
import java.util.List;

import com.cmvrs.model.PersonnelStatus;
import com.cmvrs.model.VideoRental;

public interface VideoRentalDao {

	Long saveVideoRental(VideoRental videoRental);
	VideoRental getVideoRental(Long videoRental);
	List<VideoRental> findVideoRentalByDate(Date date);
	List<VideoRental> getAllVideoRentals();
	void updateVideoRental(VideoRental videoRental);
	
	//Special Methods
	int verifyCustomerActivity(Long custId);
	int verifyCustomerAmountOwing(int approval,Long custId);
	int checkOutstandingMovies(Long custId,List<VideoRental> vRList);
}
