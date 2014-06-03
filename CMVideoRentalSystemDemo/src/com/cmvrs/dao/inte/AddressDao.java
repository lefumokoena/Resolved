package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.Address;

public interface AddressDao {

	Long saveAddress(Address address);
	Address getAddress(Long address);
	List<Address> findAddressByStreetName(String streetName);
	List<Address> getAllAddresss();
	void updateAddress(Address address);
	
}
