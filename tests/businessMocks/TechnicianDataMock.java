package businessMocks;

import java.util.ArrayList;
import java.util.List;

import dataAccessObjectBusinessData.TechnicianDAOBusinessData;
import dataInterface.IGenericDados;

public class TechnicianDataMock implements IGenericDados<TechnicianDAOBusinessData>{

	public List<Integer> getAvaliableRoles() {
		List<Integer> roles = new ArrayList<Integer>();
     	roles.add(1);
     	roles.add(2);
		return roles; 
	}
	
	@Override
	public List<TechnicianDAOBusinessData> getList() {
		List<TechnicianDAOBusinessData> technicians = new ArrayList<TechnicianDAOBusinessData>();
		
		TechnicianDAOBusinessData technician = 
				new TechnicianDAOBusinessData(1,1,"teste",10.0);
		technicians.add(technician);
		technician = 
				new TechnicianDAOBusinessData(2,2,"teste 2",20.0);
		technicians.add(technician);
	
		return technicians;
	}

	@Override
	public TechnicianDAOBusinessData get(int id) {
		if (id == 0) {
			return null;
		}
			
		TechnicianDAOBusinessData technician = 
				new TechnicianDAOBusinessData(1,1,"teste",10.0);
			return technician;
	}

	@Override
	public boolean save(TechnicianDAOBusinessData technician) {
		return true;
	}

	@Override
	public void delete(int id) {
		return;
	}
	
}
