package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.Customer;

public interface CustomerDao {
	
	Long saveCustomer(Customer customer);
	Customer getCustomer(Long customer);
	Customer findCustomerByIdNumber(String idNumber);
	List<Customer> getAllCustomers();
	void updateCustomer(Customer customer);
}
