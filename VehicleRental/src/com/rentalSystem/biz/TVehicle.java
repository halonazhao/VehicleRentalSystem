package com.rentalSystem.biz;

import java.sql.SQLException;

public abstract class TVehicle {
	private String model;
	private String plateNo;
	private String status;
	private int seatNo;
	public abstract void saveDB() throws SQLException, ClassNotFoundException;
	
	public TVehicle(String model, String plateNo, String status, int seatNo) {
		this.model = model;
		this.plateNo = plateNo;
		this.status = status;
		this.seatNo = seatNo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public double getPrice() {
		return 0.0;
	}
	

}
