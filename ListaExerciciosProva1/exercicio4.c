#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[]){
    int pid = fork();
    int status;

    if (pid < 0){
        write(1, "Erro ao criar o processo\n", 26);
    }else if (pid == 0){
        pid = fork();
        if (pid < 0){
            printf("Erro ao criar o processo 2\n");
        }else if (pid == 0){
            printf("Eu sou o processo C, PID: %d, filho do processo B, PID: %d\n", getpid(), getppid());
            exit(2);
        }
        wait(&status);
        printf("Eu sou o processo B, PID: %d; filho do processo A, PID: %d\n", getpid(), getppid());

    }else{
        wait(&status);
        printf("Eu sou o processo A, PID: %d\n", getpid());
    }
    return 0;
}
