package br.com.fuctura.model;

public class Vendedor {
	private Long codigo;
	private String vendedor;

	public Vendedor() {
		// TODO Auto-generated constructor stub
	}

	public Vendedor(Long codigo, String vendedor) {
		super();
		this.codigo = codigo;
		this.vendedor = vendedor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

}
