package br.com.fuctura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {

		try {

			return DriverManager.getConnection("jdbc:postgresql://localhost/fucturadb", "postgres", "toor");

		} catch (Exception erro) {
			throw new RuntimeException(erro);
		}

	}

}
