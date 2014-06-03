package com.cmvrs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.EmployeeDao;
import com.cmvrs.model.Employee;
import com.cmvrs.model.Person;

@Repository("employeeDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class EmployeeDaoImpl implements EmployeeDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly= false,propagation = Propagation.REQUIRED)
	public Long saveEmployee(Employee employee) {

		sessionFactory.openSession();
		
		sessionFactory.getCurrentSession().save(employee);
		
		return employee.getPersonKey();
	}

	@Transactional(readOnly= true)
	public Employee getEmployee(Long employee) {

		return (Employee)sessionFactory.getCurrentSession().get(Person.class, employee);
	}

	@Transactional(readOnly= true)
	public Employee findEmployeeByIdNumber(String idNumber) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		
		criteria.add(Restrictions.eq("idNumber", idNumber));
		
		return (Employee)criteria.uniqueResult();
	}

	@Transactional(readOnly= true)
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		
		return (List<Employee>)sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	@Transactional(readOnly= false)
	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		
	}
	

	
}
