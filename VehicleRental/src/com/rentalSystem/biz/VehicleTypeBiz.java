package com.rentalSystem.biz;

import com.rentalSystem.dao.CompanyDao;
import com.rentalSystem.entity.TVehicleType;

public class VehicleTypeBiz {
	private TVehicleType aType;
	
	public VehicleTypeBiz(TVehicleType a) {
		aType = a;
	}
	
	public TVehicleType getaType() {
		return aType;
	}

	public void setaType(TVehicleType aType) {
		this.aType = aType;
	}

	public void saveDB() throws Exception{
		CompanyDao dao = new CompanyDao();
		dao.addVehicleType(this);
	}
	public void deleteDB() throws Exception{
		CompanyDao dao = new CompanyDao();
		dao.removeVehicleType(this);
	}

}
