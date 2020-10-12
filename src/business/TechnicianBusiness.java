package business;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.TechnicianData;
import dataAccessObject.TechnicianDAO;

public class TechnicianBusiness implements IGenericBusiness<TechnicianDAO> {

	TechnicianDAO technicianDAO;
	TechnicianData technicianData = new TechnicianData(sqllConnection.dbConnector());
	
	public TechnicianBusiness() {
		
	}
	
	public TechnicianBusiness(int id, int cargo, String nome) {
		technicianDAO = new TechnicianDAO(id, cargo, nome);
	}
	
	public DefaultTableModel getModelList() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Cargo");
		
		for (TechnicianDAO usuario : technicianData.getList()) {
			tableModel.addRow(
					new Object[]{
							usuario.getId(), 
							usuario.getNome(),
							usuario.getCargo()
							}
			);
		}
		
		return tableModel;
	}
	
	@Override
	public List<TechnicianDAO> getList() {
		return technicianData.getList();
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
		technicianData.delete(id);
	}

	
}
