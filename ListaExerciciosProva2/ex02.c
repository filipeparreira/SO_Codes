#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    int pid, cano1[2], cano2[2], cano3[2];
    pipe(cano1);
    pipe(cano2);
    pipe(cano3);
    char *mensagem = "mensagem passada atraves de canos";

    pid = fork();
    if (pid == 0){
        //filho 1
        char buffer2[1024];
        pid = fork();
        if (pid == 0){
            //filho 2
            char buffer1[1024];
            pid = fork();
            
            if (pid == 0){
                //filho 3
                write(cano1[1], mensagem, strlen(mensagem) + 1);
            } 
            read(cano1[0], buffer1, strlen(mensagem) + 1);
            write(cano2[1], buffer1, strlen(mensagem) + 1);
        }
        read(cano2[0], buffer2, strlen(mensagem) + 1);
        write(cano3[1], buffer2, strlen(mensagem) + 1);
    } else{
        //pai 
        char buffer3[1024];
        read(cano3[0], buffer3, strlen(mensagem) + 1);
        printf("Mensagem passada: %s\n", buffer3);
    }

    return 0;
}
