package state;

public class StateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Conta conta = new Conta("Jefferson Rodrigues");
		// Efetuar transações financeiras
		conta.deposito(500.0);
		conta.deposito(300.0);
		conta.deposito(550.0);
		conta.pagarJuro();
		conta.saque(2000.00);
		conta.saque(1100.00);
	}

}
