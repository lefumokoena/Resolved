package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.AddressDao;
import com.cmvrs.model.Address;

@Repository("addressDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class AddressDaoImpl implements AddressDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveAddress(Address address) {
	
		sessionFactory.openSession();
		sessionFactory.getCurrentSession().save(address);
		return address.getAddressId();
	}

	@Transactional(readOnly= true)
	@SuppressWarnings("unchecked")
	public List<Address> getAllAddresss() {
	
		return (List<Address>)sessionFactory.getCurrentSession().createCriteria(Address.class).list();
	}
	
	@Transactional(readOnly= true)
	@SuppressWarnings("unchecked")
	public List<Address> findAddressByStreetName(String streetName) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Address.class);

		criteria.add(Restrictions.like("streetName", streetName));
		
		return (List<Address>)criteria.list();
	}

	@Transactional(readOnly= true)
	public Address getAddress(Long address) {
		return (Address)sessionFactory.getCurrentSession().get(Address.class, address);	}

	@Transactional(readOnly= false)
	public void updateAddress(Address address) {
	
		sessionFactory.getCurrentSession().update(address);
	}

}
