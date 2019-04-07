package com.rentalSystem.ui;

import java.sql.SQLException;

import com.rentalSystem.biz.TTruck;
import com.rentalSystem.entity.RentalStatus;

public class TestAddTruck {
	public static void main(String[] args) {
		//TTruck(String model, String plateNo, String status, int seatNo, int capacity)
		TTruck aTruck = new TTruck("Pick Truck", "A8372", RentalStatus.Avaliable, 5, 1);
		try {
			aTruck.saveDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("This truck wasn't added successfully.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection was successfully built.");
			e.printStackTrace();
		}
		TTruck bTruck = new TTruck("Box Truck", "U834372", RentalStatus.Avaliable, 5, 3);
		try {
			bTruck.saveDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("This truck wasn't added successfully.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection was successfully built.");
			e.printStackTrace();
		}
		TTruck cTruck = new TTruck("Box Truck", "O8457", RentalStatus.Avaliable, 5, 3);
		try {
			cTruck.saveDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("This truck wasn't added successfully.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection was successfully built.");
			e.printStackTrace();
		}
		TTruck dTruck = new TTruck("Cabover Truck", "Y8447", RentalStatus.Avaliable, 5, 5);
		try {
			dTruck.saveDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("This truck wasn't added successfully.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection was successfully built.");
			e.printStackTrace();
		}
	}

}
