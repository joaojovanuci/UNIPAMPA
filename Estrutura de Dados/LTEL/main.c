#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tel.h"

int main(){
	
	struct desc *MinhaLista = Criadesc();
	struct tel *NovoTel = CriaTel(991114758, "Joao Sul");
	struct No *NovoNo = CriaNo(NovoTel);
	MinhaLista=Insere(MinhaLista,NovoNo, 10);
	
	printf("\n#######TELEFONES##############\n");
	imprime(MinhaLista);
	printf("\n##############################\n");
	
	struct tel *NovoTel1 = CriaTel(992489002, "Joao Minas");
	struct No *NovoNo1 = CriaNo(NovoTel1);
	MinhaLista=Insere(MinhaLista,NovoNo1, 10);
	
	printf("\n#######TELEFONES##############\n");
	imprime(MinhaLista);
	printf("\n##############################\n");
	
	return 0;
}