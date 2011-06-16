package state;

public class EstadoOuro extends Estado{

	public EstadoOuro(Estado estado){
		this(estado.getSaldo(), estado.getConta());
	}
	
	public EstadoOuro(double saldo, Conta conta){
		setSaldo(saldo);
		setConta(conta);
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
	private void verificarAlteracaoEstado() {
		if (saldo < 0.0) {
			getConta().setEstado(new EstadoVermelho(this));
		} else if (saldo < limiteInferior) {
			getConta().setEstado(new EstadoPrata(this));
		}
	}

}
