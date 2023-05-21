#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    char *mensagem1 = "Mensagem do filho 1 para o pai!!\n";
    char *mensagem2 = "Mensagem do filho 2 para o pai!!\n";
    int pid, status;
    char buffer[1024];
    int pip[2];
    pipe(pip);
    pid = fork();
    if (pid == 0){
        //processo filho 1
        write(pip[1], mensagem1, strlen(mensagem1)+1);

    }else {
        //processo pai 
        read(pip[0], buffer, strlen(mensagem1)+1);
        printf("Mensagem do filho 1: %s\n", buffer);
        pid = fork();
        if (pid == 0){
            //processo filho 2
            write(pip[1], mensagem2, strlen(mensagem2)+1);
        }
        read(pip[0], buffer, strlen(mensagem2) + 1);
        printf("Mensagem do filho 2: %s\n", buffer);
    }
    return 0;
}
