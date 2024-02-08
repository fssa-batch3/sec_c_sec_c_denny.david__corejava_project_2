<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href = "./assets/css/Class.css">
<title>Class List</title>
</head>
<body>
    <nav class="sidebar">
        <h2 id="project_name" >Student Management App</h2>
       
       
        <ul>
       	<li><a id="active" href="home.jsp">Home</a></li>
			<li><a id="active" href="./StudentList">Student List</a></li>
			<li><a id="active" href="Class.jsp">Class</a></li>
        </ul>
    </nav>
    <div class="classes">
     <a style="background-color: rgb(143, 141, 141);" class="big-button" href= "./StudentsByClass?classId=1&view=class"><p>Class 1</p></a>
     <a style="background-color: rgb(158, 223, 241);" class="big-button" href= "./StudentsByClass?classId=2&view=class"><p>Class 2</p></a>
     <a style="background-color: rgb(235, 239, 159);" class="big-button" href="./StudentsByClass?classId=3&view=class"><p>Class 3</p></a>
     <a style="background-color: rgb(241, 172, 172);" class="big-button" href= "./StudentsByClass?classId=4&view=class"><p>Class 4</p></a>
     <a style="background-color: rgb(168, 241, 160);" class="big-button" href= "./StudentsByClass?classId=5&view=class"><p>Class 5</p></a>
     <a style="background-color: rgb(240, 164, 198);" class="big-button" href= "./StudentsByClass?classId=6&view=class"><p>Class 6</p></a>
     <a style="background-color: darkgrey;" class="big-button" href= "./StudentsByClass?classId=7&view=class"><p>Class 7</p></a>
     <a style="background-color: rgb(234, 212, 146);" class="big-button" href= "./StudentsByClass?classId=8&view=class"><p>Class 8</p></a>
     <a style="background-color: rgb(197, 165, 242);" class="big-button" href= "./StudentsByClass?classId=9&view=class"><p>Class 9</p></a>
     <a style="background-color: rgb(171, 246, 242);" class="big-button" href= "./StudentsByClass?classId=10&view=class"><p>Class 10</p></a>
    </div>

</body>
</html>
</body>
</html>