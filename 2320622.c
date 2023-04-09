#include <unistd.h>
#include <stdarg.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

// Função que desempenha o mesmo proposito da strlen
int strtam(char *txt){
    int count = 0;
    while(txt[count] != '\0'){
        count++;
    }
    return count;
}

//Função que armazena os parametros internos da string no vetor tipos
char **armazena_tipo(char *txt, char **tipos){
    int count = 0;
    int count_pam = 0;
    char aux[6];

    //Percorre a string até o fim
    while(txt[count] != '\0'){
        //Encontrou o %? Armazena no vetor tipos até o fim da palavra
        if (txt[count] == '%'){
            int count_begin = count;
            tipos[count_pam] = (char *) malloc(6 * sizeof(char));
            while (txt[count] != ' '){
                count++;
                if (txt[count] == '\0' || txt[count] == '\n'){
                    break;
                }
            }
            int i = 0;
            while (count_begin <= count){
                aux[i] = txt[count_begin];
                count_begin++;
                i++;
            }
            aux[i+1] = '\0';
            strncpy(tipos[count_pam], aux, 6);
            count_pam++;
            memset(aux, '\0', sizeof(aux));
        }
        count++;
    }
    return tipos;
}

//Retorna a quantidade de parametros internos da string
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

//Imprime o inteiro convertendo ele manualmente para string
void imprime_int(va_list lista_parametros){
    int numero = va_arg(lista_parametros, int);
    char numero_char[10];
    int i = 0;

    //Percorre todo o inteiro, digito por digito e armazena no auxiliar 'numero_char'
    do {
        numero_char[i++] = numero % 10 + '0';
        numero /= 10;
    } while (numero > 0);

    numero_char[i] = '\0';

    //Inverte a string
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

//Imprime string
void imprime_str(va_list lista_parametros){
    char* frase = va_arg(lista_parametros, char*);
    int tamanho = strtam(frase);
    write(1, frase, tamanho);
}

//imprime uma letra
void imprime_char(va_list lista_parametros){
    char* letra = va_arg(lista_parametros, char*);
    write(1, &letra, sizeof(letra));
}

//Imprime um float
void imprime_float(va_list lista_parametros, char *tipo){
    double numero = va_arg(lista_parametros, double);
    char str_float[50];
    int tamanho = snprintf(str_float, sizeof(str_float), tipo, numero);    
    write(1, str_float, tamanho-1);
}

//Função printf
void imprimir(char *txt, ...){
    //Variaveis locais 
    int count = 0;
    int count_comp = 0;
    int len_pam = qtde_parametros(txt);
    char letra[1];
    char *complementos[len_pam];
    char **tipos = (char **) malloc(len_pam * sizeof(char *));
    
    //Obtem todos os tipos passados
    tipos = armazena_tipo(txt, tipos);
    va_list lista_parametros;
    va_start(lista_parametros, len_pam);
        
    //Insere uma string no meio do txt
    while (txt[count] != '\0'){
        if (txt[count] == '%'){
            //Obtem o tamanho da string do tipo para avançar o contador 
            int tam_comp = strtam(tipos[count_comp]) - 1;
            //Verifica no vetor tipos[] qual o tipo do parametro
            if (strchr(tipos[count_comp], 'd') != NULL || strchr(tipos[count_comp], 'i') != NULL){
                count+=2;
                imprime_int(lista_parametros);
            }
            if (strchr(tipos[count_comp], 's') != NULL){
                count+=2;
                imprime_str(lista_parametros);
            }
            if (strchr(tipos[count_comp], 'c') != NULL){
                count+=2;
                imprime_char(lista_parametros);
            }
            if (strchr(tipos[count_comp], 'f') != NULL){
                count += tam_comp;
                imprime_float(lista_parametros, tipos[count_comp]);
            }
            count_comp++;
        }
        letra[0] = txt[count];
        write(1, letra, 1);
        count++;
    }
    va_end(lista_parametros);
    free(tipos);
}

int main(int argc, char const *argv[])
{
    imprimir("Numeros sortidos %.3f %d %d %d %d e um caracter %c\n",2.34,2143, 25, 21, 13, 'a');

    imprimir("Char: %.3f\n", 2.34);
    return 0;
}