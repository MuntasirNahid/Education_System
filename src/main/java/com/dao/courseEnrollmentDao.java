package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.course_enrollment;

public class courseEnrollmentDao {

	private Connection conn;

	public courseEnrollmentDao(Connection conn) {
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

	public List<course_enrollment> getAllCoursesByLoginStudent(int studentId) {
		List<course_enrollment> list = new ArrayList<course_enrollment>();
		course_enrollment ap = null;

		try {

			String sql = "select * from course_enrollment where student_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, studentId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new course_enrollment();
				ap.setId(rs.getInt(1));
				ap.setStudentId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setClass_start_date(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setSubjectId(rs.getInt(9));
				ap.setTeacherId(rs.getInt(10));
				ap.setExpectation(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<course_enrollment> getAllCourseByTeacherLogin(int teacherId) {
		List<course_enrollment> list = new ArrayList<course_enrollment>();

		course_enrollment ap = null;

		try {

			String sql = "select * from course_enrollment where teacher_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, teacherId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ap = new course_enrollment();
				ap.setId(rs.getInt(1));
				ap.setStudentId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setClass_start_date(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setSubjectId(rs.getInt(9));
				ap.setTeacherId(rs.getInt(10));
				ap.setExpectation(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public course_enrollment getCourseEnrollmentById(int id) {

		course_enrollment ap = null;

		try {

			String sql = "select * from course_enrollment where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new course_enrollment();
				ap.setId(rs.getInt(1));
				ap.setStudentId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setClass_start_date(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setSubjectId(rs.getInt(9));
				ap.setTeacherId(rs.getInt(10));
				ap.setExpectation(rs.getString(11));
				ap.setStatus(rs.getString(12));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}

	public boolean updateCommentStatus(int id, int teacherId, String comm) {

		boolean f = false;
		try {
			String sql = "update course_enrollment set status=? where id=? and teacher_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, teacherId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<course_enrollment> getAllCourseEnrollment() {

		List<course_enrollment> list = new ArrayList<course_enrollment>();

		course_enrollment ap = null;

		try {

			String sql = "select * from course_enrollment order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ap = new course_enrollment();
				ap.setId(rs.getInt(1));
				ap.setStudentId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setClass_start_date(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setSubjectId(rs.getInt(9));
				ap.setTeacherId(rs.getInt(10));
				ap.setExpectation(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}