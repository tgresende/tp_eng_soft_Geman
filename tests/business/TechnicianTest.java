package business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.junit.Test;
import org.mockito.Mockito;
import data.TechnicianData;
import dataAccessObjectBusinessData.TechnicianDAOBusinessData;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianTest {
	
	
	TechnicianBusiness techBuss;
	TechnicianDAOPresentationBusiness DAOPresesentation;
	TechnicianDAOBusinessData data;
	
	
	@Test
	public void testhasPendenciesWithoutPendencies(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Eletricista","teste",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, true);
		assertEquals(techBuss.feedbackMessage, "");
	}
	
	@Test
	public void testhasPendenciesWithoutPendenciesMechanicist(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Mecânico","teste",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, true);
		assertEquals(techBuss.feedbackMessage, "");
	}
	
	@Test
	public void testhasPendenciesWithoutPendenciesNew(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(false);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(0,"Mecânico","teste",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, true);
		assertEquals(techBuss.feedbackMessage, "");
	}
	
	@Test
	public void testDelete(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(false);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		int id = 10;
		// When I do...
		techBuss.delete(id);
		
		// I Expect... no throw error
	}
	
	@Test
	public void testDeleteIdZero(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(false);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		int id = 0;
		// When I do...
		techBuss.delete(id);
		
		// I Expect... no throw error
	}
	
	
	@Test
	public void testhasPendenciesWithRolePendency(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(false);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"","teste",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(techBuss.feedbackMessage, "Informar o cargo do técnico.");
	}
	
	@Test
	public void testhasPendenciesWithNamePendency(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(false);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Mecânico","",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(techBuss.feedbackMessage, "Informar o nome do técnico.");
	}
	
	@Test
	public void testHasPendenciesWithPricePendency(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(false);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Eletricista","José",0.0);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(techBuss.feedbackMessage, "Informar um valor de hora do técnico maior que zero.");
	}
	
	@Test
	public void testHasPendenciesWithNegativePricePendency(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(false);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Eletricista","João",-10.0);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(techBuss.feedbackMessage, "Informar um valor de hora do técnico maior que zero.");
	}
	
	@Test
	public void testGetAvaliableRoles(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		java.util.List<Integer> returnList = new ArrayList<Integer>();
		returnList.add(0);
		returnList.add(1);
		returnList.add(2);
		
		Mockito.when(dataMock.getAvaliableRoles()).thenReturn(returnList);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		String[] list;
		
		// When I do...
		list = techBuss.getAvaliableRoles();
		
		// I Expect...
		assertEquals(list[0], "Eletricista");
		assertEquals(list[1], "Mecânico");
		assertEquals(list[2], "");
		assertEquals(list.length, 3);
	}

	
	@Test
	public void testGetAvaliableTechnicians(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		
		java.util.List<String> returnList = new ArrayList<String>();
		returnList.add("teste");
		returnList.add("João do Zé");
		returnList.add("zé");
		
		Mockito.when(dataMock.getAvaliableTechnicians()).thenReturn(returnList);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		// When I have...
		String[] list;
		
		// When I do...
		list = techBuss.getAvaliableTechnicians();
		
		// I Expect...
		assertEquals(list[0], "teste");
		assertEquals(list[1], "João do Zé");
		assertEquals(list[2], "zé");
		assertEquals(list.length, 3);
	}
	
	@Test
	public void testGetModelList(){
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Cargo");
		
		tableModel.addRow(new Object[]{
				1, 
				"Teste",
				"Eletricista"
				});
		
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		java.util.List<TechnicianDAOBusinessData> returnList = new ArrayList<TechnicianDAOBusinessData>();
		returnList.add(new TechnicianDAOBusinessData(1,0,"Teste",10.5));
		
		Mockito.when(dataMock.getList()).thenReturn(returnList);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		
			
		// When I do...
		DefaultTableModel modelList = techBuss.getModelList();
		
		// I Expect...
		assertEquals(modelList.getRowCount(), tableModel.getRowCount());
		assertEquals(modelList.getColumnCount(), tableModel.getColumnCount());
		assertEquals(modelList.findColumn("Id"), tableModel.findColumn("Id"));
		assertEquals(modelList.findColumn("Nome"), tableModel.findColumn("Nome"));
		assertEquals(modelList.findColumn("Cargo"), tableModel.findColumn("Cargo"));
	}
	
	
	@Test
	public void testGetList(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		java.util.List<TechnicianDAOBusinessData> returnList = new ArrayList<TechnicianDAOBusinessData>();
		returnList.add(new TechnicianDAOBusinessData(1,0,"Teste",10.5));
		
		Mockito.when(dataMock.getList()).thenReturn(returnList);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		
		List<TechnicianDAOPresentationBusiness> myList = new ArrayList<TechnicianDAOPresentationBusiness>();
		myList.add(new TechnicianDAOPresentationBusiness(1, "Eletricista", "Teste",10.5));
		
		// When I do...
		List<TechnicianDAOPresentationBusiness> returnListFromData = techBuss.getList();
		
		// I Expect...
		assertEquals(returnListFromData.get(0).getId(), myList.get(0).getId());
		assertEquals(returnListFromData.get(0).getHourPrice(), myList.get(0).getHourPrice());
		assertEquals(returnListFromData.get(0).getName(), myList.get(0).getName());
		assertEquals(returnListFromData.get(0).getRole(), myList.get(0).getRole());
		
	}
	
	@Test
	public void testGet(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		TechnicianDAOBusinessData returnDAO = new TechnicianDAOBusinessData(1,0,"Teste",10.5);
		
		Mockito.when(dataMock.get(1)).thenReturn(returnDAO);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		
		TechnicianDAOPresentationBusiness DAOpresentation = new TechnicianDAOPresentationBusiness(1, "Eletricista", "Teste",10.5);
		
		// When I do...
		TechnicianDAOPresentationBusiness returnFromBusiness = techBuss.get(1);
		
		// I Expect...
		assertEquals(returnFromBusiness.getId(), DAOpresentation.getId());
		assertEquals(returnFromBusiness.getHourPrice(), DAOpresentation.getHourPrice());
		assertEquals(returnFromBusiness.getName(), DAOpresentation.getName());
		assertEquals(returnFromBusiness.getRole(), DAOpresentation.getRole());
		
	}
	
	@Test
	public void testGetByName(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		TechnicianDAOBusinessData returnDAO = new TechnicianDAOBusinessData(1,0,"Teste",10.5);
		
		Mockito.when(dataMock.getByName("Teste")).thenReturn(returnDAO);
		TechnicianBusiness techBuss = new TechnicianBusiness(dataMock);
		
		TechnicianDAOPresentationBusiness DAOpresentation = new TechnicianDAOPresentationBusiness(1, "Eletricista", "Teste",10.5);
		
		// When I do...
		TechnicianDAOPresentationBusiness returnFromBusiness = techBuss.getByName("Teste");
		
		// I Expect...
		assertEquals(returnFromBusiness.getId(), DAOpresentation.getId());
		assertEquals(returnFromBusiness.getHourPrice(), DAOpresentation.getHourPrice());
		assertEquals(returnFromBusiness.getName(), DAOpresentation.getName());
		assertEquals(returnFromBusiness.getRole(), DAOpresentation.getRole());
		
	}
	 
}
