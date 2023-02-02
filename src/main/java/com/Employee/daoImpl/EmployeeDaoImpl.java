package com.Employee.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Employee.UtilImpl.JDBCConnectionManagerImpl;
import com.Employee.dao.EmployeeDao;
import com.Employee.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	// JDBC connection
	private Connection conn;


	public EmployeeDaoImpl() {
		conn = new JDBCConnectionManagerImpl().getConnection();
		
	}

	//Inserting new employee 
	@Override
	public Integer addEmployee(Employee employee) {
		try {
			//insert query
			String sql = "INSERT INTO employee (name, address, gender, salary, birthdate) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setByte(3, employee.getGender());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, (Date) employee.getBirthdate());
			
			// execute statement
			Integer result = ps.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//delete employee with there id
	@Override
	public Integer deleteEmployee(Integer id) {
		try {
			// delete query
			String sql="DELETE FROM Employee WHERE employeeId = ?";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setInt(1, id);
		   
		   //execute query and send it back result
		   int result = ps.executeUpdate();	

		   return result;

		
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	//getting employee records by page(5 records per page)
	@Override
	public ArrayList<Employee> getEmployeeByPage(Integer page) {
		Integer recordsPerPage=5;
	
		try {
			//  query
		String sql = "SELECT * FROM Employee LIMIT " + (page-1)*recordsPerPage + "," + recordsPerPage;
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//execute query
		ResultSet rs =ps.executeQuery();
		
		// list of employees
		ArrayList<Employee> employees=new ArrayList<Employee>();
		
		//adding into ArrayList
		while(rs.next()) {
			Employee employee=new Employee();
			employee.setId(rs.getInt("employeeid"));
			employee.setName(rs.getString("name"));
			employee.setAddress(rs.getString("address"));
			employee.setGender(rs.getByte("gender"));
			employee.setSalary(rs.getDouble("salary"));
			employee.setBirthdate(rs.getDate("birthdate"));
			employees.add(employee);
		}	
		return employees;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	//getting total records
	@Override
	public Integer getTotalRecords() {
		try {

			// couting total records are in db
			String query= "SELECT COUNT(*) FROM Employee";
			PreparedStatement ps = conn.prepareStatement(query);
		
//			execute query

			ResultSet resultSet = ps.executeQuery(query);
			
		
			while(resultSet.next()) {
				return (int)resultSet.getFloat(1);
				
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return 0;
	}
	

}
