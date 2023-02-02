package com.Employee.dto;

import java.util.Date;

public class Employee {

	private Integer id;
	
	private String name;
	
	private Date birthdate;

	private String address;
	
	private Byte gender;
	
	private Double Salary;

	public Employee() {}
	
	public Employee(String name, Date birthdate, String address, Byte gender, Double salary) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.address = address;
		this.gender = gender;
		Salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public String getAddress() {
		return address;
	}

	public Byte getGender() {
		return gender;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}
	
	
	
}
