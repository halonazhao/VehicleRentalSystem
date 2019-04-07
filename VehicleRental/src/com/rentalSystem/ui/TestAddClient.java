package com.rentalSystem.ui;

import com.rentalSystem.biz.TClient;

public class TestAddClient {
	public static void main(String[] args) {
		TClient aclient = new TClient();
		aclient.setClientNo("C8453345");
		aclient.setAddress("400 King Street");
		aclient.setId("9874357");
		aclient.setMobile("875923857");
		aclient.setName("Josh");
		try {
			aclient.addClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
