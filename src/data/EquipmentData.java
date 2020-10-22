package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataAccessObjectBusinessData.EquipmentDAOBusinessData;
import dataInterface.IGenericDados;

public class EquipmentData implements IGenericDados<EquipmentDAOBusinessData> {
	
	private Connection connection=null;
	
	public EquipmentData(Connection conn) {
		connection = conn;
	}
	
	String feedbackMessage;
	
	public String getFeedbackMessage() {
		return feedbackMessage;
	}
	
	public List<String> getAvaliableEquipments() {
		List<String> roles = new ArrayList<String>();
		
		String query = "Select distinct name from Equipment";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				roles.add(res.getString("name"));
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
		return roles; 
	}
	
	@Override
	public List<EquipmentDAOBusinessData> getList() {
		String query = "Select * from EQUIPMENT";
		PreparedStatement pst = null;
		ResultSet res = null;
		List<EquipmentDAOBusinessData> equipments = new ArrayList<EquipmentDAOBusinessData>();
		
		try {
			pst = connection.prepareStatement(query);
			res = pst.executeQuery();
			
			while(res.next()) {
				EquipmentDAOBusinessData equipment =
						new EquipmentDAOBusinessData(
								res.getInt("Id"),
								res.getString("Name"),
								res.getString("Model"),
								res.getString("Manufacturer"));
				equipments.add(equipment);
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
			
		}
		
		return equipments;
	}


	
	@Override
	public EquipmentDAOBusinessData get(int id) {
		String query = "Select * from EQUIPMENT where Id=?";
		EquipmentDAOBusinessData equipment = null;
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			
			while(res.next()){
				equipment = new EquipmentDAOBusinessData(
								res.getInt("id"), 
								res.getString("name"),
								res.getString("model"),
								res.getString("manufacturer"));
				
			}
			res.close();
			return equipment;
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
	}
	
	public EquipmentDAOBusinessData getByName(String name) {
		String query = "Select * from EQUIPMENT where name=?";
		EquipmentDAOBusinessData equipment = null;
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, name);
			ResultSet res = pst.executeQuery();
			
			while(res.next()){
				equipment = new EquipmentDAOBusinessData(
								res.getInt("id"), 
								res.getString("name"),
								res.getString("model"),
								res.getString("manufacturer"));
				
			}
			res.close();
			return equipment;
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
	}


	@Override
	public boolean save(EquipmentDAOBusinessData equipment) {
		String cmd;
		if (equipment.getId() == 0)
			cmd = " insert into EQUIPMENT ("
					+ " name, "
					+ " model, "
					+ " manufacturer"
					+ ") values ("
					+ " ?, "
					+ " ?,"
					+ " ?)";
		else
			cmd = " update EQUIPMENT set "
					+ " name = ?, "
					+ " model = ?,"
					+ " manufacturer = ?"
				  +" where Id=?";
		try {
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setString(1, equipment.getName());
			pst.setString(2, equipment.getModel());
			pst.setString(3, equipment.getManufacturer());
			
		if (equipment.getId() != 0)
			pst.setInt(4, equipment.getId());
		
			pst.executeUpdate();
			pst.close();
		}catch(Exception e) {
			feedbackMessage = "erro ao salvar no banco de dados: ";
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		String cmd = "delete from EQUIPMENT where Id=?";
		try {
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}	
	}
}
