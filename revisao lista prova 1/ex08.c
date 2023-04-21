#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[]){
    int num = 10;
    int status;
    int pid = fork();

    if (pid == 0){
        num += 5;
        printf("Sou o processo B, PID: %d, filho do processo A, PID: %d. E o meu armazenamento é: %d\n", getpid(), getppid(), num);
        exit(1);
    } else{
        wait(&status);
        printf("Sou o processo A, PID: %d, e meu armazenamento é: %d\n", getpid(), num);
    }
    return 0;
}
