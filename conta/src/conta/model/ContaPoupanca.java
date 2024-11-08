package conta.model;

public class ContaPoupanca extends Conta {

	private int aniversario;
	
	public ContaPoupanca(int numero_conta, int agencia_conta, int tipo_conta, String nome_titular, float saldo_conta, int aniversario) {
		super(numero_conta, agencia_conta, tipo_conta, nome_titular, saldo_conta);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		print("Aniversário da conta: " + this.aniversario);
	}

	
	
}
