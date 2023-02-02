package com.Employee.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee.ServiceImpl.EmployeeServiceImpl;
import com.Employee.dto.Employee;



public class AddEmployee extends HttpServlet {


	private static final long serialVersionUID = 3938683139379261720L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get form data
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		Byte gender = Byte.valueOf(request.getParameter("gender"));
		Double salary = Double.valueOf(request.getParameter("salary"));
		Date birthdate =Date.valueOf(request.getParameter("birthdate"));

		//send and revert back from service layer
		Employee employee=new Employee(name, birthdate, address, gender, salary);
		Integer result =new EmployeeServiceImpl().addEmployee(employee);
		
		//checking result
		if (result > 0) {
			String msg = "Employee Added Successfully ";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeForm.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Some thing went wrong!! Please try again";
			request.setAttribute("msg", msg);
			response.sendRedirect("employeeForm.jsp");

		}

	}

}
