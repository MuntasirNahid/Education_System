package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
	


