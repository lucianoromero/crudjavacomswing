package cadastro.de.pessoas.model;

public class Pessoa {
	//TODO  Classe Construtora do Objeto Pessoa
	private int id;
	private String nome;
	private String sobrenome;
	private int cpf;
	private String data_nacimento;
	private Double salario;
	private int rg;
	private int telefone;

	public Pessoa(String nome, String sobrenome, int cpf, String data_nacimento, Double salario, int rg, int telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.data_nacimento = data_nacimento;
		this.salario = salario;
		this.rg = rg;
		this.telefone = telefone;
	}
    
	
	public Pessoa(int id, String nome, String sobrenome, int cpf, String data_nacimento, Double salario, int rg,
			int telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.data_nacimento = data_nacimento;
		this.salario = salario;
		this.rg = rg;
		this.telefone = telefone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getData_nacimento(){
		return data_nacimento;
	}

	public void setData_nacimento(String data_nacimento) {
		this.data_nacimento = data_nacimento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

}
