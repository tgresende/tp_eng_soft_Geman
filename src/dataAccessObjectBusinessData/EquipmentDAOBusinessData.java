package dataAccessObjectBusinessData;

import genericDataAccessObject.GenericDataAccessObject;

public class EquipmentDAOBusinessData extends GenericDataAccessObject{

	String Nome;
	String Modelo;
	String Fabricante;
	
	public EquipmentDAOBusinessData(int id, String nome, String modelo, String fabricante) {
		this.id = id;
		this.Nome = nome;
		this.Modelo = modelo;
		this.Fabricante = fabricante;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public String getModelo() {
		return Modelo;
	}
	
	public String getFabricante() {
		return Fabricante;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setNome(String nome) {
		Nome=nome ;
	}
	
	public void setModelo(String modelo) {
		Modelo=modelo;
	}
	
	public void setFabricante(String fabricante) {
		Fabricante=fabricante ;
	}
}
