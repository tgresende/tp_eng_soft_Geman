package objetoAcessoDados;

public class usuario_objAcessoDados extends genericObjetoAcessoDados {

	public usuario_objAcessoDados(int id, int cargo, String nome) {
		this.Id = id;
		this.Cargo = cargo;
		this.Nome = nome;
	}
	
	int Cargo;
	String Nome;
	
	
	public String getNome() {
		return Nome;
	}
	
	public int getId() {
		return Id;
	}
	
	public int getCargo() {
		return Cargo;
	}
	
	public void setNome(String nome) {
		Nome=nome ;
	}
	
	public void setId(int id) {
		Id=id;
	}
	
	public void setCargo(int cargo) {
		Cargo = cargo;
	}
	
	
}
