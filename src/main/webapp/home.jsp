<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Management App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/home.css">
<script src="<%=request.getContextPath()%>/assets/js/home.js"></script>

</head>
<body>
	<nav class="sidebar">
		<h3 id="project_name">Student Management App</h3>
		<ul>
			<li><a id="active" href="<%=request.getContextPath()%>/home.jsp">Home</a></li>
			<li><a id="active" href="<%=request.getContextPath()%>/StudentList">Student List</a></li>
			<li><a id="active" href="<%=request.getContextPath()%>/Class.jsp">Class</a></li>
		</ul>
	</nav>
	<p class="p-3 mb-2 bg-body-tertiaries"></p>
	<div class="content">
		<p class="p-3 mb-2 bg-body-tertiary"></p>
		<p id="highlights">
			Enhance school efficiency, simplify <br>administrative tasks,
			and for better <br>educational outcomes.
		</p>
		<img id="main_logo" src="https://educloud.app/lms/src/erp/smp_i3.png">
	</div>
	
</body>


</html>

 
