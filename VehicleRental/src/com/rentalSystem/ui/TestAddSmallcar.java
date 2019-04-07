package com.rentalSystem.ui;

import java.sql.SQLException;

import com.rentalSystem.biz.SmallCar;
import com.rentalSystem.entity.RentalStatus;

public class TestAddSmallcar {
	public static void main(String[] args) {
		//TTruck(String model, String plateNo, String status, int seatNo, int capacity)
//		SmallCar aCar = new SmallCar("Nissan Versa", "Y4953", RentalStatus.Avaliable, 5);
//		try {
//			aCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
//		SmallCar bCar = new SmallCar("Hyundai Elantra", "Oreuhr", RentalStatus.Avaliable, 5);
//		try {
//			bCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
//		SmallCar cCar = new SmallCar("Volkswagen Jetta", "P854", RentalStatus.Avaliable, 5);
//		try {
//			cCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
//		SmallCar dCar = new SmallCar("Ford Fusion", "Y8523", RentalStatus.Avaliable, 5);
//		try {
//			dCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
//		SmallCar eCar = new SmallCar("Nissan Maxima", "S1234", RentalStatus.Avaliable, 5);
//		try {
//			eCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
//		SmallCar fCar = new SmallCar("Chrysler 300", "45g56", RentalStatus.Avaliable, 5);
//		try {
//			fCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
//		SmallCar gCar = new SmallCar("Cadillac XTS", "YB84", RentalStatus.Avaliable, 5);
//		try {
//			gCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
//		SmallCar hCar = new SmallCar("Ford Mustang", "UE1234", RentalStatus.Avaliable, 5);
//		try {
//			hCar.saveDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("This truck wasn't added successfully.");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Connection was successfully built.");
//			e.printStackTrace();
//		}
		SmallCar iCar = new SmallCar("Mercedes Benz CLA", "E466", RentalStatus.Avaliable, 5);
		try {
			iCar.saveDB();
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
