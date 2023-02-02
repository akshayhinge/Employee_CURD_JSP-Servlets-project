package com.Employee.dao;

import java.util.ArrayList;

import com.Employee.dto.Employee;

public interface EmployeeDao {

	public Integer addEmployee(Employee employee);
	
	public Integer deleteEmployee(Integer id);
	
	public ArrayList<Employee> getEmployeeByPage(Integer page);

	public Integer getTotalRecords();
}
