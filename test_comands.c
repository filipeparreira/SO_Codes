#include <stdio.h>
#include <stdlib.h>
//#include <unistd.h>
#include <stdarg.h>

#define typeof(var) _Generic( (var),\
char: "Char",\
int: "Integer",\
float: "Float",\
char *: "String",\
void *: "Pointer",\
default: "Undefined")


int main(int argc, char const *argv[])
{
    char palavra[] = "Palavra: %.2f ";
    char aux[6];
    char tipos[4];
    int count = 0;
    /*
    aux[0] = palavra[9];
    aux[1] = palavra[10];
    aux[2] = palavra[11];
    aux[3] = palavra[12];
    aux[4] = palavra[13];
    aux[5] = '\0';
    */
    while(palavra[count] != '\0'){
        if (palavra[count] == '%'){
            int count_begin = count;
            while (palavra[count] != ' '){
                count++;
            }
            printf("Count begin : %d\n", count_begin);
            printf("Count: %d\n", count);
            
            int i = 0;
            while (count_begin <= count){
                aux[i] = palavra[count_begin];
                count_begin++;
                i++;
            }
            aux[i+1] = '\0';
            
        }
        count++;
    }

    printf("%s\n", aux);
    return 0;
}


/*
void teste_tipo(char *txt, char *tipos){
    int count = 0;
    int count_pam = 0;
    //Percorre a string inteira
    while(txt[count] != '\0'){
        //Encontrou um parametro
        if (txt[count] == '%'){
            //Percorre a string até encontrar o ' ' (percorre até o final de uma palavra)
            while (txt[count] != ' '){
                if (txt[count] == 'c' || txt[count] == 'i' || txt[count] == 'f' || txt[count] == 'd' || txt[count] == 's'){
                    //Se o parametro está correto, criar um laço de repetição que armazene todas as letras entre
                    // o '%' e o ' '
                    tipos[count] = txt[count];
                }
                count++;
            }
        }
        count++;
    }
}


int qtde_pam(char *txt){
    int count = 0;
    int count_pam = 0;
    while(txt[count] != '\0'){
        if (txt[count] == '%'){
            count_pam++;
            count+=2;
        }
        count++;
    }
    return count_pam;
}

void teste_arg(char *txt, ...){
    va_list lista;
    int tam_pam = qtde_pam(txt);
    char tipos[tam_pam];
    char *parametros[tam_pam];
    va_start(lista, tam_pam);
    for (int i = 0; i < tam_pam; i++) {
        char* string_atual = va_arg(lista, char*);
        parametros[i] = string_atual;
    }      
    va_end(lista);
    teste_tipo(txt, tipos);
    printf("%c", tipos[0]);
    
    

}

int main(int argc, char const *argv[]){
    teste_arg(" Olá, %s!!!\n", "mundoooo");

    return 0;
}*/