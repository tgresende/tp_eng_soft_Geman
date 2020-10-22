package dataAccessObjectBusinessData;

import genericDataAccessObject.GenericDataAccessObject;

public class MeanTimeRepairDAOBusinessData extends GenericDataAccessObject{

	String name;
	Double hour;
	
	public MeanTimeRepairDAOBusinessData(int id, String name, Double hour) {
		this.id = id;
		this.name = name;
		this.hour = hour;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getHour() {
		return hour;
	}
	
}
