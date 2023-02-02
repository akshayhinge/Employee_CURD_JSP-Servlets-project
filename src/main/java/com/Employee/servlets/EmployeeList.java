package com.Employee.servlets;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee.ServiceImpl.EmployeeServiceImpl;
import com.Employee.dto.Employee;


public class EmployeeList extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get current page number
		Integer page = Integer.valueOf(request.getParameter("page"));
		
		//send and revert back from service layer
		EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
		ArrayList<Employee> employeeList = employeeService.getEmployeeByPage(page);
		
		//checking result is empty or not
		if(employeeList!=null || employeeList.size()!=0) {

			//getting total records 
			Integer totalRecords = employeeService.getTotalRecords();
			Integer recordsPerPage = 5;
			Integer totalPages =  (int)(totalRecords / recordsPerPage);
			

			if(totalRecords % recordsPerPage !=0) {
				totalPages++;
			}
			
			request.setAttribute("totalPages",totalPages);
			request.setAttribute("employeeList", employeeList);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
					dispatcher.forward(request, response);
		} else {
			String msg = "Some thing went wrong!! Please try again";
			request.setAttribute("msg", msg);
			response.sendRedirect("employeeForm.jsp");

		}
	}
	
}
