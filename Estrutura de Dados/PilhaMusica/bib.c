#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "bib.h"

struct desc_Pilha * CriaPilha(){
	struct desc_Pilha * novaPilha = (struct desc_Pilha*)malloc(sizeof(struct desc_Pilha));
	novaPilha->primeiro=NULL;
	novaPilha->tamanho=0;
	return novaPilha;
}

struct nodo * CriaNodo(struct musica *infomusica){
	struct nodo * novoNodo = (struct nodo*)malloc(sizeof(struct nodo));
	novoNodo->info=infomusica;
	novoNodo->prox=NULL;
	return novoNodo;
}

struct musica * CriaMusica(){
	struct musica * novaMusica = (struct musica*)malloc(sizeof(struct musica));
	
	printf("\nTitulo: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", novaMusica->titulo);
	printf("\nAlbum: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", novaMusica->album);
	printf("\nArtista: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", novaMusica->artista);
	printf("\nGenero: ");
	setbuf(stdin, NULL);
	scanf("%[^\n]s", novaMusica->genero);
	printf("\nAno: ");
	setbuf(stdin, NULL);
	scanf("%d", &novaMusica->ano);
	printf("\nExecucoes: ");
	setbuf(stdin, NULL);
	scanf("%d", &novaMusica->execucoes);
	
	return novaMusica;
}

struct desc_Pilha * PUSH(struct desc_Pilha * minhaPilha, struct nodo * novoNodo){
	if(minhaPilha->tamanho==0){
		minhaPilha->primeiro=novoNodo;
		minhaPilha->tamanho++;
		return minhaPilha;
	}else{
		novoNodo->prox=minhaPilha->primeiro;
		minhaPilha->primeiro=novoNodo;
		minhaPilha->tamanho++;
		return minhaPilha;
	}
}

struct desc_Pilha * POP(struct desc_Pilha * minhaPilha){
		if(minhaPilha->tamanho==1){
			struct nodo * aux = minhaPilha->primeiro;
			minhaPilha->primeiro=NULL;
			free(aux);
			minhaPilha->tamanho--;
			return minhaPilha;
		}else{
			struct nodo * aux = minhaPilha->primeiro;
			minhaPilha->primeiro=aux->prox;
			aux->prox=NULL;
			free(aux);
			minhaPilha->tamanho--;
			return minhaPilha;
		}
}

void Imprime(struct desc_Pilha * minhaPilha){
		struct nodo* aux = minhaPilha->primeiro;
		while(aux!=NULL){
			printaNodo(aux);
			aux=aux->prox;
	}
}

void printaNodo(struct nodo *nodoAtual){
	printaMusica(nodoAtual->info);
}

void printaMusica(struct musica *infomusica){
	printf("Titulo: %s\n",infomusica->titulo);
	printf("Album: %s\n",infomusica->album);
	printf("Artista: %s\n",infomusica->artista);
	printf("Genero: %s\n",infomusica->genero);
	printf("Ano: %d\n",infomusica->ano);
	printf("Execucoes: %d\n\n",infomusica->execucoes);
}

int EMPTY(struct desc_Pilha * minhaPilha){
	if((minhaPilha->tamanho==0)){
		return 0;
	}else{
		return 1;
	}
}

struct nodo * TOP(struct desc_Pilha * minhaPilha){
	struct nodo * topoPilha = (struct nodo*)malloc(sizeof(struct nodo));
	topoPilha=minhaPilha->primeiro;
}