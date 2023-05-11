package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.teacher;

public class teacherDao {
	private Connection conn;

	public teacherDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerTeacher(teacher d) {
		boolean f = false;

		try {
			String sql = "insert into teacher(fullName,dob,qualification,course_teaches,email,mobNo,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getCourse_teaches());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<teacher> getAllTeacher() {
		List<teacher> list = new ArrayList<teacher>();
		teacher d = null;
		try {

			String sql = "select  * from teacher order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new teacher();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setCourse_teaches(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public teacher getTeacherById(int id) {

		teacher d = null;
		try {

			String sql = "select *  from teacher where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new teacher();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setCourse_teaches(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public boolean updateTeacher(teacher d) {
		boolean f = false;

		try {
			String sql = "update teacher set fullName=?,dob=?,qualification=?,course_teaches=?,email=?,mobNo=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getCourse_teaches());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteTeacher(int id) {
		boolean f = false;
		try {
			String sql = "delete from teacher where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public teacher login(String email, String psw) {
	
		teacher d = null;
		try {

			String sql = "select * from teacher where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new teacher();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setCourse_teaches(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

//	   
//	   public int countAppointment() { int i = 0; try { String sql =
//	   "select   from appointment"; PreparedStatement ps =
//	   conn.prepareStatement(sql); ResultSet rs = ps.executeQuery(); while
//	   (rs.next()) { i++; }
//	   
//	   } catch (Exception e) { e.printStackTrace(); }
//	   
//	   return i; }
//	   
//	   public int countAppointmentByDocotrId(int did) { int i = 0; try { String sql
//	   = "select   from appointment where doctor_id=?"; PreparedStatement ps =
//	   conn.prepareStatement(sql); ps.setInt(1, did); ResultSet rs =
//	   ps.executeQuery(); while (rs.next()) { i++; }
//	   
//	   } catch (Exception e) { e.printStackTrace(); }
//	   
//	   return i; }
//	   
//	   public int countUSer() { int i = 0; try { String sql =
//	   "select   from user_dtls"; PreparedStatement ps = conn.prepareStatement(sql);
//	   ResultSet rs = ps.executeQuery(); while (rs.next()) { i++; }
//	   
//	   } catch (Exception e) { e.printStackTrace(); }
//	   
//	   return i; }
//	   
//	   public int countSpecialist() { int i = 0; try { String sql =
//	   "select   from specialist"; PreparedStatement ps =
//	   conn.prepareStatement(sql); ResultSet rs = ps.executeQuery(); while
//	   (rs.next()) { i++; }
//	   
//	   } catch (Exception e) { e.printStackTrace(); }
//	   
//	   return i; }
//	   
//	   public boolean checkOldPassword(int userid, String oldPassword) { boolean f =
//	   false;
//	   
//	   try { String sql = "select   from doctor where id=? and password=?";
//	   PreparedStatement ps = conn.prepareStatement(sql); ps.setInt(1, userid);
//	   ps.setString(2, oldPassword);
//	   
//	   ResultSet rs = ps.executeQuery(); while (rs.next()) { f = true; }
//	   
//	   } catch (Exception e) { e.printStackTrace(); }
//	   
//	   return f; }
//	   
//	   public boolean changePassword(int userid, String newPassword) { boolean f =
//	   false;
//	   
//	   try { String sql = "update doctor set password=? where id=?";
//	   PreparedStatement ps = conn.prepareStatement(sql); ps.setString(1,
//	   newPassword); ps.setInt(2, userid);
//	   
//	   int i = ps.executeUpdate(); if (i == 1) { f = true; }
//	   
//	   } catch (Exception e) { e.printStackTrace(); }
//	   
//	   return f; }
//	   
//	   public boolean editDoctorProfile(Doctor d) { boolean f = false;
//	   
//	   try { String sql =
//	   "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?"
//	   ; PreparedStatement ps = conn.prepareStatement(sql); ps.setString(1,
//	   d.getFullName()); ps.setString(2, d.getDob()); ps.setString(3,
//	   d.getQualification()); ps.setString(4, d.getSpecialist()); ps.setString(5,
//	   d.getEmail()); ps.setString(6, d.getMobNo()); ps.setInt(7, d.getId()); int i
//	   = ps.executeUpdate();
//	   
//	   if (i == 1) { f = true; } } catch (Exception e) { e.printStackTrace(); }
//	   
//	   return f; }

}