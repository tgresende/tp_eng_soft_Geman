package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataAccessObjectBusinessData.TechnicianDAOBusinessData;
import dataInterface.IGenericDados;

public class TechnicianData implements IGenericDados<TechnicianDAOBusinessData>{

	private Connection connection=null;
	
	public TechnicianData(Connection conn) {
		connection = conn;
	}
	
	public List<Integer> getAvaliableRoles() {
		List<Integer> roles = new ArrayList<Integer>();
		
		String query = "Select distinct role from Technician";
		
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				roles.add(res.getInt("role"));
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
		return roles; 
	}
	
	public List<String> getAvaliableTechnicians() {
		List<String> roles = new ArrayList<String>();
		
		String query = "Select distinct name from Technician";
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
	public List<TechnicianDAOBusinessData> getList() {
		String query = "Select * from Technician";
		List<TechnicianDAOBusinessData> technicians = new ArrayList<TechnicianDAOBusinessData>();
		
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			
			while(res.next()){
				TechnicianDAOBusinessData technician = 
						new TechnicianDAOBusinessData(
							res.getInt("id"), 
							res.getInt("role"),
							res.getString("name"),
							res.getDouble("hourPrice"));
				technicians.add(technician);
			}
			
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}

		return technicians;
	}

	@Override
	public TechnicianDAOBusinessData get(int id) {
		String query = "Select * from Technician where Id=?";
		TechnicianDAOBusinessData technician = null;
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			
			while(res.next()){
				technician = new TechnicianDAOBusinessData(
								res.getInt("id"), 
								res.getInt("role"),
								res.getString("name"),
								res.getDouble("hourPrice"));
				
			}
			res.close();
			return technician;
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
	}
	
	public TechnicianDAOBusinessData getByName(String name) {
		String query = "Select * from Technician where name=?";
		TechnicianDAOBusinessData technician = null;
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, name);
			ResultSet res = pst.executeQuery();
			
			while(res.next()){
				technician = new TechnicianDAOBusinessData(
								res.getInt("id"), 
								res.getInt("role"),
								res.getString("name"),
								res.getDouble("hourPrice"));
				
			}
			res.close();
			return technician;
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
	}

	@Override
	public boolean save(TechnicianDAOBusinessData technician) {
		String cmd;
		if (technician.getId() == 0)
			cmd = " insert into Technician ("
					+ " name, "
					+ " role, "
					+ " hourPrice"
					+ ") values ("
					+ " ?, "
					+ " ?,"
					+ " ?)";
		else
			cmd = " update Technician set "
					+ " name = ?, "
					+ " role = ?,"
					+ " hourPrice = ?"
				  +" where Id=?";
		try {
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setString(1, technician.getName());
			pst.setInt(2, technician.getRole());
			pst.setDouble(3, technician.getHourPrice());
			
		if (technician.getId() != 0)
			pst.setInt(4, technician.getId());
		
			pst.executeUpdate();
			pst.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
		return true;
	}

	@Override
	public void delete(int id) {
		String cmd = "delete from Technician where Id=?";
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
