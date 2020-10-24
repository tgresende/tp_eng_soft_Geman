package dataAccessObjectBusinessData;

import genericDataAccessObject.GenericDataAccessObject;

public class OrderServiceDAOBusinessData extends GenericDataAccessObject{


	int day;
	int month;
	int year;
	int startHour;
	int startMinute;
	int endHour;
	int endMinute;
	int equipment;
	int technician;
	String description;
	int typeService;
	
	public  OrderServiceDAOBusinessData(int id, int day, int month, int year, int startHour,
									  int startMinute, int endHour, int endMinute, 
									  int equipment, int technician, String description, 
									  int typeService) {
		this.id = id;
		this.day = day;
		this.month = month;
		this.year = year;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.equipment = equipment;
		this.technician = technician;
		this.description = description;
		this.typeService = typeService;

	}
	
	public int getId() {
		return id;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getStartHour() {
		return startHour;
	}
	
	public int getStartMinute() {
		return startMinute;
	}
	
	public int getEndHour() {
		return endHour;
	}
	
	public int getEndMinute() {
		return endMinute;
	}
	
	public int getEquipment() {
		return equipment;
	}
	
	public int getTechnician() {
		return technician;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getTypeService() {
		return typeService;
	}
}
