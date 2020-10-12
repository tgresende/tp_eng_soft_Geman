package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataAccessObject.TechnicianDAO;
import dataInterface.IGenericDados;

public class TechnicianData implements IGenericDados<TechnicianDAO>{

	private Connection connection=null;
	
	public TechnicianData(Connection conn) {
		connection = conn;
	}
	
	@Override
	public List<TechnicianDAO> getList() {
		String query = "Select * from Technician";
		List<TechnicianDAO> technicians = new ArrayList<TechnicianDAO>();
		
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			
			while(res.next()){
				TechnicianDAO technician = 
						new TechnicianDAO(
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
	public TechnicianDAO get(int id) {
		String query = "Select * from Technician where Id=?";
		TechnicianDAO technician = null;
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			
			while(res.next()){
				technician = new TechnicianDAO(
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
	public void save() {
		// TODO Auto-generated method stub
		
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
