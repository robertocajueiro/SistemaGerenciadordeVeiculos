package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.jdbc.ConnectionFactory;
import br.com.fuctura.model.Loja;
import br.com.fuctura.model.Vendedor;

public class LojaDAOImpl extends ConnectionFactory {

	private Connection con;

	public LojaDAOImpl() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void inserir(Connection conexao, Loja loja) {

		try {
			String sql = "INSERT INTO loja (nome) VALUES (?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.print("Digite o nome do Loja: ");
			stmt.setString(1, loja.getNome());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void listar() {

		String sql = "SELECT * FROM loja";
		try (Statement statement = con.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(sql)) {
				while (resultSet.next()) {
					System.out.println(
							"Código: " + resultSet.getInt("codigo") + ", Loja: " + resultSet.getString("nome"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Loja> listarByNome(String nome) throws SQLException {

		List<Loja> loja = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM loja WHERE lower(nome) LIKE ?");
			stmt.setString(1, "%" + nome.toLowerCase() + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Loja loj = salvar(rs);
				loja.add(loj);
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
		return loja;

	}

	public Loja salvar(ResultSet rs) throws SQLException {
		Loja loja = new Loja();
		loja.setCodigo(rs.getInt("codigo"));
		loja.setNome(rs.getString("nome"));

		return loja;
	}

	// Metodo cadastrar Vendedor
	public void cadastrarVendedor(Vendedor obj) {

		try {

			// Primeiro passo: criar o comando sql
			String sql = "insert  into vendedor(nome)" + "values (?)";

			// Segundo passo: conectar o banco de dados e organizar o sql.
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());

			// Terceiro passo: Executar comando SQL
			stmt.execute();
			stmt.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException erro) {
			System.out.println("Erro: " + erro);
		}

	}

	// Metodo alterar Vendedor
	public void atualizarVendedor(Vendedor obj) {

		try {

			// Primeiro passo: criar o comando sql
			String sql = "update vendedor set nome=? where codigo = ?";

			// Segundo passo: conectar o banco de dados e organizar o sql.
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, obj.getNome());

			stmt.setLong(2, obj.getCodigo());

			// Terceiro passo: Executar comando SQL
			stmt.execute();
			stmt.close();

			System.out.println("Alterado com sucesso!");

		} catch (SQLException erro) {
			System.out.println("Erro: " + erro);
		}

	}

	// Metodo excluir Vendedor
	public void excluirVendedor(Vendedor obj) {

		try {

			// Primeiro passo: criar o comando sql
			String sql = "delete from vendedor where codigo = ?";

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
