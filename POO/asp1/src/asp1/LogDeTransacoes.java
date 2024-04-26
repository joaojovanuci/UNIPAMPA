package asp1;

import java.util.ArrayList;

public class LogDeTransacoes {
	private ArrayList<Transacao> transacoes;

    public LogDeTransacoes() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionar(Transacao trans) {
        transacoes.add(trans);
    }

    public void listarTransacoes() {
        System.out.println("Lista de Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao.toString());
        }
    }
}
