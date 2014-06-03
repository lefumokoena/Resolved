package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.CustomerDao;
import com.cmvrs.model.Customer;
import com.cmvrs.service.service.CustomerService;

@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerDao customerDao;
	
	
	public Long saveCustomer(Customer customer) {
	
		return customerDao.saveCustomer(customer);
	}

	
	public Customer getCustomer(Long customer) {
	
		return customerDao.getCustomer(customer);
	}

	
	public Customer findCustomerByIdNumber(String idNumber) {
	
		return customerDao.findCustomerByIdNumber(idNumber);
	}

	
	public List<Customer> getAllCustomers() {
	
		return customerDao.getAllCustomers();
	}

	
	public void updateCustomer(Customer customer) {
	customerDao.updateCustomer(customer);
		
	}

}
