package com.Employee.UtilImpl;

import java.sql.Connection;
import java.sql.DriverManager;

import com.Employee.util.JDBCConnectionManager;

public class JDBCConnectionManagerImpl implements JDBCConnectionManager{

	private Connection connection=null;
	
	private final String className="com.mysql.cj.jdbc.Driver";
	
	private final String dbURL="jdbc:mysql://localhost:3306/employee_curd_db";
	
	private final String userName="root";
	
	private final String password="hinge";

	@Override
	public Connection getConnection() {
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(dbURL,userName,password);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return connection;
	}
}
