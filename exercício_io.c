#include <unistd.h> 
#include <stdio.h>
#include <signal.h>
#include <stdlib.h>

int main(){
    long int ra;
    char *nome = (char *) malloc(20 * sizeof(char));

    write(1, "Digite o nome do aluno: ", 25);
    read(0, nome, 20);

    write(1, "Digite o RA do aluno: ", 23);
    read(0, &ra, sizeof(long int));

    write(1, "Nome: ", 7);
    write(1, nome, sizeof(nome));
    write(1, "RA: ", 5);
    write(1, &ra, sizeof(long int));

    return 0;
}

