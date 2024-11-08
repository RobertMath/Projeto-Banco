package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {

		
		// teste classe conta corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Godofredo Fernandes", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		// teste classe conta poupanca
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Frederico Evandro", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		Scanner scanner = new Scanner(System.in);

		int opcao;

		while (true) {
			print("*****************************************************");
			print("                                                     ");
			print("                     BANCO DEV                       ");
			print("                                                     ");
			print("*****************************************************");
			print("            1 - Criar Conta                          ");
			print("            2 - Listartodas as Contas                ");
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

			opcao = scanner.nextInt();

			if (opcao == 9) {
				print("                                                     ");
				print("Banco Dev - O seu Futuro começa aqui!                ");
				sobre();
				break;
			}
			executarOpcao(opcao);
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

	public static void executarOpcao(int opcao) {
		switch (opcao) {
		case 1:
			print("                                                     ");
			print("Criar Conta                                          ");
			print("                                                     ");
			break;
		case 2:
			print("                                                     ");
			print("Consultar dados da Conta - Por número                ");
			print("                                                     ");
			break;
		case 3:
			print("                                                     ");
			print("Atualizar dados da Conta                             ");
			print("                                                     ");
			break;
		case 4:
			print("                                                     ");
			print("Apagar a Conta                                       ");
			print("                                                     ");
			break;
		case 5:
			print("                                                     ");
			print("Saque                                                ");
			print("                                                     ");
			break;
		case 6:
			print("                                                     ");
			print("Saque                                                ");
			print("                                                     ");
			break;
		case 7:
			print("                                                     ");
			print("Depósito                                             ");
			print("                                                     ");
			break;
		case 8:
			print("                                                     ");
			print("Transferência entre Contas                           ");
			print("                                                     ");
			break;
		default:
			print(Cores.TEXT_RED + "Opção Inválda                                        ");
		}
	}

}
