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
    char *parametros[tam_pam];
    va_start(lista, tam_pam);
    for (int i = 0; i < tam_pam; i++) {
        char* string_atual = va_arg(lista, char*);
        parametros[i] = string_atual;
    }

    
    
    
    va_end(lista);
}

int main(int argc, char const *argv[]){
    teste_arg("%s, %s   %s!!!\n", "Olá", "Mundo", 4, 67, 4.6, "feliz");

    return 0;
}