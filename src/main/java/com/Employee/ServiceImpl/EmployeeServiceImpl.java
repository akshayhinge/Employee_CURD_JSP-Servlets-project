package com.Employee.ServiceImpl;

import java.util.ArrayList;

import com.Employee.daoImpl.EmployeeDaoImpl;
import com.Employee.dto.Employee;
import com.Employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDaoImpl employeedao=null;
	
	public EmployeeServiceImpl() {
		employeedao=new EmployeeDaoImpl();
	}
	
	@Override
	public Integer addEmployee(Employee employee) {
		return employeedao.addEmployee(employee);
	}

	@Override
	public Integer deleteEmployee(Integer id) {
		return employeedao.deleteEmployee(id);
	}

	@Override
	public ArrayList<Employee> getEmployeeByPage(Integer page) {	
		return employeedao.getEmployeeByPage(page);
	}

	@Override
	public Integer getTotalRecords() {
		return employeedao.getTotalRecords();
	}

}
