package merc;

public class Pedido {

	public TipoPagamento pagamento;
	
	public Pedido(int escolha) {
		if(escolha == 1) {
			this.pagamento = TipoPagamento.DINHEIRO;
		}else {
			if(escolha == 2) {
				this.pagamento = TipoPagamento.CHEQUE;
			}else {
				this.pagamento = TipoPagamento.CARTAO;
			}
		}
	}

}
