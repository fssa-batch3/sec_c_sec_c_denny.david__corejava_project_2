package com.fssa.studentmanagementapp.model;

import java.time.LocalDate;

import com.fssa.studentmanagementapp.Enum.Gender;

public class User {
	
	private String Name;
	private String email;
	private String password;
	private String mobileNo;
    private LocalDate Dob;
	private Gender gender;
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public LocalDate getDob() {
		return Dob;
	}

	public void setDob(LocalDate dob) {
		Dob = dob;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public User(int user_id, String firstname, String lastname, String email, String password) {
		super();
		
		this.Name = Name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		
	}



	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
