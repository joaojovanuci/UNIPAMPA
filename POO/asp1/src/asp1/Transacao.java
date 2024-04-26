package asp1;

import java.util.Vector;

public class Transacao {
	private Vector<Conta> contas;
    private double valor;
    private TipoTransacao tipo;

    public Transacao(Conta origem, Conta destino, double valor) {
        this.contas = new Vector<>();
        this.contas.add(origem);
        this.contas.add(destino);
        this.valor = valor;
        this.tipo = TipoTransacao.TRANSFERENCIA;
        realizarTransacao();
    }

    public Transacao(Conta conta, double valor, TipoTransacao tipo) {
        this.contas = new Vector<>();
        this.contas.add(conta);
        this.valor = valor;
        this.tipo = tipo;
        realizarTransacao();
    }

    private void realizarTransacao() {
        switch (tipo) {
            case DEPOSITO:
                contas.get(0).depositar(valor);
                break;
            case RETIRADA:
                contas.get(0).retirar(valor);
                break;
            case TRANSFERENCIA:
                contas.get(0).retirar(valor);
                contas.get(1).depositar(valor);
                break;
            default:
                System.out.println("Tipo de transação inválido.");
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Tipo: ").append(tipo);
        result.append(", Valor: ").append(valor);

        if (tipo == TipoTransacao.TRANSFERENCIA) {
            result.append(", Conta de Origem: ").append(contas.get(0).numeroConta());
            result.append(", Conta de Destino: ").append(contas.get(1).numeroConta());
        } else {
            result.append(", Conta: ").append(contas.get(0).numeroConta());
        }

        return result.toString();
    }
}
