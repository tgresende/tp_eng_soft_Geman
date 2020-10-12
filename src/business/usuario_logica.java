package business;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connections.sqllConnection;
import dados.usuario_dados;
import logica_interface.IGenericLogica;
import objetoAcessoDados.usuario_objAcessoDados;

public class usuario_logica implements IGenericLogica<usuario_objAcessoDados> {

	usuario_objAcessoDados usuario;
	usuario_dados dados = new usuario_dados(sqllConnection.dbConnector());
	
	public usuario_logica() {
		
	}
	
	public usuario_logica(int id, int cargo, String nome) {
		usuario = new usuario_objAcessoDados(id, cargo, nome);
	}
	
	public DefaultTableModel getModelList() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Nome");
		model.addColumn("Cargo");
		
		for (usuario_objAcessoDados usuario : dados.getList()) {
			model.addRow(
					new Object[]{
							usuario.getId(), 
							usuario.getNome(),
							usuario.getCargo()
							}
			);
    		JOptionPane.showMessageDialog(null, usuario.getNome());

		}
		
		return model;
	}
	
	@Override
	public List<usuario_objAcessoDados> getList() {
		return dados.getList();
	}

	@Override
	public usuario_objAcessoDados get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		dados.delete(id);
	}

	
}
