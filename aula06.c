#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>


int main(int argc, char const *argv[])
{
    int pid, status;
    pid = fork();

    if(pid < 0){
        printf("Erro na chamada do fork!!\n");
    } else if (pid == 0){
        printf("Filho pid: %d \n", getgid());
        while (1);
        exit(5);
    } else {
        printf("Pai pid: %d\n", getpid());
        wait(&status);

        if(WIFEXITED(status)){
            printf("O programa do filho rodou normalmente com o código: %d\n", WEXITSTATUS(status));
        }if (WIFSIGNALED(status)){
         
            printf("O filho sofreu um processo de kill : %d\n", WTERMSIG(status));
        }
    }
    return 0;
}
