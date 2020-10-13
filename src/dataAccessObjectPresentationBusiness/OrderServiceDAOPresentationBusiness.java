package dataAccessObjectPresentationBusiness;

import genericDataAccessObject.GenericDataAccessObject;

public class OrderServiceDAOPresentationBusiness extends GenericDataAccessObject{

	int day;
	int month;
	int year;
	int startHour;
	int startMinute;
	int endHour;
	int endMinute;
	int idEquipment;
	int idTechinican;
	String description;
	int typeService;
	
	public  OrderServiceDAOPresentationBusiness(int idP, int dayP, int monthP, int yearP, int startHourP,
									  int startMinuteP, int endHourP, int endMinuteP, 
									  int idEquipmentP, int idTechinicanP, String descriptionP, 
									  int typeServiceP) {
		this.id = idP;
		this.day = dayP;
		this.month = monthP;
		this.year = yearP;
		this.startHour = startHourP;
		this.startMinute = startMinuteP;
		this.endHour = endHourP;
		this.endMinute = endMinuteP;
		this.idEquipment = idEquipmentP;
		this.idTechinican = idTechinicanP;
		this.description = descriptionP;
		this.typeService = typeServiceP;

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
	
	public int getIdEquipment() {
		return idEquipment;
	}
	
	public int getIdTechinican() {
		return idTechinican;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getTypeService() {
		return typeService;
	}
	
	public void setId(int idP) {
		id = idP;
	}
	
	public void setDay(int dayP){
		 day = dayP;
	}
	
	public void setMonth(int monthP) {
		 month = monthP;
	}
	
	public void setYear(int yearP) {
		 year = yearP;
	}
	
	public void setStartHour(int startHourP) {
		 startHour = startHourP;
	}
	
	public void setStartMinute(int startMinuteP) {
		 startMinute = startMinuteP;
	}
	
	public void setEndHour(int endHourP) {
		 endHour = endHourP;
	}
	
	public void setEndMinute(int endMinuteP) {
		 endMinute = endMinuteP;
	}
	
	public void setIdEquipment(int idEquipmentP) {
		 idEquipment = idEquipmentP;
	}
	
	public void setIdTechinican(int  idTechinicanP) {
		 idTechinican = idTechinicanP;
	}
	
	public void setDescription(String setDescriptionP) {
		 description = setDescriptionP;
	}
	
	public void setTypeService(int typeServiceP) {
		 typeService = typeServiceP;
	}


}

