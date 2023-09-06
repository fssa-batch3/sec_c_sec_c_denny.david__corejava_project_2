<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management App</title>
    <link rel="stylesheet" href="./assets/css/home.css">
</head>
<body>
    <nav class="sidebar">
        <ul>
            <li><a href="#" class="active">Home</a></li>
            <li><a href="#">Student</a></li>
            <li><a href="#">Student List</a></li>
            <li><a href="#">Class</a></li>
        </ul>
    </nav>
    <div class="content">
        <header>
            <h1>Student Management App</h1>
        </header>
        <main>
            <div class="container">
                <section id="student-form">
                    <h2>Add Student</h2>
                    <form>
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" required>

                        <label for="student-id">Student ID:</label>
                        <input type="text" id="student-id" name="student-id" required>

                        <label for="course">Course:</label>
                        <input type="text" id="course" name="course" required>

                        <button type="submit">Add Student</button>
                    </form>
                </section>
                <section id="student-list">
                    <h2>Student List</h2>
                    <ul id="students">
                        <!-- Student list items will be added dynamically using JavaScript -->
                    </ul>
                </section>
            </div>
        </main>
   
    </div>
    <script src="script.js"></script>
</body>
</html>

