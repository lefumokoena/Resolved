package com.cmvrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmvrs.dao.inte.EmployeeDao;
import com.cmvrs.model.Employee;
import com.cmvrs.service.service.EmployeeService;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS)
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Long saveEmployee(Employee employee) {
		
		return employeeDao.saveEmployee(employee);
	}


	public Employee getEmployee(Long employee) {

		return employeeDao.getEmployee(employee);
	}

	
	public Employee findEmployeeByIdNumber(String idNumber) {
	
		return employeeDao.findEmployeeByIdNumber(idNumber);
	}

	
	public List<Employee> getAllEmployees() {
	
		return employeeDao.getAllEmployees();
	}

	
	public void updateEmployee(Employee employee) {
	employeeDao.updateEmployee(employee);		
	}

}
