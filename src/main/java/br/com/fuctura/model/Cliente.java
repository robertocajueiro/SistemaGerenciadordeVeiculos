package br.com.fuctura.model;

public class Cliente {
	private Long codigo;
	private String nome;
	private String cpf;
	private String celular;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long codigo, String nome, String cpf, String celular) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
