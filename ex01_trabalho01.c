//Lê uma string e encontrar onde tem o %
//Quando encontrar o simbolo % tem que identificar que letra está apos ele 
//Conseguir um jeito de inserir uma string no meio de uma outra string 

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int strtam(char *txt){
    int count = 0;
    while(txt[count] != '\0'){
        count++;
    }
    return count;
}

void verificaTipo(char *txt){
    int count = 0;
    int count_aux;
    char tipo[4];
    while (txt[count] != '\0'){
        if (txt[count] == '%'){
            count_aux = count;
            while(txt[count] != ' '){
                count++;
            }
            count_aux -= count;
            for (int i = count_aux; i < count; i++){
                tipo[i] = txt[i];
            }
        }
        count++;
    }
    printf("%s", tipo);
}

void imprimir(char *txt, char *complemento, char *complemento2){
    int count = 0;
    int count_comp = 0;
    char letra[1];
    char *complementos[] = {complemento, complemento2};

    //Verificar se o tipo passado é o correto 
    verificaTipo(txt);
    
    //Insere uma string no meio do txt
    while (txt[count] != '\0'){
        if (txt[count] == '%'){
            int tamanho = strtam(complementos[count_comp]);
            write(1, complementos[count_comp], tamanho);
            count += 2;
            count_comp++;
        }
        letra[0] = txt[count];
        write(1, letra, 1);
        count++;
    }
}

int main(int argc, char const *argv[])
{
    imprimir("%s %s", "Olá, mundo!!!!!\n\n", "Olá, mundo 2\n\n");
    return 0;
}