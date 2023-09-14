#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct desc{
	struct No *primeiro;
	int tamanho;
};

struct No{
	struct No *prox;
	struct tel *info;
};

struct tel{
	int num;
	char nome[36];
};

struct desc * Criadesc(void);
struct No * CriaNo(struct tel * telefone);
struct tel * CriaTel(int num, char *nome);
struct desc * Insere(struct desc * MinhaLista, struct No * NovoNo, int posicao);
void imprime(struct desc * MinhaLista);
void printaNo(struct No * NoAtual);
void printaTel(struct tel * telefone);