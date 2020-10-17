package business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import data.TechnicianData;
import dataAccessObjectBusinessData.TechnicianDAOBusinessData;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianTest {
	
	
	TechnicianBusiness techBuss = new TechnicianBusiness();
	TechnicianDAOPresentationBusiness DAOPresesentation;
	TechnicianDAOBusinessData data;
	
	
	@Test
	public void testhasPendenciesWithoutPendencies(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Eletricista","teste",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, true);
	}
	
	@Test
	public void testhasPendenciesWithRolePendency(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"","teste",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
	}
	
	@Test
	public void testhasPendenciesWithNamePendency(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Eletricista","",10.8);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
	}
	
	public void testhasPendenciesWithPricePendency(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		Mockito.when(dataMock.save(data)).thenReturn(true);
		
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Eletricista","",0.0);
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
	}

}
