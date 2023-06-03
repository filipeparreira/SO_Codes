#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    int pid, status;
    int cano1[2], cano2[2], cano3[2];
    char *mensagem = "Mensagem do ultimo processo para o primeiro processo";
    char buffmensagem[1024];
    pipe(cano1);
    pipe(cano2);
    pipe(cano3);

    pid = fork();
    if(pid == 0){
        //segundo processo
        char buffmesangem2[1024];
        pid = fork();
        if (pid == 0){
            //quarto processo
            write(cano1[1], mensagem, strlen(mensagem)+1);
            //exit(1);
        }else{
            //terceito processo
            //wait(&status);
            read(cano1[0], buffmensagem, strlen(mensagem)+1);
            printf("Terceiro processo: %s\n", buffmensagem);
            write(cano2[1], buffmensagem, strlen(mensagem)+1);
            exit(1);
        }
        wait(&status);      
        read(cano2[0], buffmesangem2, strlen(mensagem)+1);
        printf("Segundo processo: %s\n", buffmesangem2);
        write(cano3[1], buffmesangem2, strlen(mensagem)+1);
        exit(1);            
    }else{
        //Primeiro processo
        char buffmensagem3[1024];
        wait(&status);
        read(cano3[0], buffmensagem3, strlen(mensagem)+1);
        printf("Mensagem contida no pipe: %s\n", buffmensagem3);
        exit(1);
    }

    return 0;
}
