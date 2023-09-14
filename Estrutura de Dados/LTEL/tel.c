#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tel.h"

//Criando descritor
struct desc * Criadesc(void){
	struct desc * Novodesc = (struct desc*)malloc(sizeof(struct desc));
	Novodesc->tamanho=0;
	Novodesc->primeiro=NULL;
	return Novodesc;
};

//Criando No
struct No * CriaNo(struct tel * Novotel){
	struct No * NovoNo = (struct No*)malloc(sizeof(struct No));
	NovoNo->info=Novotel;
	NovoNo->prox=NULL;
	return NovoNo;
};

//CriaTel
struct tel * CriaTel(int num, char *nome){
	struct tel * NovoTel = (struct tel*)malloc(sizeof(struct tel));
	NovoTel->num=num;
	strcpy(NovoTel->nome,nome);
	return NovoTel;
};

//Inserir
struct desc * Insere(struct desc * MinhaLista, struct No * NovoNo, int posicao){
	//Lista Vazia
	if((MinhaLista->tamanho==0)&&(MinhaLista->primeiro==NULL)){ 
		MinhaLista->primeiro=NovoNo;
		MinhaLista->tamanho++;
		return MinhaLista;
	}else{
	//Meio da Lista
	if(posicao<(MinhaLista->tamanho)){ //Se o tamanho da lista for menor que a posicao que eu desejo colocar
		struct No *aux = MinhaLista->primeiro; //auxiliar = primeiro
		struct No *ant = NULL; //auxialiar anterior = null
		while((aux->prox!=NULL)&&(posicao>0)){ //enquanto o proximo do auxiliar = NULL e a posicao for maiorr que 0
			ant=aux; //anterior = auxiliar
			aux=aux->prox; //auxiliar = proximo do auxiliar
			posicao--; //diminui posicao
		}
		NovoNo->prox=aux; //Novo No proximo = auxiliar
		ant->prox=NovoNo; //anterior do proximo = Novo No
		MinhaLista->tamanho++; //Aumenta o tamanho da lista
		
		return MinhaLista;
	}else{
		//Final da Lista
		struct No * aux = MinhaLista->primeiro;
		while(aux->prox!=NULL){
			aux=aux->prox;
		}
		aux->prox=NovoNo;
		MinhaLista->tamanho++;
		return MinhaLista;
	  }
	}
};

//Imprimir
void imprime(struct desc * MinhaLista){
	struct No * aux = MinhaLista->primeiro;
	while(aux!=NULL){
		printaNo(aux);
		aux=aux->prox;
	}
};
void printaNo(struct No * NoAtual){
		printaTel(NoAtual->info);
};
void printaTel(struct tel * telefone){
	printf("\nNome: %s", telefone->nome);
	printf("\nTelefone: %d\n", telefone->num);
};