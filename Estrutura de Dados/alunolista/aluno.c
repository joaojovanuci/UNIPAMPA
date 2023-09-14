#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "aluno.h"

struct Desc * CriaDesc(void){
	struct Desc * NovoDesc = (struct Desc*)malloc(sizeof(struct Desc));
	NovoDesc->primeiro=NULL;
	NovoDesc->tamanho=0;
	return NovoDesc;
};

struct No * CriaNo(struct Aluno * NovoAluno){
	struct No * NovoNo = (struct No*)malloc(sizeof(struct No));
	NovoNo->info=NovoAluno;
	NovoNo->prox=NULL;
};

struct Aluno * CriaAluno(char* nome, int matricula){
	struct Aluno * NovoAluno = (struct Aluno*)malloc(sizeof(struct Aluno));
	strcpy(NovoAluno->nome, nome);
	NovoAluno->matricula=matricula;
	return NovoAluno;
};

struct Desc * Insere(struct Desc * MinhaLista, struct No * NovoNo, int posicao){
	//INICIO DA LISTA
	if((MinhaLista->tamanho==0)&&(MinhaLista->primeiro==NULL)){
		MinhaLista->primeiro=NovoNo;
		MinhaLista->tamanho++;
		return MinhaLista;
	}else{
		//MEIO DA LISTA
		if(posicao<(MinhaLista->tamanho)){
			struct No * aux = MinhaLista->primeiro;
			struct No * ant = NULL;
			while((aux->prox!=NULL)&&(posicao>0)){
				ant=aux;
				aux=aux->prox;
				posicao--;
			}
			NovoNo->prox=aux;
			ant->prox=NovoNo;
			MinhaLista->tamanho++;
			return MinhaLista;
		}else{
			//FINAL DA LISTA
			struct No * aux = MinhaLista->primeiro;
			while(aux->prox!=NULL){
				aux=aux->prox;
			}
			aux->prox=NovoNo;
			MinhaLista->tamanho++;
			return MinhaLista;
		}
	}
}

void Imprime(struct Desc * MinhaLista){
	struct No * aux = MinhaLista->primeiro;
	while(aux!=NULL){
		printaNo(aux);
		aux=aux->prox;
	}
}

void printaNo(struct No * NoAtual){
	printaAluno(NoAtual->info);
}

void printaAluno(struct Aluno * info){
	printf("\nNome: %s",info->nome);
	printf("\nMatricula: %d\n",info->matricula);
}