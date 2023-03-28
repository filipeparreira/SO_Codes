//Lê uma string e encontrar onde tem o %
//Quando encontrar o simbolo % tem que identificar que letra está apos ele 
//Conseguir um jeito de inserir uma string no meio de uma outra string 

#include <stdio.h>
#include <stdlib.h>

void imprimir(char *txt, char *complemento){
    int count = 0;
    
    while (txt[count] != '\0'){
        if (txt[count] == '%'){
            printf("%s", complemento);
            count += 2;
        }
        printf("%c", txt[count]);
        count++;
    }
}

int main(int argc, char const *argv[])
{
    char texto[] = "Olá, %s teste imprimir\n";
    char palavra[] = "mundo";
    imprimir(texto, palavra);
    return 0;
}