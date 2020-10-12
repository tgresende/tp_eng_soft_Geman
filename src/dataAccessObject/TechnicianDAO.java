package dataAccessObject;

public class TechnicianDAO extends GenericDataAccessObject {

	
	
	int role;
	String name;
	double hourPrice;
	
	public TechnicianDAO(int id, int role, String name, Double hourPrice) {
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
	
	public void setName(String name) {
		this.name=name ;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setCargo(int role) {
		this.role = role;
	}
	
	
}
