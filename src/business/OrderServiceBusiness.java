package business;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import businessClass.BusinessGeneric;
import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.OrderServiceData;
import dataAccessObjectBusinessData.MeanTimeRepairDAOBusinessData;
import dataAccessObjectBusinessData.OrderServiceDAOBusinessData;
import dataAccessObjectPresentationBusiness.OrderServiceDAOPresentationBusiness;

public class OrderServiceBusiness extends BusinessGeneric implements IGenericBusiness<OrderServiceDAOPresentationBusiness> {

	public String feedbackMessage;
	OrderServiceDAOPresentationBusiness orderServiceDAO;
	EquipmentBusiness equipmentBusiness;
	TechnicianBusiness technicianBusiness;
	OrderServiceData orderServiceData = new OrderServiceData(sqllConnection.dbConnector());
	
	private void createDependencies() {
		technicianBusiness = new TechnicianBusiness();
		equipmentBusiness = new EquipmentBusiness();
		orderServiceData = new OrderServiceData(sqllConnection.dbConnector());
	}
	
	public OrderServiceBusiness() {
		createDependencies();
	}
	
	public OrderServiceBusiness(OrderServiceData data, TechnicianBusiness tech, EquipmentBusiness equip  ) {
		 orderServiceData = data;
		 technicianBusiness = tech;
		 equipmentBusiness = equip;
	}
	
	public String[] getAvaliableTypeService() {
		List<String> types = new ArrayList<String>();
		
		types.add("Preventiva");
		types.add("Corretiva");
		
		return  types.toArray(new String[0]); 
	}
	
	
	
	private String convertTypeServiceIdToName(int id){
		if (id == 0)
			return "Preventiva";
		if (id == 1)
			return "Corretiva";
		return "";
	}
	
	private int convertTypeServiceToId(String typeService){
		if (typeService.equals("Preventiva"))
			return 0;
		if (typeService.equals("Corretiva"))
			return 1;
		return -1;
	}
	
	
	public DefaultTableModel getModelList() {
		
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("Id");
		model.addColumn("Data");
		model.addColumn("Máquina");
		model.addColumn("Técnico");
		model.addColumn("Tipo");
		
		for (OrderServiceDAOBusinessData orderService : orderServiceData.getList()) {
			model.addRow(
					new Object[] {
							orderService.getId(),
							Utils.convertDayMonthYearToDateString(orderService.getDay(), orderService.getMonth(), orderService.getYear(), true),
							equipmentBusiness.get(orderService.getEquipment()).getName(),
							technicianBusiness.get(orderService.getTechnician()).getName(),
							convertTypeServiceIdToName(orderService.getTypeService())
					}
			);
		}
		
		return model;
	}
	
	public DefaultTableModel getMeanTimeRepairModel() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Tempo Médio (horas)");
		
		for (MeanTimeRepairDAOBusinessData equipmentRepair : orderServiceData.getMeanTimeRepairs()) {
			tableModel.addRow(new Object[] {
					equipmentRepair.getId(), 
					equipmentRepair.getName(),
					equipmentRepair.getHour()
					});
		}
		
		return tableModel;
	}
	
	public DefaultTableModel getStopTimeModel() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Tempo Total (horas)");
		
		for (MeanTimeRepairDAOBusinessData equipmentStopTime : orderServiceData.getStopTime()) {
			tableModel.addRow(new Object[] {
					equipmentStopTime.getId(), 
					equipmentStopTime.getName(),
					equipmentStopTime.getHour()
					});
		}
		
		return tableModel;
	}
	
	public DefaultTableModel getCostRepairModel() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Custo Total (R$)");
		
		for (MeanTimeRepairDAOBusinessData equipmentCostRepair : orderServiceData.getCostRepair()) {
			tableModel.addRow(new Object[] {
					equipmentCostRepair.getId(), 
					equipmentCostRepair.getName(),
					equipmentCostRepair.getHour()
					});
		}
		
		return tableModel;
	}
	
	@Override
	public List<OrderServiceDAOPresentationBusiness> getList() {
		//return dados.getList();
		return null;
	}
	
	private OrderServiceDAOPresentationBusiness convertDAOOrderServiceDataToPresentation(OrderServiceDAOBusinessData data) {
		orderServiceDAO = new OrderServiceDAOPresentationBusiness();
		
		String date = Utils.convertDayMonthYearToDateString(data.getDay(), data.getMonth(),data.getYear(), false);
		String startTime = Utils.ConvertToTimeStringWithoutMask(data.getStartHour(), data.getStartMinute());
		String endTime = Utils.ConvertToTimeStringWithoutMask(data.getEndHour(),data.getEndMinute());
		
		
		orderServiceDAO.setDate(date);
		orderServiceDAO.setDescription(data.getDescription());
		orderServiceDAO.setEndTime(endTime);
		orderServiceDAO.setStartTime(startTime);
		orderServiceDAO.setId(data.getId());
		orderServiceDAO.setEquipment(equipmentBusiness.get(data.getEquipment()).getName());
		orderServiceDAO.setTechinician(technicianBusiness.get(data.getTechnician()).getName());
		orderServiceDAO.setTypeService(convertTypeServiceIdToName(data.getTypeService()));
		
		return orderServiceDAO;
	}

	@Override
	public OrderServiceDAOPresentationBusiness get(int id) {
		if(!super.isValidId(id)) {
			feedbackMessage = "Id inválido";
			return null;
		}
			
		return convertDAOOrderServiceDataToPresentation(orderServiceData.get(id));
	}
	
	private int getDay(String date) {
		return Integer.parseInt(date.substring(0,2));
	}
	
	private int getMonth(String date) {
		return Integer.parseInt(date.substring(3,5));
	}
	
	private int getYear(String date) {
		return Integer.parseInt(date.substring(6,10));
	}
	
	private int getMinute(String time) {
		return Integer.parseInt(time.substring(3,5));
	}
	
	private int getHour(String time) {
		return Integer.parseInt(time.substring(0,2));
	}
	
	
	
	private OrderServiceDAOBusinessData convertDAOPresentationToDAOData(OrderServiceDAOPresentationBusiness orderServiceBusiness) {
		int id = orderServiceBusiness.getId();
		
		
		int day = getDay(orderServiceBusiness.getDate());
		int month = getMonth(orderServiceBusiness.getDate());
		int year = getYear(orderServiceBusiness.getDate());
		
		int startHour = getHour(orderServiceBusiness.getStartTime());
		int startMinute = getMinute(orderServiceBusiness.getStartTime());
		int endHour = getHour(orderServiceBusiness.getEndTime());
		int endMinute = getMinute(orderServiceBusiness.getEndTime());
		int equipment = equipmentBusiness.getByName(orderServiceBusiness.getEquipment()).getId();
		int technician = technicianBusiness.getByName(orderServiceBusiness.getTechinician()).getId();
		String description = orderServiceBusiness.getDescription();
		int idtypeService = convertTypeServiceToId(orderServiceBusiness.getTypeService());
		
		OrderServiceDAOBusinessData DAOData = 
				new OrderServiceDAOBusinessData(
						id, 
						day,
						month,
						year,
						startHour,
						startMinute,
						endHour,
						endMinute,
						equipment,
						technician, 
						description, 
						idtypeService);
		return DAOData;
		
		
	}
	
	private boolean hasPendencies(OrderServiceDAOPresentationBusiness orderService) {
		feedbackMessage = "";
		
		if (orderService.getDate().trim().length() == 0)
			feedbackMessage = "Informar a data da ordem de serviço.";
		else if (orderService.getStartTime().trim().length() <= 0) 
			feedbackMessage = "Informar o horário de início.";
		else if (orderService.getEndTime().trim().length() <= 0) 
			feedbackMessage = "Informar o horário fim.";
		else if (orderService.getEquipment().trim().length() <= 0) 
			feedbackMessage = "Informar a máquina.";
		else if (orderService.getTechinician().trim().length() <= 0) 
			feedbackMessage = "Informar o técnico.";
		else if (orderService.getTypeService().trim().length() <= 0) 
			feedbackMessage = "Informar o tipo de serviço.";
		else if (orderService.getDescription().trim().length() == 0)
			feedbackMessage = "Informar a descrição do serviço.";
		else if (Utils.isTime1GreaterThanTime2(orderService.getStartTime(),orderService.getEndTime()))
			feedbackMessage = "Informar o horário fim deve ser posterior ao horário de início.";
		
		
		if (feedbackMessage.length() > 0) {
			return true;
		}
		
		return false;	
	}

	@Override
	public boolean save(OrderServiceDAOPresentationBusiness orderService) {
		if (hasPendencies(orderService)) {
			return false;
		}
		
		try {
			orderServiceData.save(convertDAOPresentationToDAOData(orderService));
		}catch(Exception e) {
			feedbackMessage = e.getMessage();
    		return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		orderServiceData.delete(id);
		
	}
}
