package br.com.fuctura.model;

public class Venda {
	private Long codigo;
	private double valor;

	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Long codigo, double valor) {
		super();
		this.codigo = codigo;
		this.valor = valor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
