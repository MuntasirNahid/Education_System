package com.entity;

public class course_enrollment {
	
	private int id;
	private int studentId;
	private String fullName;
	private String gender;
	private String age;
	private String class_start_date;
	private String email;
	private String phNo;
	private int subjectId;
	private int teacherId;
	private String expectation;
	private String status;
	
	public course_enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public course_enrollment(int studentId, String fullName, String gender, String age, String class_start_date,
			String email, String phNo, int subjectId, int teacherId, String expectation, String status) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
		this.class_start_date = class_start_date;
		this.email = email;
		this.phNo = phNo;
		this.subjectId = subjectId;
		this.teacherId = teacherId;
		this.expectation = expectation;
		this.status = status;
	}

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getClass_start_date() {
		return class_start_date;
	}

	public void setClass_start_date(String class_start_date) {
		this.class_start_date = class_start_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getExpectation() {
		return expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	

}
