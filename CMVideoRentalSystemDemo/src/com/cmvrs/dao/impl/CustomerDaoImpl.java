package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.CustomerDao;
import com.cmvrs.model.Customer;

@Repository("customerDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerDaoImpl implements CustomerDao
{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveCustomer(Customer customer) {
	
		sessionFactory.openSession();
		
		sessionFactory.getCurrentSession().save(customer);

		return customer.getPersonKey();

	}
	
	@Transactional(readOnly= true)
	public Customer getCustomer(Long customer) {
	
		return (Customer)sessionFactory.getCurrentSession().get(Customer.class, customer);
	}

	@Transactional(readOnly= true)
	public Customer findCustomerByIdNumber(String idNumber) {
	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
		
		criteria.add(Restrictions.eq("idNumber", idNumber));
		
		return (Customer)criteria.uniqueResult();
	}

	@Transactional(readOnly= true)
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
	
		return (List<Customer>)sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Transactional(readOnly= false)
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
		
	}

}


