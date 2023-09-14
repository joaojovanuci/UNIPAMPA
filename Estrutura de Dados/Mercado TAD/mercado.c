#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "mercado.h"

struct produtos * inserirProdutos(struct produtos *meusProdutos, int totalProdutos, int q){
	
	int i;
	meusProdutos = realloc(meusProdutos, sizeof(struct produtos)*(q+totalProdutos));
	
	for(i=totalProdutos;i<totalProdutos+q;i++){
		printf("\nProduto %d\n", i+1);
        setbuf(stdin,NULL);
        printf("Nome: ");
        scanf("%[^\n]s", meusProdutos[i].nome);
        setbuf(stdin,NULL);
        printf("Setor: ");
        int setorDigitado;
		setbuf(stdin,NULL);		
		scanf("%d",&setorDigitado);
		meusProdutos[i].setor = setorDigitado;
        setbuf(stdin,NULL);
        printf("Quantidade: ");
        scanf("%d", &meusProdutos[i].quantidade);
        setbuf(stdin,NULL);
        printf("Preco: ");
        scanf("%f", &meusProdutos[i].preco);
	}
			
	return meusProdutos;
}

void apresentaUm(struct produtos *meusProdutos, int totalProdutos, int i){
	
	printf("\nProduto %d\n", i+1);
	printf("\nNome: %s", meusProdutos[i].nome);
    switch(meusProdutos[i].setor){
		case 1:
		printf("\nSetor: Frios");
		break;
		
		case 2:
		printf("\nSetor: Carnes");
		break;
		
		case 3:
		printf("\nSetor: Salgados");
		break;
		
		case 4:
		printf("\nSetor: Doces");
		break;
	}
    printf("\nQuantidade: %d", meusProdutos[i].quantidade);
    printf("\nPreco: R$%.2f\n\n", meusProdutos[i].preco);
	
}

void apresentaTodos(struct produtos *meusProdutos, int totalProdutos){
	int i;
	for(i=0;i<totalProdutos;i++){
		apresentaUm(meusProdutos,totalProdutos,i);
	}
}

float balanco(struct produtos *meusProdutos, int totalProdutos, float soma){
	soma += meusProdutos[totalProdutos].quantidade*meusProdutos[totalProdutos].preco;
	if(totalProdutos==0){
    return soma;
	}else{
    return balanco(meusProdutos, totalProdutos-1, soma);
}
}

void buscaporNome(struct produtos *meusProdutos, int totalProdutos){
	int i;
    char procura[15];

    printf("Digite o nome do produto que deseja ver: ");
    setbuf(stdin,NULL);
    scanf("%[^\n]s", procura);

    for(i=0;i<totalProdutos;i++){
        if(strcmp(procura, meusProdutos[i].nome) == 0){
            printf("\nNome: %s", meusProdutos[i].nome);
            printf("\nSetor: %d", meusProdutos[i].setor);
            printf("\nQuantidade: %d", meusProdutos[i].quantidade);
            printf("\nPreco: %.2f\n\n", meusProdutos[i].preco);
        }
    }
}

void buscaporSetor(struct produtos *meusProdutos, int totalProdutos){
int i;
int procura;
printf("Digite o setor do produto (1-4): ");
        setbuf(stdin,NULL);
        scanf("%d", &procura);
        for(i=0;i<totalProdutos;i++){
        if(meusProdutos[i].setor == procura){
            printf("\nNome: %s", meusProdutos[i].nome);
            printf("\nSetor: %d", meusProdutos[i].setor);
            printf("\nQuantidade: %d", meusProdutos[i].quantidade);
            printf("\nPreco: %.2f\n\n", meusProdutos[i].preco);
        }
    }
}

struct produtos * venda(struct produtos *meusProdutos, int totalProdutos){
	
	char produtoVenda[15];
	printf("\nDigite o nome do produto a ser vendido: ");
	setbuf(stdin,NULL);
	scanf("%[^\n]s", produtoVenda);
	
	int i;
	int j;
	for(i=0;i<totalProdutos;i++){
		if(strcmp(produtoVenda, meusProdutos[i].nome) == 0){
			meusProdutos[i].quantidade--;
			if(meusProdutos[i].quantidade==0){
				for(j=i;j<totalProdutos;j++){
					meusProdutos[j]=meusProdutos[j+1];
				}
				i--;
				meusProdutos[totalProdutos-1].quantidade=0;
				meusProdutos = realloc(meusProdutos, sizeof(struct produtos)*(totalProdutos-1));
			}
		}
	}
	
	return meusProdutos;
}