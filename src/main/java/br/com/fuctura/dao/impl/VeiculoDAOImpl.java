package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.dao.IVeiculoDAO;
import br.com.fuctura.jdbc.ConnectionFactory;
import br.com.fuctura.model.Veiculo;

public class VeiculoDAOImpl extends ConnectionFactory implements IVeiculoDAO {

	private Connection con;

	public VeiculoDAOImpl() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void insert(Connection conn, Veiculo veiculo) {

		try {
			String sql = "INSERT INTO veiculo (modelo, placa, ano, valor) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.print("Digite o modelo do carro: ");
			stmt.setString(1, veiculo.getModelo());
			stmt.setString(2, veiculo.getPlaca());
			stmt.setInt(3, veiculo.getAno());
			stmt.setDouble(4, ((int) veiculo.getValor()));
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void listAll(Connection conn, Veiculo veiculo) {

		String sql = "SELECT * FROM veiculo";
		try (Statement statement = con.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(sql)) {
				while (resultSet.next()) {
					System.out.println("Código: " + resultSet.getInt("codigo") + ", Modelo: "
							+ resultSet.getString("modelo") + ", Placa: " + resultSet.getString("placa") + ", Ano: "
							+ resultSet.getInt("ano") + ", Valor: " + resultSet.getDouble("valor"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Veiculo> listarPorPlaca(String placa) throws SQLException {

		List<Veiculo> veiculos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM veiculo WHERE lower(placa) LIKE ?");
			stmt.setString(1, "%" + placa.toLowerCase() + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Veiculo v = salvar(rs);
				veiculos.add(v);
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return veiculos;

	}

	public Veiculo salvar(ResultSet rs) throws SQLException {
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(rs.getLong("codigo"));
		veiculo.setModelo(rs.getString("modelo"));
		veiculo.setPlaca(rs.getString("placa"));
		veiculo.setAno(rs.getInt("ano"));
		veiculo.setValor(rs.getDouble("valor"));
		return veiculo;
	}

	// Metodo cadastrar veiculo
	public void cadastrarVeiculo(Veiculo obj) {

		try {

			// Primeiro passo: criar o comando sql
			String sql = "insert  into veiculo(placa,modelo,ano,valor)" + "values (?,?,?,?)";

			// Segundo passo: conectar o banco de dados e organizar o sql.
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getPlaca());
			stmt.setString(2, obj.getModelo());
			stmt.setInt(3, obj.getAno());
			stmt.setDouble(4, obj.getValor());

			// Terceiro passo: Executar comando SQL
			stmt.execute();
			stmt.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException erro) {
			System.out.println("Erro: " + erro);
		}

	}

	// Metodo alterar veiculo
	public void atualizarVeiculo(Veiculo obj) {

		try {

			// Primeiro passo: criar o comando sql
			String sql = "update veiculo set placa=?,modelo=?,ano=?,valor=? where codigo = ?";

			// Segundo passo: conectar o banco de dados e organizar o sql.
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getPlaca());
			stmt.setString(2, obj.getModelo());
			stmt.setInt(3, obj.getAno());
			stmt.setDouble(4, obj.getValor());

			stmt.setLong(5, obj.getCodigo());

			// Terceiro passo: Executar comando SQL
			stmt.execute();
			stmt.close();

			System.out.println("Alterado com sucesso!");

		} catch (SQLException erro) {
			System.out.println("Erro: " + erro);
		}

	}

	// Metodo excluir Veiculo
	public void excluirVeiculo(Veiculo obj) {

		try {

			// Primeiro passo: criar o comando sql
			String sql = "delete from veiculo where codigo = ?";

			// Segundo passo: conectar o banco de dados e organizar o sql.
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, obj.getCodigo());

			// Terceiro passo: Executar comando SQL
			stmt.execute();
			stmt.close();

			System.out.println("Excluido  com sucesso!");

		} catch (SQLException erro) {
			System.out.println("Erro: " + erro);
		}

	}

}
