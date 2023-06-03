#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    int pid, status;
    int cano[2];
    char *mensagemP1 = "Mensagem do filho 1 para o processo pai";
    char *mensagemP2 = "Mensagem do filho 2 para o processo pai";
    pipe(cano);
    pid = fork();
    char mensagem[1024];


    if (pid == 0){
        write(cano[1], mensagemP1, strlen(mensagemP1));
        exit(0);
    }else{
        wait(&status);
        read(cano[0], mensagem, strlen(mensagemP1));
        printf("Mensagem do filho 1: %s\n", mensagem);
        pid = fork();
        if(pid == 0){
            write(cano[1], mensagemP2, strlen(mensagemP2));
            exit(0);
        }
        wait(&status);
        read(cano[0], mensagem, strlen(mensagemP2));        
        printf("Mensagem do filho 2: %s\n", mensagem);
    }
    return 0;
}
