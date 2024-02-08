<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./assets/css/register.css">
</head>
<body>
<div class="container">
		
		<header>
			<p>Registration Form
		</header>
		<form action="RegistrationServlet" method="post" class="form">
			<div class="input-box">
				<label for="firstName">First Name</label> <input type="text"
					placeholder="First name" name="firstName" required />
			</div>
			<div class="input-box">
				<label for="email">Email Address</label> <input type="text"
					placeholder="Enter email address" name="email" required />
			</div>
			<div class="column">
				<div class="input-box">
					<label for="mobileNumber">Phone Number</label> <input 
						placeholder="Enter phone number" name="mobileNumber" required />
				</div>
				<span class="circle one"></span> <span class="circle two"></span>
				<div class="input-box">
					<label for="dob">Date of Birth</label> <input type="date"
						placeholder="Enter birth date" name="dob" required />
				</div>
			</div>
			<div class="gender-box">
				<h3>Gender</h3>
				<div class="gender-option">
					<div class="gender">
						<input type="radio" id="check-male" name="gender" value="male"
							checked /> <label for="check-male">male</label>
					</div>
					<div class="gender">
						<input type="radio" id="check-female" name="gender" value="Female" />
						<label for="check-female">female</label>
					</div>     
				</div>
			</div>
			<div class="input-box">
				<label for="password1">Password</label> <input type="password"
					placeholder="Enter your password" name="password" required />
			</div>
			<br>
			
			<%
        String successmessage=(String)request.getAttribute("Successmessage");
        String errormessage=(String)request.getAttribute("ErrorMessage");
        
        %>
        
        <%
        
        if(successmessage!=null){
        
        %>
            
        <p><%=successmessage %></p>
           <%
        
        }%>
         <%
        
        
           if(errormessage!=null){
        
        %>
            
        <p><%=errormessage %></p>
           <%
           
        }
         
        %>
        <div class="input-box">
          <span class="Signup-btn">Already have an account?</span>
          <a href="./login.jsp">Login</a>
        </div>
			<a href="Login.jsp"><button type="submit">Submit</button></a>
		</form>
	</div>
</body>
</html>