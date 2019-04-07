package com.rentalSystem.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rentalSystem.biz.Company;
import com.rentalSystem.biz.SmallCar;
import com.rentalSystem.biz.TClient;
import com.rentalSystem.biz.TTruck;
import com.rentalSystem.biz.TVehicle;
import com.rentalSystem.entity.RentalStatus;
import com.rentalSystem.entity.TRentalOrder;

public class TestReturnCar {
	public static void main(String[] args) {
		Company acompany = new Company("Enterprise");
		try {
			acompany.returnVehicles("Ord1554613104695");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
