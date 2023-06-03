#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <semaphore.h>


#define SHM_SIZE 1024


const int REP = 5;
char dado;
key_t key;
int shmid;
char *data;
sem_t *sP, *sC;



int producer(int n)
{
    printf("Producer was born!\n");
 
    for(int i = 0; i < REP; i++) {
        sem_wait(sP);
        
        data[i] = (char) i + 0x61;   
        printf("Stored... %c \n", data[i]);
        
        sem_post(sC);
    }
       
    return n;
}
 
int consumer(int n)
{
    printf("Consumer was born!\n");
 
    for(int i = 0; i < REP; i++) {
        sem_wait(sC);
        
        dado = data[i];
        data[i] = ' '; 
        
        printf("Consumed... %c \n", dado);
        
        sem_post(sP);
    }
 
    return n;
}
 
int main()
{
    printf("The Producer x Consumer Problem\n");
    int status;
     
    key = ftok("/home", 'A');                      //  Segmento   
    shmid = shmget(key, 1024, 0644 | IPC_CREAT);   //
    data = shmat(shmid, (void *)0, 0);             // Correção aqui
    
    sP = (sem_t*)shmat(shmid, (void *)0, 0);       // Inicialização do semáforo sP
    sC = (sem_t*)shmat(shmid, (void *)0, 0);       // Inicialização do semáforo sC
    
    sem_init(sP, 1, 1); // Inicializa o semáforo sP com valor 1 (disponível)
    sem_init(sC, 1, 0); // Inicializa o semáforo sC com valor 0 (bloqueado)
    
    int pid = fork();
      
    if(pid == 0){
        consumer(5);
    }else{
        producer(5);
        
        shmdt(data);                              //segmento 3 
        shmctl(shmid, IPC_RMID, NULL);            //
    }   
    
    sem_destroy(sP); // Destroi o semáforo sP
    sem_destroy(sC); // Destroi o semáforo sC
    
    return 0;
}
