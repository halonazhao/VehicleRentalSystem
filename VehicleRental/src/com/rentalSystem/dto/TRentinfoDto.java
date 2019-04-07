package com.rentalSystem.dto;

import java.util.Date;

public class TRentinfoDto {
	private String orderNo;
	private String employeeNo;
	private String clientNo;
	private double totalPrice;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getClientNo() {
		return clientNo;
	}
	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	public double getDeposite() {
		return deposite;
	}
	public void setDeposite(double deposite) {
		this.deposite = deposite;
	}
	public Date getRetrunDate() {
		return retrunDate;
	}
	public void setRetrunDate(Date retrunDate) {
		this.retrunDate = retrunDate;
	}
	private Date rentDate;
	private double deposite;
	private Date retrunDate;
}
