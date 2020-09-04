package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dados_interface.IGenericDados;	
import objetoAcessoDados.usuario_objAcessoDados;

public class usuario_dados implements IGenericDados<usuario_objAcessoDados>{

	private Connection connection=null;
	
	public usuario_dados(Connection conn) {
		connection = conn;
	}
	
	@Override
	public List<usuario_objAcessoDados> getList() {
		String query = "Select * from USUARIO";
		PreparedStatement pst = null;
		ResultSet res = null;
		List<usuario_objAcessoDados> usuarios = new ArrayList<usuario_objAcessoDados>();
		
		try {
			pst = connection.prepareStatement(query);
			res = pst.executeQuery();
			
			while(res.next()){
				usuario_objAcessoDados usuario = 
						new usuario_objAcessoDados(
							res.getInt("Id"), 
							res.getInt("Cargo"),
							res.getString("Nome"));
				usuarios.add(usuario);
			}
			
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}

		return usuarios;
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
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
