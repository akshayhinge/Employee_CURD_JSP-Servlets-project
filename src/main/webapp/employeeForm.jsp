<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="BootstrapFiles.jsp"%>
<!DOCTYPE html>

<head>
<script src="./JS/employee.js"></script>
<meta charset="UTF-8">
<title>Insert Employee</title>
<style type="text/css">
.input-group-wrapper {
	margin-bottom: 0.5rem;
}
</style>
</head>

<body>
	<%@ include file="Navbar.jsp"%>
	<div class="card mt-3 col-lg-6 col-sm-12 m-auto border">
		<h2 class="card-header pt-4 mb-0 text-center">Add Employee</h2>
		<div class="msg p-2">
			<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
			%>
			<h5 class="text-success text-center">
				<%=msg%>
			</h5>
			<%
			}
			%>
		</div>

		<form name="employeeForm" action="AddEmployee" method="post"
			class="mb-0" onsubmit="return validateForm()">
			<div class="row card-body pt-0">
				<div class="input-group-wrapper">
					<label class="form-label" for="name">Name:</label> <input
						type="text" name="name" maxlength="100" class="form-control"
						required>
				</div>
				<div class="input-group-wrapper">

					<label class="form-label" for="birthdate">Birth Date:</label> <input
						type="date" name="birthdate" class="form-control" required />
				</div>
				<div class="input-group-wrapper ">
					<label class="form-label" for="address"> Address:</label>
					<textarea name="address" maxlength="150" class="form-control"
						required></textarea>
				</div>
				<div class="input-group-wrapper ">
					<label class="form-label" for="gender"> Gender:</label> <input
						type="radio" name="gender" value="1" class="form-check-input"
						required> Male <input type="radio" name="gender" value="2"
						class="form-check-input" required> Female
				</div>
				<div class="input-group-wrapper mb-0">
					<label class="form-label" for="salary"> Salary:</label> <input
						type="text" name="salary" maxlength="5" class="form-control"
						required>

				</div>
			</div>

			<button type="submit" class="btn btn-primary w-100">Submit</button>

		</form>
	</div>
</body>

</html>