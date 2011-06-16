package state;

public abstract class Estado {
	
	private Conta conta;
	
	protected double saldo;
	protected double juro;
	
	protected double limiteInferior;
	protected double limiteSuperior;
		
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getJuro() {
		return juro;
	}
	public void setJuro(double juro) {
		this.juro = juro;
	}
	public double getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(double limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	public double getLimiteSuperior() {
		return limiteSuperior;
	}
	public void setLimiteSuperior(double limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}
	
	// Métodos abstratos
	
	public abstract void deposito(double quantia);
	public abstract void sacar(double quantia);
	public abstract void pagarJuro();
}
