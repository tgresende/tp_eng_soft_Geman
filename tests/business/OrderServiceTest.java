package business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.junit.Test;
import org.mockito.Mockito;

import data.OrderServiceData;
import dataAccessObjectBusinessData.MeanTimeRepairDAOBusinessData;
import dataAccessObjectBusinessData.OrderServiceDAOBusinessData;
import dataAccessObjectPresentationBusiness.EquipmentDAOPresentationBusiness;
import dataAccessObjectPresentationBusiness.OrderServiceDAOPresentationBusiness;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class OrderServiceTest {

	OrderServiceBusiness orderServiceBusiness = new OrderServiceBusiness();
	
	@Test
	public void testGetAvaliableTypeService(){
		List<String> types = new ArrayList<String>();
		types.add("Preventiva");
		types.add("Corretiva");
		String[] list =  types.toArray(new String[0]);
		// when I have...

		// when I do...
		String[] returnList = orderServiceBusiness.getAvaliableTypeService();

		// I expect.
		assertEquals(returnList[0], list[0]);
		assertEquals(returnList[1], list[1]);
		assertEquals(returnList.length, list.length);
		
	}
	
	@Test
	public void testGetModelList(){
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Data");
		tableModel.addColumn("Máquina");
		tableModel.addColumn("Técnico");
		tableModel.addColumn("Tipo");
		
		tableModel.addRow(new Object[]{
				1, 
				"01/01/2020",
				"maquina",
				"joão",
				"Preventiva"
				});
		
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		java.util.List<OrderServiceDAOBusinessData> returnList = new ArrayList<OrderServiceDAOBusinessData>();
		returnList.add(new OrderServiceDAOBusinessData(1,1,1,2020,8,8,9,9,1,1,"teste",0));
		Mockito.when(dataMock.getList()).thenReturn(returnList);

		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		Mockito.when(techMock.get(1)).thenReturn(new TechnicianDAOPresentationBusiness(1, "Eletricista", "joão", 10.5));
		
		
		EquipmentBusiness EquipMock = Mockito.mock(EquipmentBusiness.class);
		Mockito.when(EquipMock.get(1)).thenReturn(new EquipmentDAOPresentationBusiness(1, "maquina", "model", "manufacturer"));
		
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, EquipMock);
		
			
		// When I do...
		DefaultTableModel modelList = orderServiceBuss.getModelList();
		
		// I Expect...
		assertEquals(modelList.getRowCount(), tableModel.getRowCount());
		assertEquals(modelList.getColumnCount(), tableModel.getColumnCount());
		assertEquals(modelList.findColumn("Id"), tableModel.findColumn("Id"));
		assertEquals(modelList.findColumn("Data"), tableModel.findColumn("Data"));
		assertEquals(modelList.findColumn("Máquina"), tableModel.findColumn("Máquina"));
	}
	
	@Test
	public void testGetMeanTimeToRepair(){
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Tempo Médio (horas)");
		
		tableModel.addRow(new Object[]{
				1, 
				"maquina",
				10.0
				});
		
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		java.util.List<MeanTimeRepairDAOBusinessData> returnList = new ArrayList<MeanTimeRepairDAOBusinessData>();
		returnList.add(new MeanTimeRepairDAOBusinessData(1,"teste",10.0));
		Mockito.when(dataMock.getMeanTimeRepairs()).thenReturn(returnList);

		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		// When I do...
		DefaultTableModel modelList = orderServiceBuss.getMeanTimeRepairModel();
		
		// I Expect...
		assertEquals(modelList.getRowCount(), tableModel.getRowCount());
		assertEquals(modelList.getColumnCount(), tableModel.getColumnCount());
		assertEquals(modelList.findColumn("Id"), tableModel.findColumn("Id"));
		assertEquals(modelList.findColumn("Nome"), tableModel.findColumn("Nome"));
		assertEquals(modelList.findColumn("Tempo Médio (horas)"), tableModel.findColumn("Tempo Médio (horas)"));
	}
	
	@Test
	public void testGetStopTime(){
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Tempo Total (horas)");
		
		tableModel.addRow(new Object[]{
				1, 
				"maquina",
				10.0
				});
		
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		java.util.List<MeanTimeRepairDAOBusinessData> returnList = new ArrayList<MeanTimeRepairDAOBusinessData>();
		returnList.add(new MeanTimeRepairDAOBusinessData(1,"teste",10.0));
		Mockito.when(dataMock.getStopTime()).thenReturn(returnList);

		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		// When I do...
		DefaultTableModel modelList = orderServiceBuss.getStopTimeModel();
		
		// I Expect...
		assertEquals(modelList.getRowCount(), tableModel.getRowCount());
		assertEquals(modelList.getColumnCount(), tableModel.getColumnCount());
		assertEquals(modelList.findColumn("Id"), tableModel.findColumn("Id"));
		assertEquals(modelList.findColumn("Nome"), tableModel.findColumn("Nome"));
		assertEquals(modelList.findColumn("Tempo Total (horas)"), tableModel.findColumn("Tempo Total (horas)"));
	}
	
	@Test
	public void testGetTotalCost(){
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Custo Total (R$)");
		
		tableModel.addRow(new Object[]{
				1, 
				"maquina",
				10.0
				});
		
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		java.util.List<MeanTimeRepairDAOBusinessData> returnList = new ArrayList<MeanTimeRepairDAOBusinessData>();
		returnList.add(new MeanTimeRepairDAOBusinessData(1,"teste",10.0));
		Mockito.when(dataMock.getCostRepair()).thenReturn(returnList);

		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		// When I do...
		DefaultTableModel modelList = orderServiceBuss.getCostRepairModel();
		
		// I Expect...
		assertEquals(modelList.getRowCount(), tableModel.getRowCount());
		assertEquals(modelList.getColumnCount(), tableModel.getColumnCount());
		assertEquals(modelList.findColumn("Id"), tableModel.findColumn("Id"));
		assertEquals(modelList.findColumn("Nome"), tableModel.findColumn("Nome"));
		assertEquals(modelList.findColumn("Custo Total (R$)"), tableModel.findColumn("Custo Total (R$)"));
	}
	
	
	@Test
	public void testGet(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData returnDAO = new OrderServiceDAOBusinessData(1,1,1,2020,1,1,1,1,1,1,"teste",1);
		
		Mockito.when(dataMock.get(1)).thenReturn(returnDAO);
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		Mockito.when(techMock.get(1)).thenReturn(new TechnicianDAOPresentationBusiness(1, "Eletricista", "joão", 10.5));
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		Mockito.when(equipMock.get(1)).thenReturn(new EquipmentDAOPresentationBusiness(1, "maquina", "model", "manufacturer"));
		
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01012020" , "0101", "0101", "maquina","joão", "teste", "Corretiva" );
		
		// When I do...
		OrderServiceDAOPresentationBusiness returnFromBusiness = orderServiceBuss.get(1);
		
		// I Expect...
		assertEquals(returnFromBusiness.getId(), DAOpresentation.getId());
		assertEquals(returnFromBusiness.getDate(), DAOpresentation.getDate());
		assertEquals(returnFromBusiness.getDescription(), DAOpresentation.getDescription());
		assertEquals(returnFromBusiness.getEndTime(), DAOpresentation.getEndTime());
		assertEquals(returnFromBusiness.getEquipment(), DAOpresentation.getEquipment());
		assertEquals(returnFromBusiness.getStartTime(), DAOpresentation.getStartTime());
		assertEquals(returnFromBusiness.getTechinician(), DAOpresentation.getTechinician());
		assertEquals(returnFromBusiness.getTypeService(), DAOpresentation.getTypeService());
		
	}
	
	@Test
	public void testSaveReturnFalseInvalidDate(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"" , "0101", "0101", "maquina","joão", "teste", "Corretiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage,"Informar a data da ordem de serviço.");
	}
	
	@Test
	public void testSaveReturnFalseInvalidStartTime(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "", "0101", "maquina","joão", "teste", "Corretiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage,"Informar o horário de início.");
	}
	
	@Test
	public void testSaveReturnFalseInvalidEndTime(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "01:01", "", "maquina","joão", "teste", "Corretiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage,"Informar o horário fim.");
	}
	
	@Test
	public void testSaveReturnFalseInvalidEquipment(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "01:01", "08:01", "","joão", "teste", "Corretiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage,"Informar a máquina.");
	}
	
	@Test
	public void testSaveReturnFalseInvalidTechinician(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "01:01", "08:01", "maquina","", "teste", "Corretiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage,"Informar o técnico.");
	}
	
	@Test
	public void testSaveReturnFalseInvalidTypeService(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "0101", "0801", "maquina","joão", "teste", "" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage,"Informar o tipo de serviço.");
	}


	@Test
	public void testSaveReturnFalseInvalidDescription(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "01:01", "08:01", "maquina","joão", "", "Preventiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage, "Informar a descrição do serviço.");
	}

	
	@Test
	public void testSaveReturnFalseStartTimeGreatherThanEndTime(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "10:01", "08:01", "maquina","joão", "teste", "Preventiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, false);
		assertEquals(orderServiceBuss.feedbackMessage, "Informar o horário fim deve ser posterior ao horário de início.");
	}
	
	@Test
	public void testSaveReturnTrue(){
		OrderServiceData dataMock = Mockito.mock(OrderServiceData.class);
		OrderServiceDAOBusinessData data = new OrderServiceDAOBusinessData(1,1,1,1,1,1,1,1,1,1,"teste",1);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		TechnicianBusiness techMock = Mockito.mock(TechnicianBusiness.class);
		
		EquipmentBusiness equipMock = Mockito.mock(EquipmentBusiness.class);
		
		Mockito.when(techMock.getByName("joão")).thenReturn(new TechnicianDAOPresentationBusiness(1, "Eletricista", "joão", 10.5));
		Mockito.when(equipMock.getByName("maquina")).thenReturn(new EquipmentDAOPresentationBusiness(1, "maquina", "model", "manufacturer"));
		
		
		OrderServiceBusiness orderServiceBuss = new OrderServiceBusiness(dataMock, techMock, equipMock);
		
		OrderServiceDAOPresentationBusiness DAOpresentation = new OrderServiceDAOPresentationBusiness(1,"01/01/2018" , "10:01", "10:11", "maquina","joão", "teste", "Preventiva" );
		
		// When I do...
		boolean returnFromBusiness = orderServiceBuss.save(DAOpresentation);
		
		// I Expect...
		assertEquals(returnFromBusiness, true);
	}
	
}
