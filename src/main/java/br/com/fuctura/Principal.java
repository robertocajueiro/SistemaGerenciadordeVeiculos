package br.com.fuctura;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

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

	public static void frenteDeLoja(Scanner scanner) {
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
}
