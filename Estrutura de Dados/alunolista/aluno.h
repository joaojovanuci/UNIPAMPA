#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Desc{
	struct No * primeiro;
	int tamanho;
};

struct No{
	struct No * prox;
	struct Aluno * info;
};

struct Aluno{
	char nome[30];
	int matricula;
};

struct Desc * CriaDesc(void);
struct No * CriaNo(struct Aluno * NovoAluno);
struct Aluno * CriaAluno(char* nome, int matricula);
struct Desc * Insere(struct Desc * MinhaLista, struct No * NovoNo, int posicao);

void Imprime(struct Desc * MinhaLista);
void printaNo(struct No * NoAtual);
void printaAluno(struct Aluno * info);