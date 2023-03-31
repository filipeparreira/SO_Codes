#include <stdio.h>
#include <stdlib.h>
//#include <unistd.h>
#include <stdarg.h>
#include <string.h>

#define typeof(var) _Generic( (var),\
char: "Char",\
int: "Integer",\
float: "Float",\
char *: "String",\
void *: "Pointer",\
default: "Undefined")


char **teste_tipo(char *txt, char **tipos){
    int count = 0;
    int count_pam = 0;
    char aux[6];

    while(txt[count] != '\0'){

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

int main(int argc, char const *argv[])
{
    char palavra[] = "Palavra %.2f %d %i %d %.2f";
    char **tipos = (char **) malloc(5 * sizeof(char *));
    tipos = teste_tipo(palavra, tipos);
    if (strchr(tipos[0], 'f') != NULL){
        printf("Entrou no if\n");
    } 

    return 0;
}


/*
int main(int argc, char const *argv[])
{
    char palavra[] = "Palavra: %.2f";
    char aux[6];
    char tipos[4][6];
    int count = 0;
    
    while(palavra[count] != '\0'){
        if (palavra[count] == '%'){
            int count_begin = count;
            while (palavra[count] != ' '){
                count++;
                if (palavra[count] == '\0' || palavra[count] == '\n'){
                    break;
                }
            }
            
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
    strcpy(tipos[0], aux);
    printf("%s\n", tipos[0]);
    return 0;
}
*/

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