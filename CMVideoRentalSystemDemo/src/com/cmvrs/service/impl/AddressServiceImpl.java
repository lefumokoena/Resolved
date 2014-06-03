package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.AddressDao;
import com.cmvrs.model.Address;
import com.cmvrs.service.service.AddressService;

@Service("addressService")
@Transactional(propagation = Propagation.SUPPORTS)
public class AddressServiceImpl implements AddressService
{
	
	@Autowired
	private AddressDao addressDao;
	
	
	public Long saveAddress(Address address) {
		
	 return addressDao.saveAddress(address);
	 	 
	}

	
	public Address getAddress(Long address) {
	
		return addressDao.getAddress(address);
	}

	
	public List<Address> findAddressByStreetName(String streetName) {
		
		return addressDao.findAddressByStreetName(streetName);
	}

	
	public List<Address> getAllAddresss() {
	
		return addressDao.getAllAddresss();
	}

	
	public void updateAddress(Address address) {
	addressDao.updateAddress(address);
		
	}
	
}
