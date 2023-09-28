package merc;

public class Produto {
	
	public Descricao descricao;
	public double preço;
	public int quantidadeEstoque;
	
	public Produto(int escolha) {
		
		if(escolha == 1) {
			this.descricao = Descricao.ARROZ;
			this.preço = 5;
			this.quantidadeEstoque = 100;
		}else {
			if(escolha == 2) {
				this.descricao = Descricao.FEIJAO;
				this.preço = 6;
				this.quantidadeEstoque = 100;
			}else {
				if(escolha == 3) {
					this.descricao = Descricao.FARINHA;
					this.preço = 3;
					this.quantidadeEstoque = 100;
				}else {
					this.descricao = Descricao.LEITE;
					this.preço = 4;
					this.quantidadeEstoque = 100;
				}
			}
		}
	}
	
	

}
