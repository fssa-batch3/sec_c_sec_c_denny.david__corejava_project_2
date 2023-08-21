package com.fssa.StudentManagementApp.model;

import java.time.LocalDate;

import com.fssa.StudentManagementApp.Enum.Gender;

public class Student {
	
	private int id;
	private String name;
	private String emailId;
	private String mobileNo;
	private String password;
	private Gender gender;
	
    private LocalDate dob; 
    private LocalDate createdDate;
    
    public Student(int id, String name, String emailId, String mobileNo, String password, LocalDate dob,
			LocalDate createdDate, String gender) {
		
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
		
		this.dob = dob;
		this.createdDate = createdDate; 
	}
    public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Student() {
//    	default constructor
    }
    
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
  }
