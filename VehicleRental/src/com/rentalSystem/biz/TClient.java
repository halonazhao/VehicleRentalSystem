package com.rentalSystem.biz;

import com.rentalSystem.dao.CompanyDao;

public class TClient {
	private String clientNo;
	private String name;
	private String id;
	private String mobile;
	private String address;
	
	public void addClient() throws Exception{
		CompanyDao dao = new CompanyDao();
		try {
			dao.addClient(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
