package com.rentalSystem.ui;

import java.sql.SQLException;

import com.rentalSystem.biz.ConnectDB;

public class TestDBConnection {
	public void connectDB() {
		ConnectDB connect = new ConnectDB();
		try {
			connect.connectDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC driver class is not found, please check the jar.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database connection failed.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestDBConnection connecting = new TestDBConnection();
		connecting.connectDB();
	}

}
