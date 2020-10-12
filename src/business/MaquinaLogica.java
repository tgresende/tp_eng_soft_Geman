package business;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import businessInterface.IGenericBusiness;
import connections.sqllConnection;
import data.MaquinaDados;
import dataAccessObject.MaquinaObjAcessoDados;

public class MaquinaLogica implements IGenericBusiness<MaquinaObjAcessoDados>{

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
	public MaquinaObjAcessoDados get(int id) {
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
