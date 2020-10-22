package data;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import dataAccessObjectBusinessData.EquipmentDAOBusinessData;


public class EquipmentDataTest {
	
	
	
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
	 public void testGetAvaliableEquipments() {
		 EquipmentData data = new EquipmentData(dbConnector());
		 List<String> mylist = new ArrayList<String>();
		 mylist.add("m�quina de solda");
		 
		 List<String> returnList = data.getAvaliableEquipments();
		 
		 assertEquals(returnList, mylist);
	 }
	 
	 @Test
	 public void testGetList() {
		 EquipmentData data = new EquipmentData(dbConnector());
		 List<EquipmentDAOBusinessData> mylist = new ArrayList<EquipmentDAOBusinessData>();
		 mylist.add(new EquipmentDAOBusinessData(1,"m�quina de solda","sda","dsa"));
		 
		 List<EquipmentDAOBusinessData> returnList = data.getList();
		 
		 assertEquals(returnList.get(0).getId(), mylist.get(0).getId());
		 assertEquals(returnList.get(0).getManufacturer(), mylist.get(0).getManufacturer());
		 assertEquals(returnList.get(0).getModel(), mylist.get(0).getModel());
		 assertEquals(returnList.get(0).getName(), mylist.get(0).getName());
	 }
	 
	 @Test
	 public void testGet() {
		 EquipmentData data = new EquipmentData(dbConnector());
		 EquipmentDAOBusinessData myDao = new EquipmentDAOBusinessData(1,"m�quina de solda","sda","dsa");
		 
		 EquipmentDAOBusinessData returnDao = data.get(1);
		 
		 assertEquals(returnDao.getId(), myDao.getId());
		 assertEquals(returnDao.getManufacturer(), myDao.getManufacturer());
		 assertEquals(returnDao.getModel(), myDao.getModel());
		 assertEquals(returnDao.getName(), myDao.getName());
	 }
	 
	 @Test
	 public void testGetByName() {
		 EquipmentData data = new EquipmentData(dbConnector());
		 EquipmentDAOBusinessData myDao = new EquipmentDAOBusinessData(1,"m�quina de solda","sda","dsa");
		 EquipmentDAOBusinessData returnDao = data.getByName("m�quina de solda");
		 assertEquals(returnDao.getManufacturer(), myDao.getManufacturer());
		 assertEquals(returnDao.getModel(), myDao.getModel());
		 assertEquals(returnDao.getName(), myDao.getName());
	 }
	 
	 @Test
	 public void testSaveUpdate() {
		 EquipmentData data = new EquipmentData(dbConnector());
		 EquipmentDAOBusinessData myDao = new EquipmentDAOBusinessData(1,"m�quina de solda","sda","dsa");
		 boolean result = data.save(myDao);
		 assertEquals(result, true);
	 }
	 
	 @Test
	 public void testSaveInsert() {
		 EquipmentData data = new EquipmentData(dbConnector());
		 EquipmentDAOBusinessData myDao = new EquipmentDAOBusinessData(0,"m�quina de solda","sda","dsa");
		 boolean result = data.save(myDao);
		 assertEquals(result, true);
	 }
	 
	 @Test
	 public void testDelete() {
		 EquipmentData data = new EquipmentData(dbConnector());
		 data.delete(2);
	 }
}
