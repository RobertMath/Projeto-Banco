package conta;

import java.util.Scanner;
import conta.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
			print("****************************************");
			print("                                        ");
			print("               BANCO DEV                ");
			print("                                        ");
			print("****************************************");
			print("     1 - Criar Conta                    ");
			print("     2 - Listartodas as Contas          ");
			print("     3 - Buscar Conta por Numero        ");
			print("     4 - Atualizar Conta                ");
			print("     5 - Apagar Conta                   ");
			print("     6 - Sacar                          ");
			print("     7 - Depositar                      ");
			print("     8 - Transferir valores entre Contas");
			print("     9 - Sair                           ");
			print("                                        ");
			print("****************************************");
			print("                                        ");
			print("Entre com a opção desejada:             ");
			print("                                        ");
			
			
			opcao = scanner.nextInt();
			
			if(opcao == 9) {
				print("\nBanco Dev - O seu Futuro começa aqui!");
				sobre();
				scanner.close();
				break;
			}
			executarOpcao(opcao);
		}
		
		
	}

	public static void print(String mensagem) {
		System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND+ mensagem);
	}

	public static void sobre() {
		print("\n****************************************");
		print("Projeto Desenvolvido por: Robert Matheus");
		print("robertmatheus8@gmail.com");
		print("https://github.com/RobertMath");
		print("****************************************");
	}

	public static void executarOpcao(int opcao) {
		switch (opcao) {
		case 1:
			print("                                        ");
			print("Criar Conta                             ");
			print("                                        ");
			break;
		case 2:
			print("                                        ");
			print("Consultar dados da Conta - Por número   ");
			print("                                        ");
			break;
		case 3:
			print("                                        ");
			print("Atualizar dados da Conta                ");
			print("                                        ");
			break;
		case 4:
			print("                                        ");
			print("Apagar a Conta                          ");
			print("                                        ");
			break;
		case 5:
			print("                                        ");
			print("Saque                                   ");
			print("                                        ");
			break;
		case 6:
			print("                                        ");
			print("Saque                                   ");
			print("                                        ");
			break;
		case 7:
			print("                                        ");
			print("Depósito                                ");
			print("                                        ");
			break;
		case 8:
			print("                                        ");
			print("Transferência entre Contas              ");
			print("                                        ");
			break;
		default:
			print(Cores.TEXT_RED + "Opção Inválda                           ");
		}
	}

}
