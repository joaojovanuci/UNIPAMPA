#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct desc_LSE{
struct nodo *primeiro;
int tamanho;
};

struct nodo{
struct nodo *prox;
struct nodo *ant;
struct musica *info;
};

struct musica{
char titulo[256];
char artista[256];
char letra[256];
int codigo;
int execucoes;
};

struct desc_LSE * CriaDescritor(void);
struct nodo * CriaNodo(struct musica * infomusica);
struct musica * CriaMusica();
struct desc_LSE *Insere(struct desc_LSE *minhaLista, struct nodo *novoNodo, int posicao);
struct desc_LSE *Remove(struct desc_LSE *minhaLista, int posicao);
void Consulta(struct desc_LSE *minhaLista);
void Imprime(struct desc_LSE *minhaLista);
void printaNodo(struct nodo *nodoAtual);
void printaMusica(struct musica *infomusica);
void Consulta(struct desc_LSE *minhaLista);
void consultaNodo(struct nodo *nodoAtual, char * procura);
void consultaMusica(struct musica *infomusica, char * procura);