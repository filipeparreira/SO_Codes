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


void teste_tipo(char *txt, char *tipos){
    int count = 0;
    int count_pam = 0;
    while(txt[count] != '\0'){
        if (txt[count] == '%'){
            while (txt[count] != ' '){
                if (txt[count] == 'c' || txt[count] == 'i' || txt[count] == 'f' || txt[count] == 'd' || txt[count] == 's'){
                    tipos[count_pam] = txt[count];
                    count_pam++;
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
    
    

}

int main(int argc, char const *argv[]){
    teste_arg(" Olá %c, %s mundooo  %s %s!!!\n", 1, 2, 3, 4);

    return 0;
}