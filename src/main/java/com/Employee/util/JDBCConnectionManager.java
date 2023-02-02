package com.Employee.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public interface JDBCConnectionManager {

	public Connection getConnection();
}
