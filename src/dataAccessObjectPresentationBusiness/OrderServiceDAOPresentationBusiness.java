package dataAccessObjectPresentationBusiness;

import genericDataAccessObject.GenericDataAccessObject;

public class OrderServiceDAOPresentationBusiness extends GenericDataAccessObject{

	int id;
	String date;
	String startTime;
	String endTime;
	String equipment;
	String techinician;
	String description;
	String typeService;
	
	public  OrderServiceDAOPresentationBusiness(int id, String date, String startTime,
									  String endTime, String equipment, String techinician,
									  String description,String typeService) {
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.equipment = equipment;
		this.techinician = techinician;
		this.description = description;
		this.typeService = typeService;

	}
	
	public OrderServiceDAOPresentationBusiness() {
	}

	public int getId() {
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEquipment() {
		return equipment;
	}
	
	public String getTechinician() {
		return techinician;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getTypeService() {
		return typeService;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public void setEquipment(String equipment) {
		 this.equipment = equipment;
	}
	
	public void setTechinician(String techinician) {
		 this.techinician = techinician;
	}
	
	public void setDescription(String setDescription) {
		this.description = setDescription;
	}
	
	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}


}

