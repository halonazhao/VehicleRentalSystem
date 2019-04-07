package com.rentalSystem.biz;

import java.sql.SQLException;

import com.rentalSystem.dao.CompanyDao;

public class TTruck extends TVehicle{
	private int capacity;
	public TTruck(String model, String plateNo, String status, int seatNo, int capacity) {
		super(model, plateNo, status, seatNo);
		this.capacity = capacity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public void saveDB() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		CompanyDao dao = new CompanyDao();
		try {
			dao.addTruck(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
