package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Employee;

public interface EmployeeService {

	Long saveEmployee(Employee employee);
	Employee getEmployee(Long employee);
	Employee findEmployeeByIdNumber(String idNumber);
	List<Employee> getAllEmployees();
	void updateEmployee(Employee employee);
	
}
