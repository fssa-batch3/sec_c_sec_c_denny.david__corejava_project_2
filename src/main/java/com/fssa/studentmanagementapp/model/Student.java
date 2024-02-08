package com.fssa.studentmanagementapp.model;

import java.time.LocalDate;

import com.fssa.studentmanagementapp.Enum.Gender;

/**
 * Represents a student with various attributes such as ID, name, email, etc.
 */
public class Student {

	private int id;
	private String name;
	private String fatherName;
	private String motherName;
	private String emailId;
	private String mobileNo;
	private String password;
	private Gender gender;
	private String address;
	private String bloodGroup;
    private int class_id;
	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	private LocalDate dob;
	private LocalDate createdDate;

	/**
	 * Constructs a new Student object with the given parameters.
	 *
	 * @param id          The unique ID of the student.
	 * @param name        The name of the student.
	 * @param emailId     The email ID of the student.
	 * @param mobileNo    The mobile number of the student.
	 * @param password    The password of the student.
	 * @param dob         The date of birth of the student.
	 * @param createdDate The date when the student record was created.
	 * @param gender      The gender of the student.
	 */
	public Student(int id, String name, String emailId, String mobileNo, String password, LocalDate dob,
			LocalDate createdDate, Gender gender) {

		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;

		this.dob = dob;
		this.createdDate = createdDate;
		this.gender = gender;
	}
 
	// ... (getter and setter methods for other attributes)

	/**
	 * Gets the gender of the student.
	 *
	 * @return The gender of the student.
	 */
	public Gender getGender() {
		return gender;
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

	/**
	 * Sets the gender of the student.
	 *
	 * @param gender The gender of the student.
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Default constructor for the Student class.
	 */
	public Student() {
		// Default constructor
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", password=" + password + ", gender=" + gender
				+ ", address=" + address + ", bloodGroup=" + bloodGroup + ", class_id=" + class_id + ", dob=" + dob
				+ ", createdDate=" + createdDate + "]";
	}

	
	// ... (getter and setter methods for other attributes)
	
	

}
