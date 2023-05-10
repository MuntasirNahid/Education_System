package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Student;

public class studentDao {
	private Connection conn;

	public studentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean studentRegister(Student u) {
			boolean f = false;
			try {
				
				String sql = "insert into student_details(full_name,email,password) values(?,?,?)";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, u.getFullName());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getPassword());
				
				int i = ps.executeUpdate();
				
				if(i==1) {
					f = true;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return f;
	}
	
	public Student login(String em, String psw) {
	
		Student u = null;

		try {
			
			String sql = "select * from student_details where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new Student();
				u.setId(rs.getInt(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}
	
	

}
	


