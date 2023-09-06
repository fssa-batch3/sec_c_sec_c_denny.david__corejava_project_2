/**
 * 
 */
// Get a reference to the "Students" link
//const studentsLink = document.querySelector('nav .navbar a[href="#Students"]');

// Get a reference to the "Students" section
const studentsSection = document.getElementById('students');

// Add a click event listener to the "Students" link
students.addEventListener('click', (e) => {
    // Prevent the default behavior of the link (preventing it from navigating to a new page)
    e.preventDefault();
     window.location.href = 'student.jsp';
    // Scroll to the "Students" section smoothly
   
});
