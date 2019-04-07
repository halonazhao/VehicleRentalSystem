package com.rentalSystem.entity;

public class TVehicleType {
	private String vehicleNo;
	private String model;
	private double pricePerDay;
	
	public TVehicleType(String vehicleNo, String model, double pricePerDay) {
		this.vehicleNo = vehicleNo;
		this.model = model;
		this.pricePerDay = pricePerDay;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

}
