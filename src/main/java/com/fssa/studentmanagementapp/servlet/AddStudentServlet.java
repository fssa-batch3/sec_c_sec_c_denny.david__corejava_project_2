package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.model.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		Gender gender = Gender.valueToEnumMapping(request.getParameter("gender"));

		String mobileNo = request.getParameter("mobileNo");
		String dateOfBirth = request.getParameter("dob");
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		String fatherName = request.getParameter("fathername");
		String motherName = request.getParameter("mothername");
		String address = request.getParameter("address");
		String bloodGroup = request.getParameter("bloodgroup");

		LocalDate dob = LocalDate.parse(dateOfBirth);

		try {
			Student student = new Student();
			student.setDob(dob);
			student.setEmailId(emailId);
			student.setGender(gender);
			student.setMobileNo(mobileNo);
			student.setName(name);
			student.setPassword(password);
			student.setFatherName(fatherName);
			student.setMotherName(motherName);
			student.setAddress(address);
			student.setBloodGroup(bloodGroup);
			

			boolean isAdded = StudentService.addStudent(student);
			if (isAdded) {
				System.out.println("Successfully added");

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		response.sendRedirect("./StudentList");
	}

}
