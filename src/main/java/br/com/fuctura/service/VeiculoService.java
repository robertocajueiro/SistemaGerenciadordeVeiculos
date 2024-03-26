package br.com.fuctura.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.model.Veiculo;

public class VeiculoService {
	
	private VeiculoDAO db = new VeiculoDAO();
	
	// Buscar carro pela placa
	public List<Veiculo> findByPlaca(String placa) {
		
		try {
			return db.listarVeiculosPorPlaca(placa);
		} catch (SQLException e) {
			return null;
		}
	}

}
