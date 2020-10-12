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
		String query = "Select * from USUARIO";
		PreparedStatement pst = null;
		ResultSet res = null;
		List<TechnicianDAO> usuarios = new ArrayList<TechnicianDAO>();
		
		try {
			pst = connection.prepareStatement(query);
			res = pst.executeQuery();
			
			while(res.next()){
				TechnicianDAO usuario = 
						new TechnicianDAO(
							res.getInt("Id"), 
							res.getInt("Cargo"),
							res.getString("Nome"));
				usuarios.add(usuario);
			}
			
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}

		return usuarios;
	}

	@Override
	public TechnicianDAO get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		String cmd = "delete from USUARIO where Id=?";
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
