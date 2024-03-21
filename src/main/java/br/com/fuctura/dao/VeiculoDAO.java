package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fuctura.jdbc.ConnectionFactory;
import br.com.fuctura.model.Veiculo;

public class VeiculoDAO {

	private Connection con;

	public VeiculoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void insertVeiculo(Veiculo veiculo) {

		try {
			String sql = "INSERT INTO veiculos (modelo, placa, ano, valor) " + "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getModelo());
			stmt.setString(2, veiculo.getPlaca());
			stmt.setInt(3, veiculo.getAno());
			stmt.setDouble(4, veiculo.getValor());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void listarVeiculos() {

		String sql = "SELECT * FROM veiculo";
		try (Statement statement = con.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(sql)) {
				while (resultSet.next()) {
					System.out.println("Código: " + resultSet.getInt("codigo") + ", Modelo: "
							+ resultSet.getString("modelo") + ", Placa: " + resultSet.getString("placa") + ", Ano: "
							+ resultSet.getInt("ano") + ", Valor: " + resultSet.getDouble("valor"));
					System.out.printf("Fim da consulta%n%n");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
