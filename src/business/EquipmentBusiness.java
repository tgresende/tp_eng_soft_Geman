package business;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import businessClass.BusinessGeneric;
import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.EquipmentData;
import dataAccessObjectBusinessData.EquipmentDAOBusinessData;
import dataAccessObjectPresentationBusiness.EquipmentDAOPresentationBusiness;

public class EquipmentBusiness extends BusinessGeneric implements IGenericBusiness<EquipmentDAOPresentationBusiness>{

	EquipmentDAOPresentationBusiness equipmentDAO;
	EquipmentData equipmentData = new EquipmentData(sqllConnection.dbConnector());
	
	public EquipmentBusiness() {
		
	}
	
	public String[] getAvaliableEquipments() {
		List<String> equipmentNames = new ArrayList<String>();
		
		for (String equipment : equipmentData.getAvaliableEquipments()) {
			equipmentNames.add(equipment);
	    }
		
		return  equipmentNames.toArray(new String[0]); 
	}
	
	
	
	private EquipmentDAOPresentationBusiness convertDAOBusinessDataToPresentationBusiness(EquipmentDAOBusinessData DAOBusinessData) {
		int id = DAOBusinessData.getId();
		String name = DAOBusinessData.getName();
		String model = DAOBusinessData.getModel();
		String manufacturer = DAOBusinessData.getManufacturer();
		
		EquipmentDAOPresentationBusiness DAOPresentBusiness = new EquipmentDAOPresentationBusiness(id, name, model, manufacturer);
		return DAOPresentBusiness;
	}
	
	private EquipmentDAOBusinessData convertDAOPresentationBusinessToBusinessData( EquipmentDAOPresentationBusiness DAOPresentation) {
		int id = DAOPresentation.getId();
		String name = DAOPresentation.getName();
		String model = DAOPresentation.getModel();
		String manufacturer = DAOPresentation.getManufacturer();
		EquipmentDAOBusinessData DAOData = new EquipmentDAOBusinessData(id, name, model, manufacturer);
		return DAOData;
	}
	
	
	
	
	public EquipmentBusiness(int id, String name, String model, String manufacturer) {
			equipmentDAO = new EquipmentDAOPresentationBusiness(id, name, model, manufacturer);
	}
	
	public DefaultTableModel getModelList() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Modelo");
		tableModel.addColumn("Fabricante");
		
		for (EquipmentDAOBusinessData equipment : equipmentData.getList()) {
			tableModel.addRow(
					new Object[] {
							equipment.getId(),
							equipment.getName(),
							equipment.getModel(),
							equipment.getManufacturer()
							}
			);
		}
				
		return tableModel;
	}
	
	
	
	
	@Override
	public List<EquipmentDAOPresentationBusiness> getList() {
		
		List<EquipmentDAOPresentationBusiness> equipmentsDAOPresentation = new ArrayList<EquipmentDAOPresentationBusiness>(); 
		
		for (EquipmentDAOBusinessData equipment : equipmentData.getList()) {
			equipmentsDAOPresentation.add(
					convertDAOBusinessDataToPresentationBusiness(equipment));
		}
		
		return equipmentsDAOPresentation;
	}

	@Override
	public EquipmentDAOPresentationBusiness get(int id) {
		super.verifyId(id, "Id inválido!");
		
		return convertDAOBusinessDataToPresentationBusiness(equipmentData.get(id));
	}
	
	public EquipmentDAOPresentationBusiness getByName(String name) {
		return convertDAOBusinessDataToPresentationBusiness(equipmentData.getByName(name));
	}

	@Override
	public boolean save(EquipmentDAOPresentationBusiness equipment) {
		try {
			equipmentData.save(convertDAOPresentationBusinessToBusinessData(equipment));
			}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, e.getMessage());
	    		return false;
			}
			
			return true;
	}

	@Override
	public void delete(int id) {
		equipmentData.delete(id);
	}

}
