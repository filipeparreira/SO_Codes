#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[]){
    int fat = 1;
    int status;
    int pid = fork();

    if (pid == 0){
        pid = fork();
        if (pid == 0){
            pid = fork();
            if (pid == 0){
                fat = fat * 2;
                exit(fat);
            }
            wait(&status);
            fat = WEXITSTATUS(status) * 3;
            exit(fat);
        }
        wait(&status);
        fat = WEXITSTATUS(status) * 4;
        exit(fat);
    }else{
        wait(&status);
        fat  = WEXITSTATUS(status) * 5;
        printf("5! = %d\n", fat);
    }

    return 0;
}
