package business;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import businessClass.BusinessGeneric;
import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.TechnicianData;
import dataAccessObjectBusinessData.TechnicianDAOBusinessData;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianBusiness extends BusinessGeneric implements IGenericBusiness<TechnicianDAOPresentationBusiness>  {

	public String feedbackMessage = "";
	TechnicianDAOPresentationBusiness technicianDAO;
	TechnicianData technicianData;
	
	public TechnicianBusiness() {
		technicianData = new TechnicianData(sqllConnection.dbConnector());
	}
	
	public TechnicianBusiness(TechnicianData technicianData){
		this.technicianData = technicianData;
	}
	
	public TechnicianBusiness(int id, String role, String name, Double hourPrice) {
		technicianDAO = new TechnicianDAOPresentationBusiness(id, role, name, hourPrice);
		technicianData = new TechnicianData(sqllConnection.dbConnector());
	}
	
	private boolean hasPendencies(TechnicianDAOPresentationBusiness technician) {
		feedbackMessage = "";
		
		if (technician.getName().trim().length() == 0)
			feedbackMessage = "Informar o nome do técnico.";
		else if (technician.getRole().trim().length() == 0)
			feedbackMessage = "Informar o cargo do técnico.";
		else if (technician.getHourPrice() <= 0) 
			feedbackMessage = "Informar um valor de hora do técnico maior que zero.";
		
		if (feedbackMessage.length() > 0) {
			return true;
		}
		return false;	
	}
	
	private String convertRoleIdToName(int id){
		if (id == 0)
			return "Eletricista";
		if (id == 1)
			return "Mecânico";
		return "";
	}
	
	private int convertNameToRoleId(String roleName){
		if (roleName.equals("Eletricista"))
			return 0;
		if (roleName.equals("Mecânico"))
			return 1;
		return -1;
	}
	
	public String[] getAvaliableRoles() {
		List<String> rolesString = new ArrayList<String>();
		
		for (int role : technicianData.getAvaliableRoles()) {
			rolesString.add(convertRoleIdToName(role));
	    }
		
		return  rolesString.toArray(new String[0]); 
	}
	
	public String[] getAvaliableTechnicians() {
		List<String> names = new ArrayList<String>();
		
		for (String name : technicianData.getAvaliableTechnicians()) {
			names.add(name);
	    }
		
		return  names.toArray(new String[0]); 
	}
	
	private TechnicianDAOPresentationBusiness convertDAOBusinessDataToPresentationBusiness(TechnicianDAOBusinessData DAOBusinessData) {
		int id = DAOBusinessData.getId();
		String role = convertRoleIdToName(DAOBusinessData.getRole());
		Double hourPrice = DAOBusinessData.getHourPrice();
		String name = DAOBusinessData.getName();
		TechnicianDAOPresentationBusiness DAOPresentBusiness = new TechnicianDAOPresentationBusiness(id, role, name, hourPrice);
		return DAOPresentBusiness;
	}
	
	private TechnicianDAOBusinessData convertDAOPresentationBusinessToBusinessData( TechnicianDAOPresentationBusiness DAOPresentation) {
		int id = DAOPresentation.getId();
		int role = convertNameToRoleId(DAOPresentation.getRole());
		Double hourPrice = DAOPresentation.getHourPrice();
		String name = DAOPresentation.getName();
		TechnicianDAOBusinessData DAOData = new TechnicianDAOBusinessData(id, role, name, hourPrice);
		return DAOData;
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
		if(!super.isValidId(id)) {
			feedbackMessage = "Id inválido";
			return null;
		}
		
		return convertDAOBusinessDataToPresentationBusiness(technicianData.get(id));
	}
	
	public TechnicianDAOPresentationBusiness getByName(String name) {
		return convertDAOBusinessDataToPresentationBusiness(technicianData.getByName(name));
	}

	
	
	@Override
	public boolean save(TechnicianDAOPresentationBusiness technician) {
		if (hasPendencies(technician))
			return false;
		
		try {
		technicianData.save(convertDAOPresentationBusinessToBusinessData(technician));
		}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		return false;
		}
		
		return true;
	}

	@Override
	public void delete(int id) {
		technicianData.delete(id);
	}

	
}
