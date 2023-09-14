// Lista 1
// 11/05/2022
// João Eduardo Fabris Jovanuci (joaojovanuci.aluno@unipampa.edu.br)

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ** criaMatriz(int m, int n);
void leiaMatriz(int **mat, int m, int n);
int somaMatriz(int **mat, int m, int n);
int * colunaMat(int **mat, int m, int n, int ncoluna);
int ** liberaMatriz(int **mat, int ncoluna);
void imprimeMatriz(int **mat, int m, int n);
void imprimeVet (int *vet, int n);


int main(){

    int *vet;
    int ncoluna;
    int m;
    int n;
    int **mat = NULL;
    int opcao = 9;

    while("opcao=!0"){

        printf("Escolha sua opcao \n");
        printf(" 0 - Sair\n 1 - Criar matriz\n 2 - Ler a matriz\n 3 - Somar a matriz\n 4 - Imprimir coluna\n 5 - Imprimir matriz\n 6 - Liberar matriz\n ");
        printf("Opcao: ");
        scanf("%d", &opcao);

        switch(opcao){
        case 0: 
        printf("\nSaindo do programa...\n");
        return 0;
        break;
        case 1:
            printf("Digite o tamanho da matriz\n");
            printf("m: ");
            scanf("%d", &m);
            printf("n: ");
            scanf("%d", &n);
            mat = criaMatriz(m,n);
        break;
        case 2:leiaMatriz(mat,m,n);
        break;
        case 3:
            printf("Soma da matriz: %d\n", somaMatriz(mat,m,n));
        break;
        case 4:
        printf("Escreva qual coluna você deseja ver [1 - %d]: ", m);
        scanf("%d", &ncoluna);
        vet = colunaMat(mat,m,n,ncoluna);
        imprimeVet (vet,n);
        break;
        case 5:imprimeMatriz(mat,m,n);
        break;
        case 6:liberaMatriz(mat, ncoluna);
        break;



        }
    }


return 0;
}

int ** criaMatriz(int m, int n){
    int i;
    int **mat;

    mat =malloc(m*sizeof(int*));
    for(i=0;i<m;i++){
    mat[i] =malloc (n * sizeof (int));
    }


    return mat;
}

void leiaMatriz(int **mat, int m, int n){
    int i, j;
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            printf("Posicao [%d][%d]: ", i, j);
            scanf("%d",&mat[i][j]);
        }
    }
}

int somaMatriz(int **mat, int m, int n){
    int soma=0;
    int i, j;
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            soma= soma+mat[i][j];
        }
    }
    return soma;
}

int * colunaMat(int **mat, int m, int n, int ncoluna){
    int i;
    int *vet;
    vet = malloc((n*ncoluna)*sizeof(int));
    for(i=0;i<n;i++){
        vet[i] = mat[i][ncoluna-1];
    }
    return vet;
}


int ** liberaMatriz(int **mat, int ncoluna){
    free(mat);
    return mat;
}

void imprimeMatriz(int **mat, int m, int n){
    int i, j;
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
           printf("%d\t", mat[i][j]);
        }
        printf("\n");
    }
}


void imprimeVet (int *vet, int n){
    int i;
    for(i=0;i<n;i++){
        printf(" %d \n", vet[i]);
    }
}
