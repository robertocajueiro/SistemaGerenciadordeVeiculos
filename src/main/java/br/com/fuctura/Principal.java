package br.com.fuctura;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.model.Veiculo;
import br.com.fuctura.service.VeiculoService;

public class Principal {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		int opcao;

		do {
			System.out.println("====== Menu Principal ======");
			System.out.println("1 - Frente de Loja");
			System.out.println("2 - Manutenção no Cadastro");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				frenteDeLoja(scanner);
				break;
			case 2:
				manutencaoCadastro(scanner);
				break;
			case 3:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 3);

		scanner.close();
	}

	public static void frenteDeLoja(Scanner scanner) throws SQLException {
		int opcao;
		do {
			System.out.println("====== Frente de Loja ======");
			System.out.println("1 - Gerenciar Veículo");
			System.out.println("2 - Gerenciar Loja");
			System.out.println("3 - Gerenciar Vendedor");
			System.out.println("4 - Gerenciar Cliente");
			System.out.println("5 - Gerenciar Venda");
			System.out.println("6 - Voltar para o menu principal");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Você escolheu Gerenciar Veículo.");
				gerenciarVeiculo(scanner);
				break;
			case 2:
				System.out.println("Você escolheu Gerenciar Loja.");
				// Implemente a lógica para gerenciar lojas aqui
				break;
			case 3:
				System.out.println("Você escolheu Gerenciar Vendedor.");
				// Implemente a lógica para gerenciar vendedores aqui
				break;
			case 4:
				System.out.println("Você escolheu Gerenciar Cliente.");
				// Implemente a lógica para gerenciar clientes aqui
				break;
			case 5:
				System.out.println("Você escolheu Gerenciar Venda.");
				// Implemente a lógica para gerenciar vendas aqui
				break;
			case 6:
				System.out.println("Voltando para o menu principal...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 6);
	}

	public static void manutencaoCadastro(Scanner scanner) {
		int opcao;
		do {
			System.out.println("====== Manutenção no Cadastro ======");
			System.out.println("1 - Gerenciar Veículo");
			System.out.println("2 - Gerenciar Loja");
			System.out.println("3 - Gerenciar Vendedor");
			System.out.println("4 - Gerenciar Cliente");
			System.out.println("5 - Cadastrar Venda");
			System.out.println("6 - Voltar para o menu principal");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Você escolheu Gerenciar Veículo.");
				// Implemente a lógica para gerenciar veículos aqui
				break;
			case 2:
				System.out.println("Você escolheu Gerenciar Loja.");
				// Implemente a lógica para gerenciar lojas aqui
				break;
			case 3:
				System.out.println("Você escolheu Gerenciar Vendedor.");
				// Implemente a lógica para gerenciar vendedores aqui
				break;
			case 4:
				System.out.println("Você escolheu Gerenciar Cliente.");
				// Implemente a lógica para gerenciar clientes aqui
				break;
			case 5:
				System.out.println("Você escolheu Cadastrar Venda.");
				// Implemente a lógica para cadastrar vendas aqui
				break;
			case 6:
				System.out.println("Voltando para o menu principal...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 6);
	}

	public static void gerenciarVeiculo(Scanner scanner) throws SQLException {
		int opcao;
		do {
			System.out.println("====== Gerenciar  Veículo ======");
			System.out.println("1 - Cadastra Veículo");
			System.out.println("2 - Listar Veículo pela placa");
			System.out.println("3 - Alterar Veículo");
			System.out.println("4 - Excluir Veículo");
			System.out.println("5 - Voltar para o menu principal");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			// Aqui chamo CRUD veiculo
			VeiculoDAO veiculo = new VeiculoDAO();
			VeiculoService veiculoService = new VeiculoService();

			switch (opcao) {
			case 1:
				System.out.println("Você escolheu Cadastra Veículo.");
				Scanner sc = new Scanner(System.in);
				Veiculo obj = new Veiculo();
				VeiculoDAO dao = new VeiculoDAO();
				System.out.println("Digite o modelo do veículo: ");
				obj.setModelo(sc.nextLine());
				System.out.println("Digite o ano do veículo: ");
				obj.setAno(sc.nextInt());
				System.out.println("Digite o Placa do veículo: ");
				obj.setPlaca(sc.next());
				System.out.println("Digite o valor do veiculo: ");
				obj.setValor(sc.nextDouble());
				dao.cadastrarVeiculo(obj);
				
				break;
			case 2:
				System.out.println("Você escolheu Listar Veículo pela placa.");
				System.out.print("Digite a placa do veículo: ");
				String placa = scanner.next();
				Veiculo listaPorPlaca = veiculoService.findByPlaca(placa).get(0);
				System.out.println(listaPorPlaca);
				break;
			case 3:
				System.out.println("Você escolheu Alterar Veículo.");
				// logica
				break;
			case 4:
				System.out.println("Você escolheu Excluir Veículo.");
				// logica
				break;
			case 5:
				System.out.println("Voltando para o menu principal...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 5);
	}
}
