package com.entity;

public class teacher {

	private int id;
	private String fullName;
	private String dob;
	private String qualification;
	private String course_teaches;
	private String email;
	private String mobNo;
	private String password;

	public teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public teacher(String fullName, String dob, String qualification, String course_teaches, String email, String mobNo,
			String password) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.course_teaches = course_teaches;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}

	public teacher(int id, String fullName, String dob, String qualification, String course_teaches, String email,
			String mobNo, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.course_teaches = course_teaches;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse_teaches() {
		return course_teaches;
	}

	public void setCourse_teaches(String course_teaches) {
		this.course_teaches = course_teaches;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}