package com.rentalSystem.biz;

import java.sql.SQLException;

import com.rentalSystem.dao.BaseDao;

public class ConnectDB {
	public void connectDB() throws ClassNotFoundException, SQLException{
		BaseDao abaodao = new BaseDao();
		try {
			abaodao.openConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
