
function validateForm() {
  var name = document.forms["employeeForm"]["name"].value;
  var birthdate = document.forms["employeeForm"]["birthdate"].value;
  var address = document.forms["employeeForm"]["address"].value;
  var gender = document.forms["employeeForm"]["gender"].value;
  var salary = document.forms["employeeForm"]["salary"].value;
  if (name == "" || birthdate == "" || address == ""|| gender == ""||salary == "") {
    alert("Please fill out all fields!");
    return false;
  }
  if (isNaN(salary)) {
    alert("Salary must be a number");
    return false;
  }
  if (address.length > 150) {
    alert("Address is too long");
    return false;
  }
}

