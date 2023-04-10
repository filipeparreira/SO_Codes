#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>


int main(int argc, char const *argv[]){
    int pid, status;
    int resfat = 1;    
    pid = fork();
    if (pid < 0){
        printf("Erro ao criar o processo\n");
    }else if (pid == 0){
        pid = fork();
        if (pid == 0){
            pid = fork();
            if (pid == 0){
                resfat = resfat * 2;
                exit(resfat);
            }
            wait(&status);
            resfat = WEXITSTATUS(status) * 3;
            exit(resfat);
        }
        wait(&status);
        resfat = WEXITSTATUS(status) * 4;
        exit(resfat);
    }else{
        wait(&status);
        resfat = WEXITSTATUS(status) * 5;
        printf("5! = %d\n", resfat);
    }

    return 0;
}
