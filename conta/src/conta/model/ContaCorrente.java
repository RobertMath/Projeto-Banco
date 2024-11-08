package conta.model;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero_conta, int agencia_conta, int tipo_conta, String nome_titular, float saldo_conta,
			float limite) {
		super(numero_conta, agencia_conta, tipo_conta, nome_titular, saldo_conta);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {

		if (this.getSaldo_conta() + this.getLimite() < valor) {
			print("\nSaldo Insuficiente");
			return false;
		}

		this.setSaldo_conta(this.getSaldo_conta() - valor);
		return true;
	}

	public void visualizar() {
		super.visualizar();
		print("Limite do Crédito: " + this.limite);
	}
}
