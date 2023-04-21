#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <stdlib.h>

int main(int argc, char const *argv[]){
    int pid = fork();
    int status;
    if (pid < 0){
        printf("Falha ao criar o processo.\n");
    } else if (pid == 0){
        pid = fork();
        if (pid < 0){
            printf("Falha ao criar o processo.\n");
        } else if (pid == 0){
            printf("Eu sou o processo C, PID: %d. Filho do processo B, PID: %d", getpid(), getppid());
            exit(1);
        }
        wait(&status);
        sleep(1);
        printf("\nEu sou o processo B, PID: %d. Filho do processo A, PID: %d", getpid(), getppid());
        exit(1);
    } else{
        wait(&status);
        sleep(1);
        printf("\nEu sou o processo A, PID: %d\n", getpid());
    }
    return 0;
}
