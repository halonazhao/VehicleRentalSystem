package com.rentalSystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rentalSystem.biz.SmallCar;
import com.rentalSystem.biz.TClient;
import com.rentalSystem.biz.TTruck;
import com.rentalSystem.biz.TVehicle;
import com.rentalSystem.biz.VehicleTypeBiz;
import com.rentalSystem.dto.TRentinfoDto;
import com.rentalSystem.entity.TRentalDetail;
import com.rentalSystem.entity.TRentalOrder;

public class CompanyDao extends BaseDao{
	public void addVehicleType(VehicleTypeBiz atype) {
		String sql = "insert into vehicleType values (?,?,?)";
		try {
			this.openConnection();
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, atype.getaType().getModel());
			ps.setDouble(2, atype.getaType().getPricePerDay());
			ps.setString(3, atype.getaType().getVehicleNo());
			ps.executeUpdate();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeVehicleType(VehicleTypeBiz atype) {
		String sql = "delete from vehicleType where model = (?)";
		try {
			this.openConnection();
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, atype.getaType().getModel());
			ps.executeUpdate();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addTruck(TTruck aTruck) throws SQLException, ClassNotFoundException{
		String sql = "Insert into Vehicle values (?, ?, ?, ?)";
		String sql1 = "Insert into Truck values (?, ?)";
		try {
			this.openConnection();
			PreparedStatement sm = this.connection.prepareStatement(sql);
			sm.setString(1, aTruck.getModel());
			sm.setString(2, aTruck.getPlateNo());
			sm.setString(3, aTruck.getStatus());
			sm.setInt(4, aTruck.getSeatNo());
			sm.executeUpdate();
			sm.close();
			PreparedStatement sm1 = this.connection.prepareStatement(sql1);
			sm1.setString(1, aTruck.getPlateNo());
			sm1.setInt(2, aTruck.getCapacity());
			sm1.executeUpdate();
			sm1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addSmallCar(SmallCar aCar) throws SQLException, ClassNotFoundException{
		String sql = "Insert into Vehicle values (?, ?, ?, ?)";
		try {
			this.openConnection();
			PreparedStatement sm = this.connection.prepareStatement(sql);
			sm.setString(1, aCar.getModel());
			sm.setString(2, aCar.getPlateNo());
			sm.setString(3, aCar.getStatus());
			sm.setInt(4, aCar.getSeatNo());
			sm.executeUpdate();
			sm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addClient(TClient client) throws Exception{
		// Check whether the client has exited in the db
		boolean exist = checkClient(client.getMobile());
		if(exist) {
			System.out.println(client.getName() + "has registered before! You can directly start renting.");
			}else {
				//if not exist add client
				String sql = "insert into client values(?,?,?,?,?)";
				this.openConnection();
				PreparedStatement ps = this.connection.prepareStatement(sql);
				ps.setString(1, client.getClientNo());
				ps.setString(2, client.getName());
				ps.setString(3, client.getId());
				ps.setString(4, client.getMobile());
				ps.setString(5, client.getAddress());
				ps.executeUpdate();
				ps.close();
		}


	}
	private boolean checkClient(String phoneNo) {
		String sql = "select * from client where mobile=?";
		try {
			this.openConnection();
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, phoneNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			rs.close();
			ps.close();			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//return order number
	public String addOrder(TRentalOrder anOrder) throws Exception{
		String sql = "insert into rentalorder values (?,?,?,?,?,?)";
		this.openConnection();
		PreparedStatement qs = this.connection.prepareStatement(sql);
		String orderNo = "Ord" + (new Date()).getTime();
		qs.setString(1, orderNo);
		qs.setString(2, anOrder.getEmployeeNo());
		qs.setString(3, anOrder.getClientNo());
		qs.setDouble(4, anOrder.getTotalPrice());
		qs.setDate(5, new java.sql.Date(anOrder.getRentDate().getTime()));
		qs.setDouble(6, anOrder.getDeposite());
		qs.executeUpdate();
		qs.close();
		return orderNo;
		
	}
	
	public void addRentalDetails(TRentalDetail detail) throws Exception{
		//add details for each car in an order
		String sql = "insert into eachcarorderdetail values (?,order_detail_id.nextval,?,?)";
		this.openConnection();
		PreparedStatement qs = this.connection.prepareStatement(sql);
		qs.setString(1, detail.getOrderNo());
		qs.setString(2, detail.getPlateNo());
		qs.setDouble(3, detail.getPricePerUnit());
		qs.executeUpdate();
		System.out.println("Details added");
		qs.close();	
		//update car status
		updateStatus(detail.getPlateNo());
	}
	
	public double countPrice(String orderNo) throws Exception{
		String sql = "select sum(priceperunit) totalPrice from RentalOrder r, EachcarOrderDetail t where r.orderno = t.orderno and r.orderno = ?";
		this.openConnection();
		double money = 0;
		PreparedStatement qs = this.connection.prepareStatement(sql);
		qs.setString(1, orderNo);
		ResultSet rs = qs.executeQuery();
		while(rs.next()) {
			money = rs.getDouble("totalPrice");
		}
		qs.close();
		rs.close();
		TRentinfoDto rentinfo = getRentalInfo(orderNo);
		int days = (int)((new Date().getTime()) - rentinfo.getRentDate().getTime())/(24*3600*1000) + 1;
		return money*days;
	}
	public void updatePriceInOrder(String orderNo, double totalPrice) throws Exception{
		String sql = "Update Rentalorder set totalprice=? where orderNo = ?";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setDouble(1, totalPrice);
		ps.setString(2, orderNo);
		ps.executeUpdate();
		ps.close();
	}
	public void addReturnRecord(String orderNo) throws Exception{
		String sql = "Insert into returnVehicle values (?,?)";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, orderNo);
		ps.setDate(2, new java.sql.Date(new Date().getTime()));
		ps.executeUpdate();
		ps.close();
	}
	public void returnsetRecord(String orderNo) throws Exception{
		String sql = "select plateNumber from Eachcarorderdetail inner join rentalorder on eachcarorderdetail.orderno = rentalorder.orderno"
				+ " where rentalorder.orderno = ?";
		List<String> setOfplate = new ArrayList<String>();
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, orderNo);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			setOfplate.add(rs.getString(1));
		}
		ps.close();
		rs.close();
		for(String plate:setOfplate) {
			updateReturnStates(plate);
		}
		
	}
	private void updateReturnStates(String plateNumber) throws Exception{
		String sql = "Update vehicle set rentalStatus = 'ready' where plateNumber = ?";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, plateNumber);
		ps.executeUpdate();
		ps.close();
		
	}
	public TRentinfoDto getRentalInfo(String orderNo) throws Exception{
		TRentinfoDto rentinfo = new TRentinfoDto();
		String sql = "select o.orderno, o.EmployeeNo, o.ClientNo, o.TotalPrice, o.RentalDate, o.Deposite, r.returnDate from"+
		" rentalorder o left join returnVehicle r on o.orderNo = r.orderNo and o.orderNo = ?";
		this.getConnection();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setString(1, orderNo);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			rentinfo.setOrderNo(rs.getString(1));
			rentinfo.setEmployeeNo(rs.getString(2));
			rentinfo.setClientNo(rs.getString(3));
			rentinfo.setTotalPrice(rs.getDouble(4));
			rentinfo.setRentDate(rs.getDate(5));
			rentinfo.setDeposite(rs.getDouble(6));
			rentinfo.setRetrunDate(rs.getDate(7));
		}
		return rentinfo;
	}
	private void updateStatus(String plateNo) throws Exception{
		String sql = "Update vehicle set rentalstatus='Rented' where plateNumber=?";
		this.openConnection();
		PreparedStatement qs = this.connection.prepareStatement(sql);
		qs.setString(1, plateNo);
		qs.executeUpdate();
		qs.close();
		
	}
}
