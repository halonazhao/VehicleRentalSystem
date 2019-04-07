package com.rentalSystem.biz;

import java.sql.Date;
import java.util.List;

import com.rentalSystem.dao.CompanyDao;
import com.rentalSystem.entity.TRentalDetail;
import com.rentalSystem.entity.TRentalOrder;
import com.rentalSystem.entity.TVehicleType;

public class Company {
	private String name;
	private List<TVehicle> vehicles;
	private List<TEmployee> employees;
	private List<TVehicleType> vehicleTypes;
	
	public Company(String name) {
		this.name = name;
	}
	
	public void addEmployee(TEmployee employee) throws Exception{
		this.employees.add(employee);
	}
	
	public void addVehicle(TVehicle aVehicle) throws Exception{
		if(aVehicle != null) {
			aVehicle.saveDB();
		}else {
			throw new Exception("Added vehicle is not valid");
		}
	}
	public void addClient(TClient client) throws Exception{
		
	}
	public void addVehicleType(TVehicleType vehicleType) throws Exception{
		if(vehicleType != null) {
			VehicleTypeBiz vehicleBiz = new VehicleTypeBiz(vehicleType);
			vehicleBiz.saveDB();
		}else {
			throw new Exception("Added vehicle type is not valide!");
		}
	}
	
	public String putOrder(List<TVehicle> vehicles, TClient client, TRentalOrder rentinfo) throws Exception{
		String ordno = null;
		if(vehicles != null && client != null && rentinfo != null) {
			CompanyDao dao = new CompanyDao();
			try {
				dao.beginTransaction();
				//add client info
				dao.addClient(client);
				//create record in rentalorder
				ordno = dao.addOrder(rentinfo);
				//add rental details
				System.out.println("added?");
				for(TVehicle avehicle: vehicles) {
					TRentalDetail detail = getTRentDetail(ordno, avehicle);
					dao.addRentalDetails(detail);
				}
				//change vehicle status
				//will be done implictly at dao layer
				dao.commit();
			} catch (Exception e) {
				dao.rollback();
				throw e;
			} finally {
				dao.closeConnection();
			}
			
		}else {
			throw new Exception("Input is not valid");
		}
		return ordno;

	}
	
	public void returnVehicles(String ordNo) throws Exception{
		CompanyDao dao = new CompanyDao();
		try {
			dao.beginTransaction();
			//update return record
			dao.addReturnRecord(ordNo);
			//calculate total price
			double price = dao.countPrice(ordNo);
			System.out.println(price);
			//update total price in order
			dao.updatePriceInOrder(ordNo, price);
			//update Car status
			dao.returnsetRecord(ordNo);
		} catch (Exception e) {
			dao.rollback();
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}
		
		
	}
	
	private TRentalDetail getTRentDetail(String orderno, TVehicle avehicle) {
		TRentalDetail detail = new TRentalDetail();
		detail.setPlateNo(avehicle.getPlateNo());
		detail.setOrderNo(orderno);
		detail.setPricePerUnit(avehicle.getPrice());
		return detail;
	}
}
