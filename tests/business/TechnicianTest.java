package business;

import static org.junit.Assert.*;

import org.junit.Test;

import businessMocks.TechnicianDataMock;
import data.TechnicianData;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianTest {
	
	
	TechnicianBusiness techBuss = new TechnicianBusiness();
	TechnicianDAOPresentationBusiness DAOPresesentation;
	
	@Test
	public void testhasPendenciesWithoutPendencies(){
		TechnicianData dataMock = Mockito.mock(TechnicianData.class);
		
		// When I have...
		DAOPresesentation = new TechnicianDAOPresentationBusiness(1,"Eletricista","teste",10.8);
		
		
		// When I do...
		boolean result = techBuss.save(DAOPresesentation);
		
		// I Expect...
		assertEquals(result, false);
	}

}
