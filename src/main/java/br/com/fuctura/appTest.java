package br.com.fuctura;

import br.com.fuctura.dao.impl.VeiculoDAOImpl;

public class appTest {

	public static void main(String[] args) {

		VeiculoDAOImpl dao = new VeiculoDAOImpl();
		
		dao.listar();
	}

}
