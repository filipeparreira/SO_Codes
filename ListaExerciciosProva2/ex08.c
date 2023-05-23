#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>

char *message = "This is a message!!!" ;

 int main()
{
    int var = 0;
    int status;
    key_t key;
    int shmid;
    int *segmento;
    key = ftok("/bin", 'A');
    shmid = shmget(key, sizeof(int*), IPC_CREAT|0666);
    segmento = shmat(shmid, (void*)0, 0);
    
    if (fork() != 0) { /* I am the parent */
            wait(&status);
            *segmento += 5;

    }

    else { /*Child code */
            *segmento += 10;
            exit(0);
    }

    printf("%d\n",*segmento);
    printf("Final de um processo. \n");
    shmdt(segmento);
    shmctl(shmid, IPC_RMID, NULL);
    return 0;
}