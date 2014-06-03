package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Customer;

public interface CustomerService {

	Long saveCustomer(Customer customer);
	Customer getCustomer(Long customer);
	Customer findCustomerByIdNumber(String idNumber);
	List<Customer> getAllCustomers();
	void updateCustomer(Customer customer);
}
