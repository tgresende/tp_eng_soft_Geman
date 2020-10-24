package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataAccessObjectBusinessData.MeanTimeRepairDAOBusinessData;
import dataAccessObjectBusinessData.OrderServiceDAOBusinessData;
import dataInterface.IGenericDados;

public class OrderServiceData implements IGenericDados<OrderServiceDAOBusinessData>{
	
	private Connection connection=null;
	
	public OrderServiceData(Connection conn) {
		connection = conn;
	}

	@Override
	public List<OrderServiceDAOBusinessData> getList() {
		String query = "Select * from OrderService";
		PreparedStatement pst = null;
		ResultSet res = null;
		List<OrderServiceDAOBusinessData> orderServices = new ArrayList<OrderServiceDAOBusinessData>();
		
		try {
			pst = connection.prepareStatement(query);
			res = pst.executeQuery();
					
			while(res.next()) {
			OrderServiceDAOBusinessData orderService =
						new OrderServiceDAOBusinessData(
								res.getInt("Id"),
								res.getInt("day"),
								res.getInt("month"),
								res.getInt("year"),
								res.getInt("startHour"),
								res.getInt("startMinute"),
								res.getInt("endHour"),
								res.getInt("endMinute"),
								res.getInt("idEquipment"),
								res.getInt("idTechnician"),
								res.getString("description"),
								res.getInt("typeService"));
				orderServices.add(orderService);
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
			
		}
		
		return orderServices;
	}

	@Override
	public OrderServiceDAOBusinessData get(int id) {
		String query = "Select * from OrderService where id =?";
		OrderServiceDAOBusinessData orderService = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			res = pst.executeQuery();
					
			while(res.next()) {
			orderService = 	new OrderServiceDAOBusinessData(
								res.getInt("Id"),
								res.getInt("day"),
								res.getInt("month"),
								res.getInt("year"),
								res.getInt("startHour"),
								res.getInt("startMinute"),
								res.getInt("endHour"),
								res.getInt("endMinute"),
								res.getInt("idEquipment"),
								res.getInt("idTechnician"),
								res.getString("description"),
								res.getInt("typeService"));
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
			
		}
		
		return orderService;
	}
	
	public List<MeanTimeRepairDAOBusinessData> getMeanTimeRepairs() {
		String query = 
				" select idEquipment, round(avg(hour),2) hour, Equipment.name name from ( "+
						" Select idEquipment, round((round(endHour*60 + endMinute,2)  - round(startHour*60 + startMinute,2))/60,2) hour from OrderService "+
						" ) orderService join Equipment on Equipment.id = orderService.idEquipment group by idEquipment"; 
		
		List<MeanTimeRepairDAOBusinessData> equipments = new ArrayList<MeanTimeRepairDAOBusinessData>();
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				equipments.add( new MeanTimeRepairDAOBusinessData(
								   res.getInt("idEquipment"), 
								   res.getString("name"),
								   res.getDouble("hour")
								   )
				);
				
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
		
		return equipments;
	}
	
	public List<MeanTimeRepairDAOBusinessData>  getCostRepair() {
		String query = 
				"select Equipment.id idEquipment, Equipment.name name, sum(costs.cost) totalCost from ( " + 
				"Select idEquipment, idTechnician,round(Technician.hourPrice * round((round(endHour*60 + endMinute,2)  - round(startHour*60 + startMinute,2))/60,2),2) " +
			    "cost from OrderService join Technician on Technician.id = OrderService.idTechnician" + 
				")costs JOIN Equipment on Equipment.id = costs.idEquipment group by Equipment.id, Equipment.name";
		
		List<MeanTimeRepairDAOBusinessData> equipments = new ArrayList<MeanTimeRepairDAOBusinessData>();
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				equipments.add( new MeanTimeRepairDAOBusinessData(
								   res.getInt("idEquipment"), 
								   res.getString("name"),
								   res.getDouble("totalCost")
								   )
				);
				
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
		
		return equipments;
	}
	
	public List<MeanTimeRepairDAOBusinessData>  getStopTime() {
		String query = 
				" select idEquipment, round(sum(hour),2) hour, Equipment.name name from ( "+
						" Select idEquipment, round((round(endHour*60 + endMinute,2)  - round(startHour*60 + startMinute,2))/60,2) hour from OrderService "+
						" ) orderService join Equipment on Equipment.id = orderService.idEquipment group by idEquipment"; 
		
		List<MeanTimeRepairDAOBusinessData> equipments = new ArrayList<MeanTimeRepairDAOBusinessData>();
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				equipments.add( new MeanTimeRepairDAOBusinessData(
								   res.getInt("idEquipment"), 
								   res.getString("name"),
								   res.getDouble("hour")
								   )
				);
				
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
		
		return equipments;
	}

	@Override
	public boolean save(OrderServiceDAOBusinessData orderService) {
		String cmd;
		if (orderService.getId() == 0)
			cmd = " insert into OrderService ("
					+ " day, "
					+ " month, "
					+ " year, "
					+ " startHour,"
					+ " startMinute,"
					+ " endHour,"
					+ " endMinute,"
					+ " idEquipment,"
					+ " idTechnician,"
					+ " description,"
					+ " typeService"
					+ ") values ("
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?)";
		else
			cmd = " update OrderService set "
					+ " day = ?, "
					+ " month = ?, "
					+ " year = ?, "
					+ " startHour = ?,"
					+ " startMinute = ?,"
					+ " endHour = ?,"
					+ " endMinute = ?,"
					+ " idEquipment = ?,"
					+ " idTechnician = ?,"
					+ " description = ?,"
					+ " typeService = ?"
				  +" where Id=?";
		try {
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setInt(1, orderService.getDay());
			pst.setInt(2, orderService.getMonth());
			pst.setInt(3, orderService.getYear());
			pst.setInt(4, orderService.getStartHour());
			pst.setInt(5, orderService.getStartMinute());
			pst.setInt(6, orderService.getEndHour());
			pst.setInt(7, orderService.getEndMinute());
			pst.setInt(8, orderService.getEquipment());
			pst.setInt(9, orderService.getTechnician());
			pst.setString(10, orderService.getDescription());
			pst.setInt(11, orderService.getTypeService());

			
		if (orderService.getId() != 0)
			pst.setInt(12, orderService.getId());
		
			pst.executeUpdate();
			pst.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}
		return true;
		
	}

	@Override
	public void delete(int id) {
		String cmd = "delete from OrderService where Id=?";
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
