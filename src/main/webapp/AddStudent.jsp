<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet" href="./assets/css/AddStudent.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
	<nav class="sidebar">
		<ul>
			<li><a href="#" class="active">Home</a></li>
			<li><a href="AddStudent.html">Student</a></li>
			<li><a href="#">Student List</a></li>
			<li><a href="#">Class</a></li>
		</ul>
	</nav>
	<button id="openModalButton">Add Student</button>
	<div id="addstupopup">
		<div id="userModal" class="modal">




			<div class="modal-content">


				<span class="close">&times;</span>
				<form action="./AddStudentServlet" method="post">
					<h1 id="add_student">Add Student</h1>
					
					<label for="fathername">Father Name</label>
					<input type="text" id="fathername" required>
					<label for="mothername">Mother Name</label>
					<input type="text" id="mothername" required>
					<label for="name">Enter your name:</label> <input type="text"
						id="name" name="name"> <label for="dob">Date of
						Birth (dd/mm/yyyy):</label> <input type="date" id="dob" name="dob" required>

					<label for="gender">Gender:</label> <select id="gender"
						name="gender" required>
						<option value="M">MALE</option>
						<option value="F">FEMALE</option>
					</select> <label for="ema il">Email Id:</label> <input type="email"
						id="email" name="email"> <label for="password" required>Password:</label>
					<input type="password" id="password" name="password"> 
					<label
						for="mobileNo">Mobile No:</label> <input type="text" id="mobileNo"
						name="mobileNo" required>
						<label for="address">Address</label>
						<input type="text" id="address">
						<label for="bloodgroup">Blood Group</label>
						<input type="text" id="bloodgroup" required>
					

					<div class="button-container">
						<input type="submit" value="Submit">
					</div>
				</form>
			</div>


		</div>

	</div>

	<script src="./assets/js/AddStudent.js"></script>
</body>
</html>
