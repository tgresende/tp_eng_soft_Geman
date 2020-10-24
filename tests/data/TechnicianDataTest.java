package data;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import dataAccessObjectBusinessData.TechnicianDAOBusinessData;

public class TechnicianDataTest {

	public static java.sql.Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			String path = System.getProperty("user.dir");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+path+"\\tests_environment.db");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	 
	 

	 @Test
	 public void testGetAvaliableRoles() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 List<Integer> mylist = new ArrayList<Integer>();
		 mylist.add(0);
		 mylist.add(1);
		 
		 List<Integer> returnList = data.getAvaliableRoles();
		 
		 assertEquals(returnList, mylist);
	 }
	 
	 @Test
	 public void testGetAvaliableTechnicians() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 List<String> mylist = new ArrayList<String>();
		 mylist.add("teste");
		 mylist.add("tete");
		 mylist.add("testedeinsert");
		 
		 List<String> returnList = data.getAvaliableTechnicians();
		 
		 assertEquals(returnList, mylist);
	 }
	 
	 @Test
	 public void testGetList() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 List<TechnicianDAOBusinessData> mylist = new ArrayList<TechnicianDAOBusinessData>();
		 mylist.add(new TechnicianDAOBusinessData(1,0,"teste",10.8));
		 
		 List<TechnicianDAOBusinessData> returnList = data.getList();
		 
		 assertEquals(returnList.get(0).getId(), mylist.get(0).getId());
		 assertEquals(returnList.get(0).getHourPrice(), mylist.get(0).getHourPrice());
		 assertEquals(returnList.get(0).getRole(), mylist.get(0).getRole());
		 assertEquals(returnList.get(0).getName(), mylist.get(0).getName());
	 }
	 
	 @Test
	 public void testGet() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 TechnicianDAOBusinessData myDao = new TechnicianDAOBusinessData(1,0,"teste",10.8);
		 
		 TechnicianDAOBusinessData returnDao = data.get(1);
		 
		 assertEquals(returnDao.getId(), myDao.getId());
		 assertEquals(returnDao.getHourPrice(), myDao.getHourPrice());
		 assertEquals(returnDao.getRole(), myDao.getRole());
		 assertEquals(returnDao.getName(), myDao.getName());
	 }
	 
	 @Test
	 public void testGetByName() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 TechnicianDAOBusinessData myDao = new TechnicianDAOBusinessData(1,0,"teste",10.8);
		 
		 TechnicianDAOBusinessData returnDao = data.getByName("teste");
		 
		 assertEquals(returnDao.getId(), myDao.getId());
		 assertEquals(returnDao.getHourPrice(), myDao.getHourPrice());
		 assertEquals(returnDao.getRole(), myDao.getRole());
		 assertEquals(returnDao.getName(), myDao.getName());
	 }
	 
	 
	 @Test
	 public void testSaveUpdate() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 TechnicianDAOBusinessData myDao = new TechnicianDAOBusinessData(1,0,"teste",10.8);
		 
		 boolean result = data.save(myDao);
		 
		 assertEquals(result,  true);
	 }
	 
	 
	 @Test
	 public void testSaveInsert() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 TechnicianDAOBusinessData myDao = new TechnicianDAOBusinessData(0,0,"testedeinsert",10.8);
		 
		 boolean result = data.save(myDao);
		 
		 assertEquals(result,  true);
	 }
	 
	
	
	 
	 @Test
	 public void testDelete() {
		 TechnicianData data = new TechnicianData(dbConnector());
		 data.delete(3);
	 }
}
