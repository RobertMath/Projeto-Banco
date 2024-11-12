package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner scanner = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor = 0;

		print("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Frederico Evandro", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 321, 1, "Maria Bonita", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 213, 2, "Everaldo Tavares", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 652, 2, "Godofredo Junior", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {
			print("*****************************************************");
			print("                                                     ");
			print("                     BANCO DEV                       ");
			print("                                                     ");
			print("*****************************************************");
			print("                                                     ");
			print("            1 - Criar Conta                          ");
			print("            2 - Listar todas as Contas               ");
			print("            3 - Buscar Conta por Numero              ");
			print("            4 - Atualizar Conta                      ");
			print("            5 - Apagar Conta                         ");
			print("            6 - Sacar                                ");
			print("            7 - Depositar                            ");
			print("            8 - Transferir valores entre Contas      ");
			print("            9 - Sair                                 ");
			print("                                                     ");
			print("*****************************************************");
			print("                                                     ");
			print("Entre com a opção desejada:                          ");
			print("                                                     ");

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				print("\nDigite valores inteiros!                             ");
				scanner.nextLine();
				opcao = 0;
			}
			if (opcao == 9) {
				print("                                                     ");
				print("Banco Dev - O seu Futuro começa aqui!                ");
				sobre();
				break;
			}
			// executarOpcao(opcao);

			switch (opcao) {
			case 1:
				print("                                                     ");
				print("Criar Conta                                          ");
				print("                                                     ");
				print("Digite o numero da Agência:                          ");
				agencia = scanner.nextInt();
				print("Digite o nome do Titular:                            ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();

				do {
					print("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				print("Digite o Saldo da Conta (R$): ");
				saldo = scanner.nextFloat();

				switch (tipo) {
				case 1 -> {
					print("Digite o Limite do Crédito (R$): ");
					limite = scanner.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					print("Digite o dia do Aniversario da Conta: ");
					aniversario = scanner.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				KeyPress();
				break;
			case 2:
				print("                                                     ");
				print("Listar todas as contas                               ");
				print("                                                     ");
				contas.listarTodas();
				KeyPress();
				break;
			case 3:
				print("                                                     ");
				print("Consultar dados da Conta - por número                ");
				print("                                                     ");
				print("Digite o número da conta:                            ");
				numero = scanner.nextInt();
				contas.procurarPorNumero(numero);
				KeyPress();
				break;
			case 4:
				print("                                                     ");
				print("Atualizar dados da Conta                             ");
				print("                                                     ");
				print("Digite o numero da Conta: ");
				numero = scanner.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					print("Digite o numero da Agência                           ");
					agencia = scanner.nextInt();
					print("Digite o nomedo Titular:                             ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();

					print("Digite o Saldo da Conta (R$):                        ");
					saldo = scanner.nextFloat();

					switch (tipo) {
					case 1 -> {
						print("Digite o limite do Crédito (R$): ");
						limite = scanner.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));

					}
					case 2 -> {
						print("Digite o dia do Aniversario da Conta:                ");
						aniversario = scanner.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						print("Tipo de conta inválida!");
					}

					}

				} else {
					print("A conta não foi encontrada!");
				}

				KeyPress();
				break;
			case 5:
				print("                                                     ");
				print("Apagar a Conta                                       ");
				print("                                                     ");
				print("Digite o número da conta:                            ");
				numero = scanner.nextInt();

				contas.deletar(numero);

				KeyPress();
				break;
			case 6:
				print("                                                     ");
				print("Saque                                                ");
				print("                                                     ");
				print("Digite o Numero da conta:                            ");
				numero = scanner.nextInt();

				do {
					print("Digite o Valor do Saque (R$):                    ");
					valor = scanner.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				KeyPress();
				break;
			case 7:
				print("                                                     ");
				print("Depósito                                             ");
				print("                                                     ");
				print("Digite o Numero da Conta:                            ");
				numero = scanner.nextInt();

				do {
					print("Digite o Valor do Depósito (R$):                 ");
					valor = scanner.nextFloat();
				} while (valor <= 0);
				
				contas.depositar(numero, valor);

				KeyPress();
				break;
			case 8:
				print("                                                     ");
				print("Transferência entre Contas                           ");
				print("                                                     ");
				print("Digite o Numero da Conta de Origem:                  ");
				numero = scanner.nextInt();
				print("Digite o Numero da Conta de Destino:                 ");
				numeroDestino = scanner.nextInt();
				
				do {
					print("Digite o Valor da Transferência (R$): ");
					valor = scanner.nextFloat();
				}while(valor <= 0);
					
				contas.transferir(numero, numeroDestino, valor);
				
				KeyPress();
				break;
			default:
				print(Cores.TEXT_RED + "Opção Inválda                                        ");
				KeyPress();
				break;
			}
		}
		scanner.close();
	}

	public static void print(String mensagem) {
		System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND + mensagem);
	}

	public static void sobre() {
		print("                                                     ");
		print("*****************************************************");
		print("                                                     ");
		print("Projeto Desenvolvido por: Robert Matheus             ");
		print("Email: robertmatheus8@gmail.com                      ");
		print("GitHub: https://github.com/RobertMath                ");
		print("                                                     ");
		print("*****************************************************");
	}

	public static void KeyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
