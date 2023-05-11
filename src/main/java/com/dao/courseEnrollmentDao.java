package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.course_enrollment;


public class courseEnrollmentDao {

	private Connection conn;

	public courseEnrollmentDao (Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addCourseEnrollment(course_enrollment ap) {
		boolean f = false;

		try {

			String sql = "insert into course_enrollment(student_id,fullName,gender,age,class_start_date,email,phNo,subject_id,teacher_id,expectation,status) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, ap.getStudentId());
			ps.setString(2, ap.getFullName());
			ps.setString(3, ap.getGender());
			ps.setString(4, ap.getAge());
			ps.setString(5, ap.getClass_start_date());
			ps.setString(6, ap.getEmail());
			ps.setString(7, ap.getPhNo());
			ps.setInt(8, ap.getSubjectId());
			ps.setInt(9, ap.getTeacherId());
			ps.setString(10, ap.getExpectation());
			ps.setString(11, ap.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}