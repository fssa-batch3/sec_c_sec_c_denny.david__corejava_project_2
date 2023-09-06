<%@page import="com.fssa.studentmanagementapp.model.Student"%>
<html>
<body>
<h2>Search student by name</h2>

     <form action = "FindStudentByName">
     <input type=text placeholder="Enter name : " name = "name"></input>
     <button>submit</button>
     </form>
	<a href="Sample">Click Here</a>

	<% 
	Student stu = (Student) request.getAttribute("STUDENT_DETAIL");
	if(stu != null){
	%>
	<p>Name : <%=stu.getName() %></p>
	<p>Email : <%=stu.getEmailId() %></p>
	<p>Moblie Number : <%=stu.getMobileNo() %></p>
	<p>Gender : <%=stu.getGender() %></p>
	<p>DOB : <%=stu.getDob() %></p>
	<p>Created Date : <%=stu.getCreatedDate() %></p>
	<%
	}else{
	%>
	<p>No record found</p>
	<%} %>
	
</body>
</html>
