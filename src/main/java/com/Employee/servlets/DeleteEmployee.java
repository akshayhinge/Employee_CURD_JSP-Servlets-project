package com.Employee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee.ServiceImpl.EmployeeServiceImpl;

public class DeleteEmployee extends HttpServlet{


	private static final long serialVersionUID = -3099320637340699584L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//employee id and current page number
		Integer id=Integer.valueOf(request.getParameter("id"));
		Integer page=Integer.valueOf(request.getParameter("page"));
		
		//send and revert back data
		EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
		Integer result = employeeService.deleteEmployee(id);

		//checking result
		if(result>0) {
			if (result > 0) {
				//success msg
				String msg = "Employee Deleted Successfully ";
				request.setAttribute("msg", msg);
				
				//redirect to employeelist page 
				RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList?page="+page);
				dispatcher.forward(request, response);
			} else {
				//failed msg
				String msg = "Some thing went wrong!! Please try again";
				request.setAttribute("msg", msg);
				response.sendRedirect("EmployeeList?page="+page);

			}
		}else {
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
