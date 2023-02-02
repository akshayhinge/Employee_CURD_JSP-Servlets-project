<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Employee.UtilImpl.JDBCConnectionManagerImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="com.Employee.dto.Employee"%>
<%@ include file="BootstrapFiles.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<%@ include file="Navbar.jsp"%>
	<div class="card m-2 border">
		<div class="card-title p-3 m-0 d-flex">
			<h3 class="">Employee List</h3>
			<span class="text-center text-danger flex-fill"> <%
 String msg = (String) request.getAttribute("msg");
 if (msg != null) {
 %> <%=msg%> <%
 }
 %>
			</span>
		</div>

		<table class="table align-middle mb-0 bg-white card-body">
			<thead class="bg-light">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>Gender</th>
					<th>Salary</th>
					<th>Birthdate</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Employee> employees = (ArrayList<Employee>) request.getAttribute("employeeList");

				Integer currentpage = Integer.valueOf(request.getParameter("page"));

				Integer totalPages = (Integer) request.getAttribute("totalPages");

				for (Employee employee : employees) {
				%>
				<tr>
					<td>
						<p class="fw-normal mb-1"><%=employee.getId()%></p>
					</td>
					<td>
						<p class="fw-normal mb-1"><%=employee.getName()%></p>
					</td>
					<td>
						<p class="fw-normal mb-1"><%=employee.getAddress()%></p>
					</td>

					<td>
						<%
						if (employee.getGender() > 1) {
						%>
						<p class="fw-normal mb-1">Female</p> <%
 } else {
 %>
						<p class="fw-normal mb-1">Male</p> <%
 }
 %>
					</td>
					<td>
						<p class="fw-normal mb-1"><%=employee.getSalary()%></p>
					</td>
					<td>
						<p class="fw-normal mb-1"><%=employee.getBirthdate()%></p>
					</td>

					<td class=""><a
						href="DeleteEmployee?page=<%=currentpage%>&id=<%=employee.getId()%>"
						onclick="return confirm('Are you sure want to delete employee?');"
						class="text-danger far fa-trash-alt"></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<nav aria-label="Page navigation ">
			<ul class="pagination justify-content-center m-2">


				<li class="page-item ">
					<%
					if (currentpage > 1) {
					%> <a class="page-link"
					href="EmployeeList?action=get&page=<%=currentpage - 1%>">Previous</a>
					<%
					}
					%>
				</li>
				<%
				if (currentpage < totalPages) {
					int Pages = (currentpage + 5 < totalPages) ? currentpage + 5 : totalPages;
					for (int i = currentpage; i < Pages; i++) {
				%>
				<li class="page-item "><a class="page-link"
					href="EmployeeList?action=get&page=<%=i%>"><%=i%></a></li>
				<%
				}
				}
				%>
				<li class="page-item ">
					<%
					if (currentpage < totalPages) {
					%> <a class="page-link"
					href="EmployeeList?action=get&page=<%=currentpage + 1%>">Next</a> <%
 }
 %>
				</li>
			</ul>
		</nav>
	</div>

</body>
</html>
