package br.com.fuctura;

import br.com.fuctura.dao.VeiculoDAO;

public class appTest {

	public static void main(String[] args) {

		VeiculoDAO dao = new VeiculoDAO();
		
		dao.listarVeiculos();
	}

}
