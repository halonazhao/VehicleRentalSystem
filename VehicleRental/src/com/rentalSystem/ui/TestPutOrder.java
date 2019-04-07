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
import com.rentalSystem.entity.TRentalDetail;
import com.rentalSystem.entity.TRentalOrder;

public class TestPutOrder {
	public static void main(String[] args) {
		Company acompany = new Company("Enterprise");
		//String putOrder(List<TVehicle> vehicles, TClient client, TRentalOrder rentinfo)
		SmallCar aCar = new SmallCar("Nissan Versa", "Y4953", RentalStatus.Avaliable, 5);
		SmallCar bCar = new SmallCar("Hyundai Elantra", "Oreuhr", RentalStatus.Avaliable, 5);
		TTruck aTruck = new TTruck("Pick Truck", "A8372", RentalStatus.Avaliable, 5, 1);
		List<TVehicle> listOfcars = new ArrayList<TVehicle>();
		listOfcars.add(aCar);
		listOfcars.add(bCar);
		listOfcars.add(aTruck);
		TClient aclient = new TClient();
		aclient.setClientNo("C8453345");
		aclient.setAddress("400 King Street");
		aclient.setId("9874357");
		aclient.setMobile("875923857");
		aclient.setName("Josh");
		TRentalOrder  details = new TRentalOrder();
		details.setClientNo("C8453345");
		details.setDeposite(100.0);
		details.setEmployeeNo("E142384");
		details.setRentDate(new Date());
		details.setTotalPrice(0);
		try {
			String ord = acompany.putOrder(listOfcars, aclient, details);
			System.out.println("Order " + ord + "has been created!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
