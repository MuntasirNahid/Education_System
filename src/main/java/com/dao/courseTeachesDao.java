package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import com.entity.courseTeaches;

public class courseTeachesDao {

	private Connection conn;

	public courseTeachesDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addCourseTeaches(String course) {
		boolean f = false;
		try {
			String sql = "insert into courses(course_name) values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public List<courseTeaches> getAllCourses() {
	
		List<courseTeaches> list = new ArrayList<courseTeaches>();

		courseTeaches s = null;

		try {
			String sql = "select * from courses";
		
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new courseTeaches();
				s.setId(rs.getInt(1));
				s.setCourseTeachesName(rs.getString(2));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
}
