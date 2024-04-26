package asp1;

import java.util.ArrayList;

public class Contas {
	 private ArrayList<Conta> contas;

	    public Contas() {
	        this.contas = new ArrayList<>();
	    }

	    public void adicionarConta(Conta conta) {
	        contas.add(conta);
	    }

	    public Conta encontrarConta(String numero) {
	        for (Conta conta : contas) {
	            if (conta.numeroConta().equals(numero)) {
	                return conta;
	            }
	        }
	        return null;
	    }
	    public ArrayList<Conta> getContas() {
	        return contas;
	    }
	    public void mostrarTodasContas() {
	        System.out.println("Lista de Todas as Contas:");
	        for (Conta conta : contas) {
	            System.out.println("Número da Conta: " + conta.numeroConta());
	            System.out.println("Saldo Atual: " + conta.saldoAtual());
	            System.out.println("Titular: " + conta.getTitular().getCPF());
	            System.out.println("-----------------------------");
	        }
	    }
}
