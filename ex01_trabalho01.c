//Lê uma string e encontrar onde tem o %
//Quando encontrar o simbolo % tem que identificar que letra está apos ele 
//Conseguir um jeito de inserir uma string no meio de uma outra string 

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdarg.h>
#define typeof(var) _Generic( (var),\
char: "Char",\
int: "Integer",\
float: "Float",\
char *: "String",\
void *: "Pointer",\
default: "Undefined")


int strtam(char *txt){
    int count = 0;
    while(txt[count] != '\0'){
        count++;
    }
    return count;
}

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

int qtde_parametros(char *txt){
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

/*
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
}*/

void imprime_int(va_list lista_parametros){
    int numero = va_arg(lista_parametros, int);
    char numero_char[10];
    int i = 0;

    // Converte o número inteiro em uma string manualmente
    do {
        numero_char[i++] = numero % 10 + '0';
        numero /= 10;
    } while (numero > 0);

    numero_char[i] = '\0';

    // Inverte a string
    int j = 0;
    char tmp;
    while (j < i / 2) {
        tmp = numero_char[j];
        numero_char[j] = numero_char[i - j - 1];
        numero_char[i - j - 1] = tmp;
        j++;
    }

    int tamanho = strtam(numero_char);
    write(1, numero_char, tamanho);
}

void imprime_str(va_list lista_parametros){
    char* frase = va_arg(lista_parametros, char*);
    int tamanho = strtam(frase);
    write(1, frase, tamanho);
}

void imprime_char(va_list lista_parametros){
    char* letra = va_arg(lista_parametros, char*);
    
    write(1, &letra, sizeof(letra));
}

void imprime_float(va_list lista_parametros){
    double numero = va_arg(lista_parametros, double);
    char str_float[50];
    int tamanho = snprintf(str_float, sizeof(str_float), "%.2f", numero);
    write(1, str_float, tamanho);
}

//Fazer a função receber parametros variados
void imprimir(char *txt, ...){
    int count = 0;
    int count_comp = 0;
    int len_pam = qtde_parametros(txt);
    char letra[1];
    char *complementos[len_pam];
    char tipos[len_pam];
    
    //Obtem todos os tipos passados
    teste_tipo(txt, tipos);
    printf("%c\n", tipos[0]);
    va_list lista_parametros;
    va_start(lista_parametros, len_pam);
    //for (int i = 0; i < len_pam; i++) {
      //  char* string_atual = va_arg(lista_parametros, char*);
        //complementos[i] = string_atual;
    //}


    
    
    
    //Insere uma string no meio do txt
    while (txt[count] != '\0'){
        if (txt[count] == '%'){
            //Verifica no vetor tipos[] qual o tipo do parametro
            if (tipos[count_comp] == 'd' || tipos[count_comp] == 'i'){
                imprime_int(lista_parametros);
            }
            if (tipos[count_comp] == 's'){
                imprime_str(lista_parametros);
            }
            if (tipos[count_comp] == 'c'){
                imprime_char(lista_parametros);
            }
            if (tipos[count_comp] == 'f'){
                imprime_float(lista_parametros);
            }
            count += 2;
            count_comp++;
        }
        letra[0] = txt[count];
        write(1, letra, 1);
        count++;
    }
    va_end(lista_parametros);
}

int main(int argc, char const *argv[])
{
    imprimir("Olá, %s\n\n", "mundo!!");
    return 0;
}