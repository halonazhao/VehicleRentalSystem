package com.rentalSystem.ui;

import com.rentalSystem.biz.VehicleTypeBiz;
import com.rentalSystem.entity.TVehicleType;

public class TestAddVehicleType {
	public static void main(String[] args) {
		TVehicleType avehicleType = new TVehicleType("00013", "Box Truck", 20.0);
		VehicleTypeBiz atype = new VehicleTypeBiz(avehicleType);
		TVehicleType bvehicleType = new TVehicleType("00014", "Cabover Truck", 40.0);
		VehicleTypeBiz btype = new VehicleTypeBiz(bvehicleType);
		TVehicleType cvehicleType = new TVehicleType("00015", "Pick Truck", 40.0);
		VehicleTypeBiz ctype = new VehicleTypeBiz(cvehicleType);
		try {
			atype.saveDB();
			btype.saveDB();
			ctype.saveDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not successfully");
			e.printStackTrace();
		}
	}
}
