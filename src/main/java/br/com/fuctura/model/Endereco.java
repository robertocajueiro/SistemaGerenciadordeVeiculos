package br.com.fuctura.model;

public class Endereco {

	private Long codigo;
	private String logadouro;
	private String complemento;
	private int numero;

	public Endereco() {
	}

	public Endereco(Long codigo, String logadouro, String complemento, int numero) {
		super();
		this.codigo = codigo;
		this.logadouro = logadouro;
		this.complemento = complemento;
		this.numero = numero;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
