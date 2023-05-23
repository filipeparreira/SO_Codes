#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <semaphore.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>

int main(int argc, char const *argv[])
{
    sem_t s;
    key_t key;
    key = ftok("/bin", 'A');
    int shmid;
    int *segmento, *count;
    

    shmid = shmget(key, sizeof(sem_t), IPC_CREAT|0666);
    s = shmat(shmid, (void *)0, 0);
    sem_init(&s, 0, 1);

    if (fork() != 0) { /* I am the parent */
        int i;
        //sem_wait(&s);
        for(i = 0; i < 10; i = i+2){
            
            printf("Processo pai %d \n", i);
            sleep(1);
            
        }
        //sem_post(&s);
    }
    else { /*Child code */
        int i;
        sem_wait(&s);
            for(i = 1; i < 10; i = i+2){
                
                printf("Processo filho %d \n", i);
                
            }
        sem_post(&s);
    }
    exit(0);
    return 0;
}
