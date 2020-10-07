package objetoAcessoDados;

public class MaquinaObjAcessoDados extends genericObjetoAcessoDados{
	
	String Nome;
	String Modelo;
	String Fabricante;
	
	public MaquinaObjAcessoDados(int id, String nome, String modelo, String fabricante) {
		this.Id = id;
		this.Nome = nome;
		this.Modelo = modelo;
		this.Fabricante = fabricante;
	}
	
	
	public int getId() {
		return Id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public String getModelo() {
		return Modelo;
	}
	
	public String getFabricante() {
		return Fabricante;
	}
	
	public void setId(int id) {
		Id=id;
	}
	
	public void setNome(String nome) {
		Nome=nome ;
	}
	
	public void setModelo(String modelo) {
		Modelo=modelo;
	}
	
	public void setFabricante(String fabricante) {
		Fabricante=fabricante ;
	}
}
