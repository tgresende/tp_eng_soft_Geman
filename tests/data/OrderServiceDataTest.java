package data;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import dataAccessObjectBusinessData.MeanTimeRepairDAOBusinessData;
import dataAccessObjectBusinessData.OrderServiceDAOBusinessData;

public class OrderServiceDataTest {

	
	public static java.sql.Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tulio\\Desktop\\Eng Software\\tests_environment.db");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	 
	 

	 @Test
	 public void testGetList() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 List<OrderServiceDAOBusinessData> mylist = new ArrayList<OrderServiceDAOBusinessData>();
		 mylist.add(new OrderServiceDAOBusinessData(3,1,1,2020,8,0,8,55,1,2,"limpeza de bico",0));
		 
		 List<OrderServiceDAOBusinessData> returnList = data.getList();
		 
		 assertEquals(returnList.get(0).getId(), mylist.get(0).getId());
		 assertEquals(returnList.get(0).getDay(), mylist.get(0).getDay());
		 assertEquals(returnList.get(0).getDescription(), mylist.get(0).getDescription());
		 assertEquals(returnList.get(0).getEndHour(), mylist.get(0).getEndHour());
		 assertEquals(returnList.get(0).getEndMinute(), mylist.get(0).getEndMinute());
		 assertEquals(returnList.get(0).getEquipment(), mylist.get(0).getEquipment());
		 assertEquals(returnList.get(0).getMonth(), mylist.get(0).getMonth());
		 assertEquals(returnList.get(0).getStartHour(), mylist.get(0).getStartHour());
		 assertEquals(returnList.get(0).getStartMinute(), mylist.get(0).getStartMinute());
		 assertEquals(returnList.get(0).getEndHour(), mylist.get(0).getEndHour());
		 assertEquals(returnList.get(0).getEndMinute(), mylist.get(0).getEndMinute());
		 assertEquals(returnList.get(0).getTechnician(), mylist.get(0).getTechnician());
		 assertEquals(returnList.get(0).getTypeService(), mylist.get(0).getTypeService());
	 }
	 
	 @Test
	 public void testGet() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 OrderServiceDAOBusinessData myDao = new OrderServiceDAOBusinessData(3,1,1,2020,8,0,8,55,1,2,"limpeza de bico",0);
		 
		 OrderServiceDAOBusinessData returnDao = data.get(3);
		 
		 assertEquals(returnDao.getId(), myDao.getId());
		 assertEquals(returnDao.getDay(), myDao.getDay());
		 assertEquals(returnDao.getDescription(), myDao.getDescription());
		 assertEquals(returnDao.getEndHour(), myDao.getEndHour());
		 assertEquals(returnDao.getEndMinute(), myDao.getEndMinute());
		 assertEquals(returnDao.getEquipment(), myDao.getEquipment());
		 assertEquals(returnDao.getMonth(), myDao.getMonth());
		 assertEquals(returnDao.getStartHour(), myDao.getStartHour());
		 assertEquals(returnDao.getStartMinute(), myDao.getStartMinute());
		 assertEquals(returnDao.getEndHour(), myDao.getEndHour());
		 assertEquals(returnDao.getEndMinute(), myDao.getEndMinute());
		 assertEquals(returnDao.getTechnician(), myDao.getTechnician());
		 assertEquals(returnDao.getTypeService(), myDao.getTypeService());
	 }
	 

	 @Test
	 public void testGetTimeToRepairs() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 List<MeanTimeRepairDAOBusinessData> mylist = new ArrayList<MeanTimeRepairDAOBusinessData>();
		 mylist.add(new MeanTimeRepairDAOBusinessData(3,"Maquina",10.0));
		 
		 List<MeanTimeRepairDAOBusinessData> returnList = data.getMeanTimeRepairs();
		 
		 
		 assertEquals(returnList.getClass() , mylist.getClass());
	 }
	 
	 @Test
	 public void testGetStopTime() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 List<MeanTimeRepairDAOBusinessData> mylist = new ArrayList<MeanTimeRepairDAOBusinessData>();
		 mylist.add(new MeanTimeRepairDAOBusinessData(3,"Maquina",10.0));
		 
		 List<MeanTimeRepairDAOBusinessData> returnList = data.getStopTime();
		 
		 assertEquals(returnList.getClass() , mylist.getClass());
	 }
	 
	 @Test
	 public void testGetCostRepair() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 List<MeanTimeRepairDAOBusinessData> mylist = new ArrayList<MeanTimeRepairDAOBusinessData>();
		 mylist.add(new MeanTimeRepairDAOBusinessData(3,"Maquina",10.0));
		 
		 List<MeanTimeRepairDAOBusinessData> returnList = data.getCostRepair();
		 
		 assertEquals(returnList.getClass() , mylist.getClass());
	 }
	 
	 @Test
	 public void testSaveUpdate() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 OrderServiceDAOBusinessData myDao = new OrderServiceDAOBusinessData(3,1,1,2020,8,0,8,55,1,2,"limpeza de bico",0);
		 
		 boolean result = data.save(myDao);
		 
		 assertEquals(result,true);
	 }
	 
	 @Test
	 public void testSaveInsert() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 OrderServiceDAOBusinessData myDao = new OrderServiceDAOBusinessData(0,2,2,2020,8,0,8,55,2,2,"testebico",0);
		 
		 boolean result = data.save(myDao);
		 
		 assertEquals(result,true);
	 }
	 
	 @Test
	 public void testdelete() {
		 OrderServiceData data = new OrderServiceData(dbConnector());
		 
		 data.delete(10);
		 
	 }
	 
	 
	 
	 
}
