package dataAccessObjectBusinessData;

import genericDataAccessObject.GenericDataAccessObject;

public class EquipmentDAOBusinessData extends GenericDataAccessObject{

	String name;
	String model;
	String manufacturer;
	
	public EquipmentDAOBusinessData(int id, String name, String model, String manufacturer) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.manufacturer = manufacturer;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name ;
	}
	
	public void setModel(String model) {
		this.model=model;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer=manufacturer ;
	}
}
