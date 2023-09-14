// Lista 2 (TAD)
// 05/06/2022
// João Eduardo Fabris Jovanuci (joaojovanuci.aluno@unipampa.edu.br)

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "mercado.h"

int main(void){
	
	int totalProdutos;
	struct produtos *meusProdutos = NULL;
	int i;
	
	//ALOCAR MEMORIA PARA OS PRIMEIROS PRODUTOS
	printf("Digite a quantidade de produtos a serem cadastrados: ");
	setbuf(stdin,NULL);
	scanf("%d", &totalProdutos);
	meusProdutos = (struct produtos *)malloc(totalProdutos * sizeof(struct produtos));
	
	//PREENCHER OS PRIMEIROS PRODUTOS
	for(i=0;i<totalProdutos;i++){
		printf("\nProduto %d\n", i+1);
        printf("Nome: ");
		setbuf(stdin,NULL);
        scanf("%[^\n]s", &meusProdutos[i].nome);
        printf("Setor: ");
        int setorDigitado;
		setbuf(stdin,NULL);
		scanf("%d",&setorDigitado);
		meusProdutos[i].setor = setorDigitado;
        printf("Quantidade: ");
		setbuf(stdin,NULL);
        scanf("%d", &meusProdutos[i].quantidade);
        printf("Preco: ");
		setbuf(stdin,NULL);
        scanf("%f", &meusProdutos[i].preco);
	}
	
	//LAÇO DE OPCOES
	int opcao=-1;
	while(opcao=!0){
		printf("\nMENU\n");
        printf("0 - Sair do programa\n");
        printf("1 - Inserir produtos\n");
        printf("2 - Apresentar um produto\n");
        printf("3 - Apresentar todos os produtos\n");
        printf("4 - Balanco\n");
        printf("5 - Busca por nome\n");
        printf("6 - Busca por setor\n");
        printf("7 - Venda\n");
        printf("Digite sua opcao: ");
        scanf("%d", &opcao);
        switch(opcao){
			case 0:
			printf("\nSaindo do programa ...");
			return 0;
			
			case 1:
			printf("\nINSERINDO UM PRODUTO\n");
			int q=0;
			printf("Quantidade de produtos a serem cadastrados: ");
			setbuf(stdin,NULL);
			scanf("%d", &q);
			meusProdutos = inserirProdutos(meusProdutos,totalProdutos,q);
			totalProdutos+=q;
			break;
			
			case 2:
			printf("\nAPRESENTANDO UM PRODUTO\n");
			printf("\nDigite qual produto deseja apresentar(1 - %d): ", totalProdutos);
			setbuf(stdin,NULL);
			scanf("%d", &i);
			i = i-1;
            apresentaUm(meusProdutos,totalProdutos,i);
			break;
			
			case 3:
			printf("\nAPRESENTANDO TODOS OS PRODUTOS\n");
            apresentaTodos(meusProdutos,totalProdutos);
			break;
			
			case 4:
			printf("\nO BALANCO TOTAL EH DE R$%.2f\n", balanco(meusProdutos,totalProdutos,0));
			break;
			
			case 5:
			printf("\nBUSCA POR NOME\n");
            buscaporNome(meusProdutos, totalProdutos);
			break;
			
			case 6:
			printf("\nBUSCA POR SETOR\n");
            buscaporSetor(meusProdutos, totalProdutos);
			break;
			
			case 7:
			printf("\nVENDA\n");
			venda(meusProdutos, totalProdutos);
			if(meusProdutos[totalProdutos-1].quantidade==0){
				totalProdutos--;
			}
			break;
		}
	}
	return 0;
}


