package asp1;

public class Conta {
	 private String numero;
	    private double saldo;
	    private Cliente titular;

	    public Conta(String numero, double saldo, Cliente titular) {
	        this.numero = numero;
	        this.saldo = saldo;
	        this.titular = titular;
	    }

	    public void depositar(double valor) {
	        saldo += valor;
	    }

	    public void retirar(double valor) {
	        if (valor <= saldo) {
	            saldo -= valor;
	        } else {
	            System.out.println("Saldo insuficiente.");
	        }
	    }

	    public double saldoAtual() {
	        return saldo;
	    }

	    public String numeroConta() {
	        return numero;
	    }

		public Cliente getTitular() {
			
			return titular;
		}
}
