#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "aluno.h"

int main(){

struct Desc * MinhaLista = CriaDesc();
struct Aluno * NovoAluno = CriaAluno("Joao", 001);
struct No * NovoNo = CriaNo(NovoAluno);
MinhaLista = Insere(MinhaLista,NovoNo, 10);

printf("###################");
Imprime(MinhaLista);
printf("###################");

return 0;	
}