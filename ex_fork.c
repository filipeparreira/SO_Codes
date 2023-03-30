#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    int pid, status;
    int count = 0;
    int pid_filho;
    int pid_pai;

    
    int pid_a = fork();
    if (pid_a == 0){
        int pid_b = fork();
        if (pid_b == 0){
            printf("Sou o processo C, filho de %d\n", getppid());
            sleep(1);
            exit(5);
        }
        wait(&status);
        printf("Sou o processo B numero: %d, filho de %d\n", getpid(), getppid());
        sleep(1);
        exit(1);
    }else{
        wait(&status);
        printf("Sou o processo A, numero %d\n", getpid());
        sleep(1);
    }
    return 0;
}
