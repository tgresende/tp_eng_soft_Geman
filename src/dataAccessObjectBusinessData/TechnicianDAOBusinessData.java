package dataAccessObjectBusinessData;

import genericDataAccessObject.GenericDataAccessObject;

public class TechnicianDAOBusinessData extends GenericDataAccessObject{
	
	int role;
	String name;
	double hourPrice;
	
	public TechnicianDAOBusinessData(int id, int role, String name, Double hourPrice) {
		this.id = id;
		this.role = role;
		this.name = name;
		this.hourPrice = hourPrice;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getRole() {
		return role;
	}
	
	public Double getHourPrice() {
		return hourPrice;
	}
	
}
