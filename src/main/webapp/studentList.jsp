<%@page import="com.fssa.studentmanagementapp.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing students</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/StudentList.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/AddStudent.css">

</head>
<body>
	<%
	String view = request.getParameter("view");
	boolean isClass = "class".equals(view);
	%>

	<nav class="sidebar">
		<h2 id="project_name">Student Management App</h2>


		<ul>
			<li><a id="active" href="<%=request.getContextPath()%>/home.jsp">Home</a></li>
			<li><a id="active" href="<%=request.getContextPath()%>/StudentList">Student List</a></li>
			<li><a id="active" href="<%=request.getContextPath()%>/Class.jsp">Class</a></li>
		</ul>
	</nav>
	<main>
		<form action="<%=request.getContextPath()%>/FindByNameServlet" method="get">
			<input type=text placeholder="  Search student by name: "
				name="search"></input>
			<button type="submit">Search</button>
			<%-- <button id="assign_student">Add Student</button>--%>
			<p id="openModalButton">Add Student</p>
		</form>

		<%

			if(isClass){

				int[] arr = {1,2,3,4,5,6,7,8,8,10};

				List<Integer> intList = new ArrayList<Integer>(arr.length);
				for (int i : arr)
				{
					intList.add(i);
				}


		%>




		<select name="ClassId" id="updateClassId" required>
			<%

				for(int item : intList){

				String classId = request.getParameter("classId");

				if(item != Integer.parseInt(classId.trim())){
			%>

			<option value="<%=item%>">Class - <%=item%></option>

			<%
					}
				}

			%>

		</select>

		<%
			}
		%>

		<button type="button" id="moveBtn">Move</button>
	</main>


	<%
	if (!isClass) {
	%>

	<div class="assignStudentDiv" id="assignStudent">
		<form action="<%=request.getContextPath()%>/AssignStudent" method="post">

			<h3>Assign student to a class</h3>
			<div class="assignDetails">
				<p>Student name</p>
				<input id="selectedStudentEmail" name="selectedStudent" type="text"
					readonly>
			</div>
			<div>
			
			</div>
			<div class="assignDetails">
				<p>Enter class number</p>
				
			<select  name="ClassId" required>
			  <option value="1">Class - 1</option>
              <option value="2">Class - 2</option>
              <option value="3">Class - 3</option>
              <option value="4">Class - 4</option>
              <option value="5">Class - 5</option>
              <option value="6">Class - 6</option>
              <option value="7">Class - 7</option>
              <option value="8">Class - 8</option>
              <option value="9">Class - 9</option>
              <option value="10">Class - 10</option>
			</select>	
			</div>
			<button type="submit">Assign</button>
		</form>
	</div>
	<%
	} else {
	%>

	<div class="assignStudentDiv" id="assignStudent">
		<form action="./UpdateStudentClass" method="post">

			<h3>Update student to a class</h3>
			<div class="assignDetails">
				<p>Student name</p>
				<input id="selectedStudentEmail" name="selectedStudent" type="text"
					readonly>
			</div>
			<div class="assignDetails">
				<p>Enter class number</p>
				<input id="selectedStudentClassNum" name="selectedClass"
					type="number">
			</div>
			<button type="submit">Update</button>
		</form>
	</div>
	<%
	}
	%>


	<div class="table">
		<table>
			<thead>
				<tr>

					<%

						if(isClass){


					%>

					<th>Move</th>

					<%
						}
					%>
					<th>Id</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Date of Birth</th>
					<th>Phone no</th>
					<th>Father Name</th>
					<th>Mother Name</th>
					<th>Address</th>
					<th>Blood Group</th>
					<th>Class</th>
					<%
					if (!isClass) {
					%>
					<th>Assign to class</th>
					<%
					}
					%>
					<%
					if (isClass) {
					%>
					<th>Update class</th>
					<th>Edit</th>
					<%
					}
					%>


				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Student> stuList = (ArrayList<Student>) request.getAttribute("STUDENT_LIST");
			
				int id = 1;
				%>
				<%
				if (stuList != null) {
					for (Student details : stuList) {
				%>
				<tr>
					<%
						if(isClass){


					%>

					<td><input type="checkbox" value="<%=details.getId()%>" class="moveBtns"></td>

					<%
						}
					%>

					<td><%=id%></td>
					<td><%=details.getName()%></td>
					<td><%=details.getGender().toString()%></td>
					<td class="studentEmail"><%=details.getEmailId()%></td>
					<td><%=details.getDob()%></td>
					<td><%=details.getMobileNo()%></td>
					<td><%=details.getFatherName()%></td>
					<td><%=details.getMotherName()%></td>
					<td><%=details.getAddress()%></td>
					<td><%=details.getBloodGroup()%></td>
					
					<td><%=details.getClass_id() == -1 ? "--" : details.getClass_id()%></td>
					<%
					if (!isClass) {
					%>
					<td>
					<%if(details.getClass_id()==-1){%>
					<button class="assignButton" type="button" onclick="showStudent()">Assign</button>
					<%
					}
					else{
					%>
					<button class="assignButton not_view" type="button" onclick="showStudent()">Assign</button>
					
					<%
					}
					
					%>
					
					</td>
					<%
					}
					%>
					<%
					if (isClass) {
					%>
					<td><button class="editButton">Edit</button></td>
					<%
					}
					%>
				</tr>
				<%
				id++;
				}
				}

				else {
				%>
				<p>No record found</p>
				<%
				}
				%>


			</tbody>
		</table>
	</div>
	<div id="addstupopup">
		<div id="userModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<form class="form" action="<%=request.getContextPath()%>/AddStudentServlet" method="post">
					<h1 id="add_student">Add Student</h1>
					<label for="fathername">Father Name:</label>
					<input type="text" id="fathername" name="fathername" required>
					<label for="mothername">Mother Name:</label>
					<input type="text" id="mothername" name="mothername" required>
					<label for="name">Enter your name:</label> <input type="text"
						id="name" name="name"> <label for="dob">Date of
						Birth (dd/mm/yyyy):</label> <input type="date" id="dob" name="dob">

					<label for="gender">Gender:</label> <select id="gender"
						name="gender">
						<option value="MALE">MALE</option>
						<option value="FEMALE">FEMALE</option>
					</select> <label for="email">Email Id:</label> <input type="email"
						id="email" name="email"> <label for="password">Password:</label>
					<input type="password" id="password" name="password"> <label
						for="mobileNo">Mobile No:</label> <input type="text" id="mobileNo"
						name="mobileNo">
						<label for="address">Address:</label>
						<input type="text" id="address" required name="address">
						<label for="bloodgroup">Blood Group:</label>
						<input type="text" id="bloodgroup" required name="bloodgroup">

					<div class="button-container">
						<input type="submit" value="Submit">
					</div>
				</form>
			</div>
      </div>
     </div>
     
     <div id="editstupopup">
		<div id="userModal" class="modal">
			<div class="edit-content">
				<span class="close">&times;</span>
				<form class="form" action="<%=request.getContextPath()%>/AddStudentServlet" method="post">
					<h1 id="add_student">Add Student</h1>
					<label for="fathername">Father Name:</label>
					<input type="text" id="fathername" name="fathername" required>
					<label for="mothername">Mother Name:</label>
					<input type="text" id="mothername" name="mothername" required>
					<label for="name">Enter your name</label> <input type="text"
						id="name" name="name"> <label for="dob">Date of
						Birth (dd/mm/yyyy):</label> <input type="date" id="dob" name="dob">

					<label for="gender">Gender:</label> <select id="gender"
						name="gender">
						<option value="MALE">MALE</option>
						<option value="FEMALE">FEMALE</option>
					</select> <label for="email">Email Id:</label> <input type="email"
						id="email" name="email"> <label for="password">Password:</label>
					<input type="password" id="password" name="password"> <label
						for="mobileNo">Mobile No:</label> <input type="text" id="mobileNo"
						name="mobileNo">
						<label for="address">Address:</label>
						<input type="text" id="address" required name="address">
						<label for="bloodgroup">Blood Group:</label>
						<input type="text" id="bloodgroup" required name="bloodgroup">

					<div class="button-container">
						<input type="submit" value="Submit">
					</div>
				</form>
			</div>
      </div>
     </div>

</body>
<script src="<%=request.getContextPath()%>/assets/js/AddStudent.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/StudentList.js"></script>
</html>