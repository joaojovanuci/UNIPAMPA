#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct desc_Pilha{
struct nodo *primeiro;
int tamanho;
};

struct nodo{
struct nodo *prox;
struct musica *info;
};

struct musica{
char titulo[50];
char album[50];
char artista[50];
char genero [10];
int ano;
int execucoes;
};

struct desc_Pilha * CriaPilha();
struct nodo * CriaNodo(struct musica *infomusica);
struct musica * CriaMusica();
struct desc_Pilha * PUSH(struct desc_Pilha * minhaPilha, struct nodo * novoNodo);
struct desc_Pilha * POP(struct desc_Pilha * minhaPilha);
struct nodo * TOP(struct desc_Pilha * minhaPilha);
int EMPTY(struct desc_Pilha * minhaPilha);
void Imprime(struct desc_Pilha * minhaPilha);
void printaNodo(struct nodo *nodoAtual);
void printaMusica(struct musica *infomusica);