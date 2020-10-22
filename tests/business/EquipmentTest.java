package business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.junit.Test;
import org.mockito.Mockito;

import data.EquipmentData;
import dataAccessObjectBusinessData.EquipmentDAOBusinessData;
import dataAccessObjectPresentationBusiness.EquipmentDAOPresentationBusiness;

public class EquipmentTest {

	EquipmentDAOPresentationBusiness DAOPresesentation;
	EquipmentDAOBusinessData DaoData;
	
	@Test
	public void testgetAvaliableEquipments(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		java.util.List<String> returnList = new ArrayList<String>();
		returnList.add("Forno");
		returnList.add("Motor");
		
		Mockito.when(dataMock.getAvaliableEquipments()).thenReturn(returnList);
		EquipmentBusiness equipBuss = new EquipmentBusiness(dataMock);
		// When I have...
		String[] list;
		
		// When I do...
		list = equipBuss.getAvaliableEquipments();
		
		// I Expect...
		assertEquals(list[0], "Forno");
		assertEquals(list[1], "Motor");
		assertEquals(list.length, 2);
	}

	
	@Test
	public void testEquipmentBusiness(){
		EquipmentBusiness equipBuss = new EquipmentBusiness(1,"Forno", "1230", "aaabb");
		// When I have...
		EquipmentDAOPresentationBusiness daoPresentation = new 								EquipmentDAOPresentationBusiness(1,"Forno", "1230", "aaabb");
		
		// When I do...
		EquipmentDAOPresentationBusiness daoReturn = equipBuss.equipmentDAO;
		
		// I Expect...
		assertEquals(daoReturn.getId(), daoPresentation.getId());
		assertEquals(daoReturn.getManufacturer(), daoPresentation.getManufacturer());
		assertEquals(daoReturn.getModel(), daoPresentation.getModel());
		assertEquals(daoReturn.getName(), daoPresentation.getName());
	}
	
	@Test
	public void testGetModelList(){
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Modelo");
		tableModel.addColumn("Fabricante");
		
		tableModel.addRow(new Object[]{
				1, 
				"forno",
				"modelo x",
				"fabricnte 2"
				});
		
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		java.util.List<EquipmentDAOBusinessData> returnList = new ArrayList<EquipmentDAOBusinessData>();
		
		returnList.add(new EquipmentDAOBusinessData(1,"forno","modelo x","fabricnte 2"));
		
		Mockito.when(dataMock.getList()).thenReturn(returnList);
		EquipmentBusiness equipBuss = new EquipmentBusiness(dataMock);
		
			
		// When I do...
		DefaultTableModel modelList = equipBuss.getModelList();
		
		// I Expect...
		assertEquals(modelList.getRowCount(), tableModel.getRowCount());
		assertEquals(modelList.getColumnCount(), tableModel.getColumnCount());
		assertEquals(modelList.findColumn("Id"), tableModel.findColumn("Id"));
		assertEquals(modelList.findColumn("Nome"), tableModel.findColumn("Nome"));
		assertEquals(modelList.findColumn("Modelo"), tableModel.findColumn("Modelo"));
		assertEquals(modelList.findColumn("Fabricante"), tableModel.findColumn("Fabricante"));
	}
	
	@Test
	public void testGetList(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		java.util.List<EquipmentDAOBusinessData> returnList = new ArrayList<EquipmentDAOBusinessData>();
		returnList.add(new EquipmentDAOBusinessData(1,"forno","modelo x","fabricnte 2"));
		
		Mockito.when(dataMock.getList()).thenReturn(returnList);
		EquipmentBusiness equipmentBuss = new EquipmentBusiness(dataMock);
		
		List<EquipmentDAOPresentationBusiness> myList = new ArrayList<EquipmentDAOPresentationBusiness>();
		myList.add(new EquipmentDAOPresentationBusiness(1,"forno","modelo x","fabricnte 2"));
		
		// When I do...
		List<EquipmentDAOPresentationBusiness> returnListFromData = equipmentBuss.getList();
		
		// I Expect...
		assertEquals(returnListFromData.get(0).getId(), myList.get(0).getId());
		assertEquals(returnListFromData.get(0).getManufacturer(), myList.get(0).getManufacturer());
		assertEquals(returnListFromData.get(0).getName(), myList.get(0).getName());
		assertEquals(returnListFromData.get(0).getModel(), myList.get(0).getModel());
		
	}
	
	@Test
	public void testGet(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		EquipmentDAOBusinessData returnDAO = new EquipmentDAOBusinessData(1,"forno","modelo x","fabricnte 2");
		
		Mockito.when(dataMock.get(1)).thenReturn(returnDAO);
		EquipmentBusiness equipmentBuss = new EquipmentBusiness(dataMock);
		
		EquipmentDAOPresentationBusiness DAOpresentation = new EquipmentDAOPresentationBusiness(1,"forno","modelo x","fabricnte 2");
		
		// When I do...
		EquipmentDAOPresentationBusiness returnFromBusiness = equipmentBuss.get(1);
		
		// I Expect...
		assertEquals(returnFromBusiness.getId(), DAOpresentation.getId());
		assertEquals(returnFromBusiness.getManufacturer(), DAOpresentation.getManufacturer());
		assertEquals(returnFromBusiness.getName(), DAOpresentation.getName());
		assertEquals(returnFromBusiness.getModel(), DAOpresentation.getModel());
	}
	
	@Test
	public void testGetByName(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		EquipmentDAOBusinessData returnDAO = new EquipmentDAOBusinessData(1,"forno","modelo x","fabricnte 2");
		
		Mockito.when(dataMock.getByName("Teste")).thenReturn(returnDAO);
		EquipmentBusiness equipmentBuss = new EquipmentBusiness(dataMock);
		
		EquipmentDAOPresentationBusiness DAOpresentation = new EquipmentDAOPresentationBusiness(1,"forno","modelo x","fabricnte 2");
		
		// When I do...
		EquipmentDAOPresentationBusiness returnFromBusiness = equipmentBuss.getByName("Teste");
		
		// I Expect...
		assertEquals(returnFromBusiness.getId(), DAOpresentation.getId());
		assertEquals(returnFromBusiness.getManufacturer(), DAOpresentation.getManufacturer());
		assertEquals(returnFromBusiness.getName(), DAOpresentation.getName());
		assertEquals(returnFromBusiness.getModel(), DAOpresentation.getModel());
		
	}
	
	
	@Test
	public void testhasPendenciesWithoutPendencies(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		Mockito.when(dataMock.save(DaoData)).thenReturn(true);
		EquipmentBusiness equipBuss = new EquipmentBusiness(dataMock);
		// When I have...
		DAOPresesentation = new EquipmentDAOPresentationBusiness(1,"forno","modelo x","fabricnte 2");
		
		// When I do...
		boolean result = equipBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
	}
	
	@Test
	public void testhasPendenciesWithNamePendencies(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		Mockito.when(dataMock.save(DaoData)).thenReturn(true);
		EquipmentBusiness equipBuss = new EquipmentBusiness(dataMock);
		// When I have...
		DAOPresesentation = new EquipmentDAOPresentationBusiness(1,"","modelo x","fabricnte 2");
		
		// When I do...
		boolean result = equipBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(equipBuss.feebackMessage, "Informar o nome do equipamento.");
	}
	
	@Test
	public void testhasPendenciesWithModelPendencies(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		Mockito.when(dataMock.save(DaoData)).thenReturn(true);
		EquipmentBusiness equipBuss = new EquipmentBusiness(dataMock);
		// When I have...
		DAOPresesentation = new EquipmentDAOPresentationBusiness(1,"equipamento","","fabricnte 2");
		
		// When I do...
		boolean result = equipBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(equipBuss.feebackMessage, "Informar o modelo do equipamento.");
	}
	
	@Test
	public void testhasPendenciesWithManufacturerPendencies(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		Mockito.when(dataMock.save(DaoData)).thenReturn(true);
		EquipmentBusiness equipBuss = new EquipmentBusiness(dataMock);
		// When I have...
		DAOPresesentation = new EquipmentDAOPresentationBusiness(1,"equipamento","modelo","");
		
		// When I do...
		boolean result = equipBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(equipBuss.feebackMessage, "Informar o fabricante do equipamento.");
	}
	
	@Test
	public void testhasPendenciesWithDataPendencies(){
		EquipmentData dataMock = Mockito.mock(EquipmentData.class);
		Mockito.when(dataMock.save(DaoData)).thenReturn(false);
		Mockito.when(dataMock.getFeedbackMessage()).thenReturn("erro de banco de dados");
		EquipmentBusiness equipBuss = new EquipmentBusiness(dataMock);
		// When I have...
		DAOPresesentation = new EquipmentDAOPresentationBusiness(1,"equipamento","modelo","fabricate");
		
		// When I do...
		boolean result = equipBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
		assertEquals(equipBuss.feebackMessage, "erro de banco de dados");
	}
}
