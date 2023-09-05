package com.fssa.studentmanagementapp.model;

import com.fssa.studentmanagementapp.Enum.Stu_Status;

public class StudentClass {
//    id int primary key auto_increment,
//    student_id int not null,
//    class int not null,
//    status varchar(20) not null,
	private int id;
	private int studentId;
	private int Standard;
	private Stu_Status status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public int getStandard() {
		return Standard;
	}
	public void setStandard(int standard) {
		Standard = standard;
	}
	public Stu_Status getStatus() {
		return status;
	}
	public void setStatus(Stu_Status status) {
		this.status = status;
	}
	
	
	
	
}
