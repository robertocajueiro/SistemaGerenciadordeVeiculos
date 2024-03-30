package br.com.fuctura.dao;

import java.sql.Connection;

import br.com.fuctura.model.Veiculo;

public interface IVeiculoDAO {
	
	void insert(Connection conn, Veiculo veiculo);
	void listAll(Connection conn, Veiculo veiculo);

}
