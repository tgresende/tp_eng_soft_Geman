package business;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import dados.usuario_dados;
import objetoAcessoDados.usuario_objAcessoDados;

public class TechnicianBusiness implements IGenericBusiness<usuario_objAcessoDados> {

	usuario_objAcessoDados technicianDAO;
	usuario_dados technicianData = new usuario_dados(sqllConnection.dbConnector());
	
	public TechnicianBusiness() {
		
	}
	
	public TechnicianBusiness(int id, int cargo, String nome) {
		technicianDAO = new usuario_objAcessoDados(id, cargo, nome);
	}
	
	public DefaultTableModel getModelList() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Cargo");
		
		for (usuario_objAcessoDados usuario : technicianData.getList()) {
			tableModel.addRow(
					new Object[]{
							usuario.getId(), 
							usuario.getNome(),
							usuario.getCargo()
							}
			);
		}
		
		return tableModel;
	}
	
	@Override
	public List<usuario_objAcessoDados> getList() {
		return technicianData.getList();
	}

	@Override
	public usuario_objAcessoDados get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		technicianData.delete(id);
	}

	
}
