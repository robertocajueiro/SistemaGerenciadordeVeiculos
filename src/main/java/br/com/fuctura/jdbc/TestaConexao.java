package br.com.fuctura.jdbc;

public class TestaConexao {

	public static void main(String[] args) {

		try {

			new ConnectionFactory().getConnection();

			System.out.println("Conectado com sucesso!");
		} catch (Exception erro) {
			System.out.println("Ops, aconteceu um erro " + erro);
		}
	}

}
