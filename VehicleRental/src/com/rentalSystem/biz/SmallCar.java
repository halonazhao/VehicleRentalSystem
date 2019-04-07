package com.rentalSystem.biz;

import java.sql.SQLException;

import com.rentalSystem.dao.CompanyDao;

public class SmallCar extends TVehicle{
	public SmallCar(String model, String plateNo, String status, int seatNo) {
		super(model, plateNo, status, seatNo);
	}

	@Override
	public void saveDB() throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		CompanyDao dao = new CompanyDao();
		try {
			dao.addSmallCar(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
