package objetoAcessoDados;

public class usuario_objAcessoDados extends genericObjetoAcessoDados {

	public usuario_objAcessoDados(int id, int cargo, String nome) {
		this.Id = id;
		this.Cargo = cargo;
		this.Nome = nome;
	}
	
	public int Cargo;
	public String Nome;
	
	
}
