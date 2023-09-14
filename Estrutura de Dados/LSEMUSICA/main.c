#include "bib.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

int opcao=-1;
int posicao;

while(opcao!=0){
	printf("\n0 - Sair\n1 - Criar Lista\n2 - Inserir\n3 - Imprimir\n4 - Remove\n5 - Consulta\nEscolha a opcao: \n");
	scanf("%d", &opcao);
	switch(opcao){
		case 0:
		printf("Saindo...!");
		return 0;
		break;
		case 1:
		printf("Lista criada!\n");
		struct desc_LSE *minhaLista = CriaDescritor();
		break;
		case 2:
		printf("Inserindo musica!\n");
		printf("Qual posicao inserir: ");
		setbuf(stdin, NULL);
		scanf("%d", &posicao);
		struct musica *novaMusica = CriaMusica();
		struct nodo *novoNodo = CriaNodo(novaMusica);
		minhaLista=Insere(minhaLista,novoNodo,posicao);
		break;
		case 3:
		printf("Imprimir musicas\n");
		printf("#######MUSICAS##############\n\n");
		Imprime(minhaLista);
		printf("##############################\n");
		break;
		case 4:
		printf("Removendo musica!\n");
		if((minhaLista->tamanho==0)&&(minhaLista->primeiro==NULL)){
		printf("Nada a remover");
		}else{
		printf("Qual posicao remover: ");
		setbuf(stdin, NULL);
		scanf("%d", &posicao);
		minhaLista=Remove(minhaLista,posicao);
		}
		break;
		case 5:
		printf("Consultando...");
		Consulta(minhaLista);
		break;
	}
}

return 0;
}