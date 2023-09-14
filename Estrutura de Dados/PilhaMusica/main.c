#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "bib.h"

int main(){

int opcao=-1;
int posicao;

while(opcao!=0){
	printf("\n0 - Sair\n1 - Criar Pilha\n2 - PUSH\n3 - POP\n4 - Imprimir\n5 - EMPTY\n6 - TOP\nEscolha a opcao: ");
	scanf("%d", &opcao);
	printf("\n");
	switch(opcao){
		case 0:
		printf("Saindo...!\n");
		return 0;
		break;
		case 1:
		printf("Criando pilha!\n");
		struct desc_Pilha *minhaPilha = CriaPilha();
		break;
		case 2:
		printf("PUSH\n");
		struct musica * novaMusica = CriaMusica();
		struct nodo * novoNodo = CriaNodo(novaMusica);
		minhaPilha = PUSH(minhaPilha, novoNodo);
		break;
		case 3:
		printf("POP\n");
		if(EMPTY(minhaPilha)==1){
			minhaPilha = POP(minhaPilha);
		}else{
		printf("Lista Vazia\n");
		}
		break;
		case 4:
		printf("Imprimir\n");
		if(EMPTY(minhaPilha)==1){
		printf("#######MUSICAS##############\n\n");
		Imprime(minhaPilha);
		printf("##############################\n");
		}else{
			printf("Lista Vazia\n");
		}
		break;
		case 5:
		printf("Empty [0 - TRUE, 1 - FALSE]: ");
		printf("%d", EMPTY(minhaPilha));
		break;
		case 6:
		printf("TOP: \n");
		if(EMPTY(minhaPilha)==1){
		struct nodo *topoPilha = TOP(minhaPilha);
		printaNodo(topoPilha);
		}else{
			printf("\nLista vazia\n");
		}
		break;
	}
}
return 0;
}