package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataAccessObjectBusinessData.EquipmentDAOBusinessData;
import dataAccessObjectPresentationBusiness.MaquinaObjAcessoDados;
import dataInterface.IGenericDados;

public class MaquinaDados implements IGenericDados<EquipmentDAOBusinessData> {
	
	private Connection connection=null;
	
	public MaquinaDados(Connection conn) {
		connection = conn;
	}
	
	
	@Override
	public List<EquipmentDAOBusinessData> getList() {
		String query = "Select * from MAQUINA";
		PreparedStatement pst = null;
		ResultSet res = null;
		List<EquipmentDAOBusinessData> maquinas = new ArrayList<EquipmentDAOBusinessData>();
		
		try {
			pst = connection.prepareStatement(query);
			res = pst.executeQuery();
			
			while(res.next()) {
				EquipmentDAOBusinessData maquina =
						new EquipmentDAOBusinessData(
								res.getInt("Id"),
								res.getString("Nome"),
								res.getString("Modelo"),
								res.getString("Fabricante"));
				maquinas.add(maquina);
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
			
		}
		
		return maquinas;
	}

	@Override
	public EquipmentDAOBusinessData get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(EquipmentDAOBusinessData obj) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public void delete(int id) {
		String cmd = "delete from MAQUINA where Id=?";
		try {
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setInt(1, id);
			pst.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}	
	}
}
