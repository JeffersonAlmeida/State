package state;

public class EstadoVermelho extends Estado {
	
	private double taxaServico;
	
	public EstadoVermelho(Estado estado){
		this(estado.getSaldo(), estado.getConta());
	}
	public EstadoVermelho(double saldo, Conta conta){
		setSaldo(saldo);
		setConta(conta);
		inicializar();
	}
	
	private void inicializar() {
		// Estes valores devem vir de uma base de dados
		juro = 0.0;
		limiteInferior = -100.0;
		limiteSuperior = 0.0;
		taxaServico = 15.00;
	}	
	
	@Override
	public void deposito(double quantia) {
		saldo += quantia;
		verificarAlteracaoEstado();
		
	}

	@Override
	public void sacar(double quantia) {
		saldo -= taxaServico;
		System.out.println("Não existem fundos disponíveis para levantamento!");		
	}

	@Override
	public void pagarJuro() {
		// Não é pago juro		
	}
	
	private void verificarAlteracaoEstado() {
		if (saldo > limiteSuperior) {
			getConta().setEstado(new EstadoPrata(this));
		}
	}

}
