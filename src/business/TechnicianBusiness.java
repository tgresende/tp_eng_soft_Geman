package business;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import businessClass.BusinessGeneric;
import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.TechnicianData;
import dataAccessObject.TechnicianDAO;

public class TechnicianBusiness extends BusinessGeneric implements IGenericBusiness<TechnicianDAO>  {

	TechnicianDAO technicianDAO;
	TechnicianData technicianData = new TechnicianData(sqllConnection.dbConnector());
	
	public TechnicianBusiness() {
		
	}
	
	public TechnicianBusiness(int id, int role, String name, Double hourPrice) {
		technicianDAO = new TechnicianDAO(id, role, name, hourPrice);
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
							usuario.getName(),
							usuario.getRole()
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
		super.verifyId(id, "Id inválido!");
		return technicianData.get(id);
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
