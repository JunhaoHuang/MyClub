package com.MyClub.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	private String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/MyClubs";
	private String user = "root";
	private String password = "123";
	private Connection conn;
	
	
	public Connection getConnection() {
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
