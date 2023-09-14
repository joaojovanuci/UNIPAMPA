#include "bib.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//INICIAR DESCRITOR
struct desc_LSE * CriaDescritor(void){
	struct desc_LSE * novoDescritor = (struct desc_LSE*)malloc(sizeof(struct desc_LSE));
	novoDescritor->tamanho=0;
	novoDescritor->primeiro=NULL;
	return novoDescritor;
}

//INICIAR NODO
struct nodo * CriaNodo(struct musica * infomusica){
	struct nodo * novoNodo = (struct nodo*)malloc(sizeof(struct nodo));
	novoNodo->info=infomusica;
	novoNodo->prox=NULL;
	return novoNodo;
}

//INICIA MUSICA
struct musica * CriaMusica(){
	
	struct musica * novaMusica = (struct musica*)malloc(sizeof(struct musica));
	/*
	strcpy(novaMusica->titulo,titulo);
	strcpy(novaMusica->artista,artista);
	strcpy(novaMusica->letra,letra);
	novaMusica->codigo=codigo;
	novaMusica->execucoes=execucoes;
	*/
	printf("\nTitulo: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", novaMusica->titulo);
	printf("\nArtista: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", novaMusica->artista);
	printf("\nLetra: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", novaMusica->letra);
	printf("\nCodigo: ");
	setbuf(stdin, NULL);
	scanf("%d", &novaMusica->codigo);
	printf("\nExecucoes: ");
	setbuf(stdin, NULL);
	scanf("%d", &novaMusica->execucoes);
	
	return novaMusica;
}

//IMPRIME MUSICA
void Imprime(struct desc_LSE *minhaLista){
	if(minhaLista->tamanho==0){
		printf("Lista vazia!\n\n");
	}else{
	struct nodo* aux = minhaLista->primeiro;
	while(aux!=NULL){
		printaNodo(aux);
		aux=aux->prox;
	}
	}
}

void printaNodo(struct nodo *nodoAtual){
	printaMusica(nodoAtual->info);
}

void printaMusica(struct musica *infomusica){
	printf("titulo: %s\n",infomusica->titulo);
	printf("artista: %s\n",infomusica->artista);
	printf("letra: %s\n",infomusica->letra);
	printf("codigo: %d\n",infomusica->codigo);
	printf("execucoes: %d\n\n",infomusica->execucoes);
}

//INSERE MUSICA NO DESCRITOR
struct desc_LSE *Insere(struct desc_LSE *minhaLista, struct nodo *novoNodo, int posicao){
	if((minhaLista->tamanho==0)&&(minhaLista->primeiro==NULL)){
		minhaLista->primeiro=novoNodo;
		minhaLista->tamanho++;
		return minhaLista;
	}else{
		if(posicao<=1){
			struct nodo *aux=minhaLista->primeiro;
			novoNodo->prox=aux;
			minhaLista->primeiro=novoNodo;
			minhaLista->tamanho++;
			return minhaLista;
		}else{
		if(posicao<=(minhaLista->tamanho)){
			struct nodo *aux=minhaLista->primeiro;
			struct nodo *ant=NULL;
			while((aux->prox!=NULL)&&(posicao>0)){
				ant=aux;
				aux=aux->prox;
				posicao--;
			}
			novoNodo->prox=aux;
			ant->prox=novoNodo;
			minhaLista->tamanho++;
			return minhaLista;
		}else{
			struct nodo *aux = minhaLista->primeiro;
			while(aux->prox!=NULL){
				aux=aux->prox;
			}
			aux->prox=novoNodo;
			minhaLista->tamanho++;
			return minhaLista;
		}
		}
	}
}

//REMOVE
struct desc_LSE *Remove(struct desc_LSE *minhaLista, int posicao){
		if((posicao<=1)||(minhaLista->tamanho==1)){
			struct nodo *aux=minhaLista->primeiro;
			minhaLista->primeiro=aux->prox;
			aux->prox=NULL;
			if(minhaLista->tamanho==1){
				minhaLista->primeiro=NULL;
			}
			free(aux);
			minhaLista->tamanho--;
			return minhaLista;
		}else{
			if(posicao>=minhaLista->tamanho){
				struct nodo *aux=minhaLista->primeiro;
				struct nodo *aux2=NULL;
				while(aux->prox!=NULL){
					aux2=aux;
					aux=aux->prox;
				}
				aux2->prox=NULL;
				free(aux);
				minhaLista->tamanho--;
				return minhaLista;
			}else{
				struct nodo *aux=minhaLista->primeiro;
				struct nodo *aux2=NULL;
				while((posicao>1)&&(aux!=NULL)){
					aux2=aux;
					aux=aux->prox;
					posicao--;
				}
				aux2->prox=aux->prox;
				aux->prox=NULL;
				free(aux);
				minhaLista->tamanho--;
				return minhaLista;
			}
		}
}

void Consulta(struct desc_LSE *minhaLista){
	if(minhaLista->tamanho==0){
		printf("Lista vazia!\n\n\n");
	}else{
	struct nodo* aux = minhaLista->primeiro;
	char procura[256];
	printf("\nNome do artista: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", procura);
	while(aux!=NULL){
		consultaNodo(aux, procura);
		aux=aux->prox;
	}
	}
}

void consultaNodo(struct nodo *nodoAtual, char * procura){
	consultaMusica(nodoAtual->info,procura);
}

void consultaMusica(struct musica *infomusica, char * procura){
	
	if(strcmp(procura, infomusica->artista)==0){
	printf("titulo: %s\n",infomusica->titulo);
	printf("artista: %s\n",infomusica->artista);
	printf("letra: %s\n",infomusica->letra);
	printf("codigo: %d\n",infomusica->codigo);
	printf("execucoes: %d\n\n",infomusica->execucoes);
	}
}