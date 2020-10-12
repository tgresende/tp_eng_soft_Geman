package business;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.OrderServiceData;
import dataAccessObjectPresentationBusiness.OrderServiceObjAccessData;

public class OrderServiceLogic implements IGenericBusiness<OrderServiceObjAccessData> {

	OrderServiceObjAccessData orderService;
	OrderServiceData dados = new OrderServiceData(sqllConnection.dbConnector());
	
	public OrderServiceLogic() {
		
	}
	
	public OrderServiceLogic(int idP, int dayP, int monthP, int yearP, int startHourP,
			  				 int startMinuteP, int endHourP, int endMinuteP, 
			  				 int idEquipmentP, int idTechinicanP, String descriptionP, 
			  				 int typeServiceP) {
		orderService = new OrderServiceObjAccessData( idP,  dayP,  monthP,  yearP, 
											 startHourP, startMinuteP,  endHourP, 
											 endMinuteP, idEquipmentP,  idTechinicanP, 
											 descriptionP,  typeServiceP);
		
	}
	
	public DefaultTableModel getModelList() {
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("Id");
		model.addColumn("day");
		model.addColumn("month");
		model.addColumn("year");
		model.addColumn("startHour");
		model.addColumn("startMinute");
		model.addColumn("endHour");
		model.addColumn("endMinute");
		model.addColumn("idEquipment");
		model.addColumn("idTechinican");
		model.addColumn("description");
		model.addColumn("typeService");
		
		for (OrderServiceObjAccessData orderService : dados.getList()) {
			model.addRow(
					new Object[] {
							orderService.getId(),
							orderService.getDay(),
							orderService.getMonth(),
							orderService.getYear(),
							orderService.getStartHour(),
							orderService.getStartMinute(),
							orderService.getEndHour(),
							orderService.getEndMinute(),
							orderService.getIdEquipment(),
							orderService.getIdTechinican(),
							orderService.getDescription(),
							orderService.getTypeService()
							}
			);
			//JOptionPane.showMessageDialog(null, orderService.getId());
		}
		
		return model;
	}
	
	
	
	@Override
	public List<OrderServiceObjAccessData> getList() {
		return dados.getList();
	}

	@Override
	public OrderServiceObjAccessData get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		dados.delete(id);
		
	}
}
