package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection conn;

	// barbar call kora lagbey..tai static korey dicchi,jatey barbar class er
	// instance create na kora lagey
	public static Connection getConn() {

		
		
		try {
				//for driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//for connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu_system", "root", "11913087Mn@");

			

		} catch (Exception e) {
			e.printStackTrace();
		}
  
		return conn;

	}

}
