package dataAccessObjectPresentationBusiness;

import genericDataAccessObject.GenericDataAccessObject;

public class TechnicianDAOPresentationBusiness extends GenericDataAccessObject {

	String role;
	String name;
	double hourPrice;
	
	public TechnicianDAOPresentationBusiness(int id, String role, String name, Double hourPrice) {
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
	
	public String getRole() {
		return role;
	}
	
	public Double getHourPrice() {
		return hourPrice;
	}
}
