package business;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import businessClass.BusinessGeneric;
import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.TechnicianData;
import dataAccessObjectBusinessData.TechnicianDAOBusinessData;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianBusiness extends BusinessGeneric implements IGenericBusiness<TechnicianDAOPresentationBusiness>  {

	TechnicianDAOPresentationBusiness technicianDAO;
	TechnicianData technicianData = new TechnicianData(sqllConnection.dbConnector());
	
	public TechnicianBusiness() {
		
	}
	
	private String convertRoleIdToName(int id){
		if (id == 0)
			return "Eletricista";
		if (id == 1)
			return "Mecânico";
		return "";
	}
	
	
	private TechnicianDAOPresentationBusiness convertDAOBusinessDataToPresentationBusiness(TechnicianDAOBusinessData DAOBusinessData) {
		
		int id = DAOBusinessData.getId();
		String role = convertRoleIdToName(DAOBusinessData.getRole());
		Double hourPrice = DAOBusinessData.getHourPrice();
		String name = DAOBusinessData.getName();
		
		TechnicianDAOPresentationBusiness DAOPresentBusiness = new TechnicianDAOPresentationBusiness(id, role, name, hourPrice);
		
		
		return DAOPresentBusiness;
		
	}
	
	
	
	public TechnicianBusiness(int id, String role, String name, Double hourPrice) {
		technicianDAO = new TechnicianDAOPresentationBusiness(id, role, name, hourPrice);
	}
	
	public DefaultTableModel getModelList() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Cargo");
		
		for (TechnicianDAOBusinessData technician : technicianData.getList()) {
			tableModel.addRow(
					new Object[]{
							technician.getId(), 
							technician.getName(),
							convertRoleIdToName(technician.getRole())
							}
			);
		}
		
		return tableModel;
	}
	
	@Override
	public List<TechnicianDAOPresentationBusiness> getList() {		
		
		List<TechnicianDAOPresentationBusiness> techniciansDAOPresentation = new ArrayList<TechnicianDAOPresentationBusiness>(); 
		
		for (TechnicianDAOBusinessData technician : technicianData.getList()) {
			techniciansDAOPresentation.add(
					convertDAOBusinessDataToPresentationBusiness(technician));
		}
		
		return techniciansDAOPresentation;
	}

	@Override
	public TechnicianDAOPresentationBusiness get(int id) {
		super.verifyId(id, "Id inválido!");
		
		return convertDAOBusinessDataToPresentationBusiness(technicianData.get(id));
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
