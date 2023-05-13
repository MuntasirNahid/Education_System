package com.entity;

public class courseTeaches {

	private int id;
	private String courseTeachesName;
	
	
	
	public courseTeaches() {
		super();
		// TODO Auto-generated constructor stub
	}

	public courseTeaches(int id, String courseTeacherName) {
		super();
		this.id = id;
		this.courseTeachesName = courseTeacherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTeachesName() {
		return courseTeachesName;
	}

	public void setCourseTeachesName(String courseTeacherName) {
		this.courseTeachesName = courseTeacherName;
	}
	
	
	
}
