package merc;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Cliente c1;
		int opcao = 1;
		int formaPagamento = 1;
		double precoTotal = 0;
		
		while(opcao!=0) {
			
			System.out.println("-----MENU-----");
			System.out.println("1 - Novo Pedido");
			System.out.println("2 - Realizar Pagamento");
			System.out.println("0 - Sair da Aplicação");
			System.out.println("Opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); //Limpar o scanner
			
		switch(opcao) {
		case 1:
			
			System.out.println("Nome: ");
			String nome = scanner.nextLine();
			System.out.println("Cpf: ");
			String cpf = scanner.nextLine();
			
			c1 = new Cliente(nome, cpf);

			System.out.println("\nCliente: "+c1.nome +" - Cpf: "+ c1.cpf);
			
			System.out.println("\n1 - ARROZ\n2 - FEIJAO\n3 - FARINHA\n4 - LEITE\nOpção: ");
			int escolherProduto = scanner.nextInt();
			Produto produto = new Produto(escolherProduto);
			System.out.println(produto.descricao);
			System.out.println(produto.preço);
			System.out.println(produto.quantidadeEstoque);
			System.out.println("Quantidade: ");
			int quantidade = scanner.nextInt();
			Item item = new Item(quantidade);
			produto.quantidadeEstoque = produto.quantidadeEstoque - item.quantidade;
			System.out.println("Quantidade restante: " + produto.quantidadeEstoque);
			precoTotal = precoTotal + (quantidade * produto.preço);
			System.out.println("Preço total: " + precoTotal);
			break;
		case 2:
			
			System.out.println("O total da compra é de: " + precoTotal);
			System.out.println("Formas de pagamento:\n1 - Dinheiro\n2 - Cheque\n3 - Cartão");
			formaPagamento = scanner.nextInt();
			Pedido pedido = new Pedido(formaPagamento);
			System.out.println("O pagamento foi realizado com " + pedido.pagamento + "!");
			break;
		case 0:
			System.out.println("Saindo...");
			break;
		}
		}
	}

}
