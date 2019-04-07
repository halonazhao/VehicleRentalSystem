package com.rentalSystem.biz;

public class TEmployee {
	private String employeeNo;
	private String employeeName;
	
	public TEmployee(String name, String number) {
		employeeName = name;
		employeeNo = number;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	


}
