package br.com.fuctura.aplicacao;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fuctura.dao.impl.VeiculoDAOImpl;
import br.com.fuctura.dao.impl.VendedorDAOImpl;
import br.com.fuctura.model.Veiculo;
import br.com.fuctura.model.Vendedor;

public class Aplicacao {

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
			System.out.println("\n====== Frente de Loja ======\n");
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
				gerenciarVendedor(scanner);
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
			System.out.println("\n====== Manutenção no Cadastro ======\n");
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
			System.out.println("\n====== Gerenciar  Veículo ======\n");
			System.out.println("1 - Cadastra Veículo");
			System.out.println("2 - Listar todos os Veículo");
			System.out.println("3 - Listar Veículo pela placa");
			System.out.println("4 - Alterar Veículo");
			System.out.println("5 - Excluir Veículo");
			System.out.println("6 - Voltar para o menu principal");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			Scanner sc = new Scanner(System.in);
			Veiculo obj = new Veiculo();
			VeiculoDAOImpl dao = new VeiculoDAOImpl();

			switch (opcao) {
			case 1:
				System.out.println("Você escolheu Cadastra Veículo.");

				System.out.println("Digite o modelo do veículo: ");
				var modeloVeiculo = sc.nextLine().toUpperCase();
				obj.setModelo(modeloVeiculo);

				System.out.println("Digite o ano do veículo: ");
				var anoVeiculo = sc.nextInt();
				obj.setAno(anoVeiculo);

				System.out.println("Digite a placa do veículo: ");
				var placaVeiculo = sc.next().toUpperCase();
				obj.setPlaca(placaVeiculo);

				System.out.println("Digite o valor do veículo: ");
				var valorVeiculo = sc.nextDouble();
				obj.setValor(valorVeiculo);

				dao.cadastrarVeiculo(obj);

				break;

			case 2:
				System.out.println("Você escolheu listar todos os Veículos.");
				dao.listAll(null, obj);
				break;
				
			case 3:
				System.out.println("Você escolheu Listar Veículo pela placa.");
				System.out.print("\nDigite a placa do veículo: ");
				var placa = scanner.next();
				Veiculo listaPorPlaca = dao.listarPorPlaca(placa).get(0);
				System.out.println(listaPorPlaca);
				break;
			case 4:
				System.out.println("Você escolheu Alterar Veículo no código.");

				System.out.println("Digite o código do veiculo que deseja alterar: ");
				obj.setCodigo(sc.nextLong());

				System.out.println("Informe o novo Modelo: ");
				var altModeloVeiculo = sc.nextLine().toUpperCase();
				obj.setModelo(altModeloVeiculo);

				System.out.println("Informe a nova placa do Veiculo: ");
				obj.setPlaca(sc.next().toUpperCase());
				System.out.println("Informe o novo Ano: ");
				obj.setAno(sc.nextInt());
				System.out.println("Informe o novo valor: ");
				obj.setValor(sc.nextDouble());

				dao.atualizarVeiculo(obj);
				break;

			case 5:
				System.out.println("Você escolheu Excluir Veículo.");

				System.out.println("Digite o código do veiculo que deseja excluir: ");
				obj.setCodigo(sc.nextLong());
				dao.excluirVeiculo(obj);

				break;
			case 6:
				System.out.println("Voltando para o menu principal...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 6);
	}

	// ---

	public static void gerenciarVendedor(Scanner scanner) throws SQLException {
		int opcao;
		do {
			System.out.println("\n====== Gerenciar  Vendedor ======\n");
			System.out.println("1 - Cadastra Vendedor");
			System.out.println("2 - Listar todos os Vendedores");
			System.out.println("3 - Listar Vendedor por nome");
			System.out.println("4 - Alterar Vendedor");
			System.out.println("5 - Excluir Vendedor");
			System.out.println("6 - Voltar para o menu principal");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			Scanner sc = new Scanner(System.in);
			Vendedor obj = new Vendedor();
			VendedorDAOImpl dao = new VendedorDAOImpl();

			switch (opcao) {
			case 1:
				System.out.println("Você escolheu Cadastra Vendedor.");

				System.out.println("Digite o nome do vendedor: ");
				var nomeVendedor = sc.nextLine();
				obj.setNome(nomeVendedor);

				if (nomeVendedor.length() >= 5) {
					dao.cadastrarVendedor(obj);
				} else {
					System.out.println("O Nome do vendedor precisa ter no mínimo 5 caracteres");
				}

				break;

			case 2:
				System.out.println("Você escolheu listar todos os Vendedores.");
				dao.listar();
				break;

			case 3:
				System.out.println("Você escolheu Listar Vendedores pelo nome.");
				System.out.print("\nDigite o nome do vendedor: ");
				String nome = scanner.next();
				Vendedor listarPorNome = dao.listarByNome(nome).get(0);
				System.out.println(listarPorNome);
				break;
			case 4:
				System.out.println("Você escolheu Alterar Vendedor chamando pelo código.");

				System.out.println("Digite o código do vendedor: ");
				obj.setCodigo(sc.nextLong());

				System.out.println("Informe o novo Nome: ");
				obj.setNome(sc.next().toUpperCase());

				dao.atualizarVendedor(obj);
				break;

			case 5:
				System.out.println("Você escolheu Excluir Vendedor.");

				System.out.println("Digite o código do vendedor que deseja excluir: ");
				obj.setCodigo(sc.nextLong());
				dao.excluirVendedor(obj);

				break;
			case 6:
				System.out.println("Voltando para o menu principal...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 6);

	}

}
