package business;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connections.sqllConnection;
import dados.MaquinaDados;
import logica_interface.IGenericLogica;
import objetoAcessoDados.MaquinaObjAcessoDados;

public class MaquinaLogica implements IGenericLogica<MaquinaObjAcessoDados>{

	MaquinaObjAcessoDados maquina;
	MaquinaDados dados = new MaquinaDados(sqllConnection.dbConnector());
	
	public MaquinaLogica() {
		
	}
	
	public MaquinaLogica(int id, String nome, String modelo, String fabricante) {
			maquina = new MaquinaObjAcessoDados(id, nome, modelo, fabricante);
	}
	
	public DefaultTableModel getModelList() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Nome");
		model.addColumn("Modelo");
		model.addColumn("Fabricante");
		
		for (MaquinaObjAcessoDados maquina : dados.getList()) {
			model.addRow(
					new Object[] {
							maquina.getId(),
							maquina.getNome(),
							maquina.getModelo(),
							maquina.getFabricante()
							}
			);
			JOptionPane.showMessageDialog(null, maquina.getNome());
		}
		
		return model;
	}
	
	
	@Override
	public List<MaquinaObjAcessoDados> getList() {
		return dados.getList();
	}

	@Override
	public MaquinaObjAcessoDados get() {
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
