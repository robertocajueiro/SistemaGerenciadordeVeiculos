package br.com.fuctura.model;

public class Vendedor {
	private Long codigo;
	private String nome;

	public Vendedor() {
		// TODO Auto-generated constructor stub
	}

	public Vendedor(Long codigo, String vendedor) {
		super();
		this.codigo = codigo;
		this.nome = vendedor;
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

}
