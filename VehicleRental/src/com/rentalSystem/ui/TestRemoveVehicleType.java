package com.rentalSystem.ui;

import com.rentalSystem.biz.VehicleTypeBiz;
import com.rentalSystem.entity.TVehicleType;

public class TestRemoveVehicleType {
	public static void main(String[] args) {
		TVehicleType avehicleType = new TVehicleType("00012", "test Type", 30.0);
		VehicleTypeBiz atype = new VehicleTypeBiz(avehicleType);
		try {
			atype.deleteDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not successfully");
			e.printStackTrace();
		}
	}

}
