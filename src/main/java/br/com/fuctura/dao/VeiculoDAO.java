package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.jdbc.ConnectionFactory;
import br.com.fuctura.model.Veiculo;

public class VeiculoDAO extends ConnectionFactory {

	private Connection con;

	public VeiculoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void inserirVeiculo() {

		Scanner sc = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		try {
			String sql = "INSERT INTO veiculos (modelo, placa, ano, valor) " + "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.print("Digite o modelo do carro: ");
			stmt.setString(1, sc.next(veiculo.getModelo()));
			stmt.setString(2, sc.next(veiculo.getPlaca()));
			stmt.setInt(3, sc.nextInt(veiculo.getAno()));
			stmt.setDouble(4, sc.nextInt((int) veiculo.getValor()));
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();

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
	
	public List<Veiculo> listarVeiculosPorPlaca(String placa) throws SQLException {
		
		List<Veiculo> veiculos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM veiculo WHERE lower(placa) LIKE ?");
			stmt.setString(1, "%" + placa.toLowerCase() + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				Veiculo v = criarVeiculo(rs);
				veiculos.add(v);
			}
			rs.close();
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return veiculos;
		
		
		
	}
	
	// Chamada para outros metodos
	public Veiculo criarVeiculo(ResultSet rs) throws SQLException {
		Veiculo v = new Veiculo();
		v.setCodigo(rs.getLong("codigo"));
		v.setModelo(rs.getString("modelo"));
		v.setPlaca(rs.getString("placa"));
		v.setAno(rs.getInt("ano"));
		v.setValor(rs.getDouble("valor"));
		return v;
	}
	
	// Metodo cadastrar veiculo
    public void cadastrarVeiculo(Veiculo obj) {

        try {

            //Primeiro passo: criar o comando sql
            String sql = "insert  into veiculo(placa,modelo,ano,valor)"
                    + "values (?,?,?,?)";

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
    
  //Metodo alterar cliente
    public void alterarVeiculo(Veiculo obj) {

        try {

            //Primeiro passo: criar o comando sql
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


	


}
