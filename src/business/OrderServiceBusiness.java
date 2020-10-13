package business;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import businessClass.BusinessGeneric;
import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.OrderServiceData;
import dataAccessObjectBusinessData.OrderServiceDAOBusinessData;
import dataAccessObjectPresentationBusiness.OrderServiceDAOPresentationBusiness;

public class OrderServiceBusiness extends BusinessGeneric implements IGenericBusiness<OrderServiceDAOPresentationBusiness> {

	OrderServiceDAOPresentationBusiness orderServiceDAO;
	EquipmentBusiness equipmentBusiness;
	TechnicianBusiness technicianBusiness;
	OrderServiceData data = new OrderServiceData(sqllConnection.dbConnector());
	
	private void createDependencies() {
		technicianBusiness = new TechnicianBusiness();
		equipmentBusiness = new EquipmentBusiness();	
	}
	
	public OrderServiceBusiness() {
		createDependencies();
			
	}
	
	public OrderServiceBusiness(int idP, int dayP, int monthP, int yearP, int startHourP,
			  				 int startMinuteP, int endHourP, int endMinuteP, 
			  				 int idEquipmentP, int idTechinicanP, String descriptionP, 
			  				 int typeServiceP) {
		orderServiceDAO = new OrderServiceDAOPresentationBusiness( idP,  dayP,  monthP,  yearP, 
											 startHourP, startMinuteP,  endHourP, 
											 endMinuteP, idEquipmentP,  idTechinicanP, 
											 descriptionP,  typeServiceP);
		
		createDependencies();
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
		model.addColumn("M�quina");
		model.addColumn("T�cnico");
		model.addColumn("Tipo");
		
		for (OrderServiceDAOBusinessData orderService : data.getList()) {
			model.addRow(
					new Object[] {
							orderService.getId(),
							Utils.convertDayMonthYearToDateString(orderService.getDay(), orderService.getMonth(), orderService.getYear()),
							equipmentBusiness.get(orderService.getIdEquipment()).getName(),
							technicianBusiness.get(orderService.getIdTechinican()).getRole(),
							convertTypeServiceIdToName(orderService.getTypeService())
					}
			);
		}
		
		return model;
	}
	
	
	
	@Override
	public List<OrderServiceDAOPresentationBusiness> getList() {
		//return dados.getList();
		return null;
	}

	@Override
	public OrderServiceDAOPresentationBusiness get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(OrderServiceDAOPresentationBusiness obj) {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public void delete(int id) {
		data.delete(id);
		
	}
}
