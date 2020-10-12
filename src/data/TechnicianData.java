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
