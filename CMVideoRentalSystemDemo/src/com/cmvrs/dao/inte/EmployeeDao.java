package com.cmvrs.dao.inte;

import java.util.List;


import com.cmvrs.model.Employee;

public interface EmployeeDao 
{
	Long saveEmployee(Employee employee);
	Employee getEmployee(Long employee);
	Employee findEmployeeByIdNumber(String idNumber);
	List<Employee> getAllEmployees();
	void updateEmployee(Employee employee);
}
