package state;

// Conta neste caso é o contexto
public class Conta {
	
	private Estado estado;
	private String owner;
	
	public Conta(Estado estado, String owner){
		this.estado = estado;
		this.owner = owner;
	}
	public Conta(String owner){
		this.owner = owner;
		this.estado = new EstadoPrata(0.0,this);
	}
	public double getSaldo(){
		return this.estado.getSaldo();
	}
	
	public void saque(double quantia){		
		this.estado.sacar(quantia);
		System.out.println("Levantamento--- " + quantia);
		System.out.println(" Saldo = " + this.getSaldo());
		System.out.println(" Estado = " + this.getEstado().getClass().getName());
		
	}
	public void deposito(double quantia){
		this.estado.deposito(quantia);
		System.out.println("Depósito--- " + quantia);
		System.out.println(" Saldo = " + this.getSaldo());
		System.out.println(" Estado = " + this.getEstado().getClass().getName());
		System.out.println("");
	}
	public void pagarJuro(){
		estado.pagarJuro();
		System.out.println("Pagamento Juro --- ");
		System.out.println(" Saldo = " + this.getSaldo());
		System.out.println(" Estado = " + this.getEstado().getClass().getName());
	}
	
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwner() {
		return owner;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Estado getEstado() {
		return estado;
	}
}
