package br.com.fuctura.model;

public class Tipo {

	private Long codigo;
	private String descricao;

	public Tipo() {

	}

	public Tipo(Long codigo, String descricao) {
		this.descricao = descricao;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
