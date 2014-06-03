package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Address;

public interface AddressService {

	Long saveAddress(Address address);
	Address getAddress(Long address);
	List<Address> findAddressByStreetName(String streetName);
	List<Address> getAllAddresss();
	void updateAddress(Address address);
}
