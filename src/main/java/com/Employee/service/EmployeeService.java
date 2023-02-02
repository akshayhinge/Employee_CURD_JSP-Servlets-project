package com.Employee.service;

import java.util.ArrayList;

import com.Employee.dto.Employee;

public interface EmployeeService {

	public Integer addEmployee(Employee employee);
	
	public Integer deleteEmployee(Integer id);
	
	public ArrayList<Employee> getEmployeeByPage(Integer page);
	
	public Integer getTotalRecords();
	
}
