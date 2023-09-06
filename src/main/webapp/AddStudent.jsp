<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<form method="post" action="AddStudent">
		<p>Id :</p>
		<input type="number" name="id">
		<p>Enter your name :</p>
		<input type="text" name="name">
		<p>Date of Birth :</p>
		<input type="date" name="dob">
		<p>Created Date :</p>
		<input type="date" name="createdDate">
		<p>Gender :</p>
		<input type="text" name="gender">
		<p>Email Id :</p>
		<input type="email" name="email">
		<p>Password :</p>
		<input type="number" name="password">
		<p>Mobile No :</p>
		<input type="number" name="phone no">
		<button type="submit">Submit</button>
	</form>
</body>
</html>