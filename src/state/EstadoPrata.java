package state;


// Prata é um estado em que não há juros de depósito
public class EstadoPrata extends Estado{

	public EstadoPrata(Estado estado){
		this(estado.getSaldo(), estado.getConta());
	}
	
	public EstadoPrata(double saldo, Conta conta){		
		setSaldo(saldo);
		setConta(conta);
		inicializar();
	}
	
	private void inicializar() {
		// Estes valores devem vir de uma base de dados
		juro = 0.0;
		limiteInferior = 0.0;
		limiteSuperior = 1000.0;
	}
	
	@Override
	public void deposito(double quantia) {
		saldo += quantia;
		verificarAlteracaoEstado();		
	}

	@Override
	public void sacar(double quantia) {
		saldo -= quantia;
		verificarAlteracaoEstado();
	}

	@Override
	public void pagarJuro() {
		saldo += juro * saldo;
		verificarAlteracaoEstado();
	}
	
	public void verificarAlteracaoEstado() {
		if (saldo < limiteInferior) {
			getConta().setEstado(new EstadoVermelho(this));
		} else if (saldo > limiteSuperior) {
			getConta().setEstado(new EstadoOuro(this));
		}
	}
	
}
