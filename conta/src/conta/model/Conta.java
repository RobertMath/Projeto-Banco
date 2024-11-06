package conta.model;

import conta.util.Cores;

public class Conta {

	private int numero_conta;
	private int agencia_conta;
	private int tipo_conta;
	private String nome_titular;
	private float saldo_conta;

	public Conta(int numero_conta, int agencia_conta, int tipo_conta, String nome_titular, float saldo_conta) {
		this.numero_conta = numero_conta;
		this.agencia_conta = agencia_conta;
		this.tipo_conta = tipo_conta;
		this.nome_titular = nome_titular;
		this.saldo_conta = saldo_conta;
	}

	public int getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(int numero_conta) {
		this.numero_conta = numero_conta;
	}

	public int getAgencia_conta() {
		return agencia_conta;
	}

	public void setAgencia_conta(int agencia_conta) {
		this.agencia_conta = agencia_conta;
	}

	public int getTipo_conta() {
		return tipo_conta;
	}

	public void setTipo_conta(int tipo_conta) {
		this.tipo_conta = tipo_conta;
	}

	public String getNome_titular() {
		return nome_titular;
	}

	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}

	public float getSaldo_conta() {
		return saldo_conta;
	}

	public void setSaldo_conta(float saldo_conta) {
		this.saldo_conta = saldo_conta;
	}
	
	
	public static void print(String mensagem) {
		System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND + mensagem);
	}
	
	public boolean sacar(float valor) {
		if (this.getSaldo_conta() < valor) {
			print(Cores.TEXT_RED + "\n Saldo Insuficiente!");
			return false;
		}
		this.setSaldo_conta(this.getSaldo_conta() - valor);//modificando o valor da conta para saldo - valor digitado
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo_conta(this.getSaldo_conta()+ valor);
	}
	
	public void visualizar() {
		String tipo_conta = "";
		
		switch(this.tipo_conta) {
		case 1:
			tipo_conta = "Conta Corrente";
			break;
		case 2:
			tipo_conta = "Conta Poupança";
			break;
		}
		print("\n\n*****************************************************");
		print("Dados da Conta:                                      ");
		print("*****************************************************");
		print("Numero da Conta: " + this.numero_conta);
		print("Agência: " + this.agencia_conta);
		print("Tipo da Conta: " + tipo_conta);
		print("Titular: " + this.nome_titular);
		print("Saldo: " + this.saldo_conta);
		
	}

}
