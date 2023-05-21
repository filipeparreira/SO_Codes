#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

#define SHM_SIZE 1024

int main(int argc, char *argv[])
{
    key_t key;
    int shmid;
    char *segmento;
    int modo,filho;
    /* Criar a chave: */
    key = ftok("/bin", 'A');
    if (key == -1)
    {
        perror("ftok");
        exit(1);
    }
    /*Criar o segmento */
    shmid = shmget(key, 1024, 0644 | IPC_CREAT);
    if (shmid == -1) {
        perror("shmget");
        exit(1);
    }
    /*Vincula o segmento de memória á variável segmento*/
    segmento = shmat(shmid, (void *)0, 0);
    if (segmento == (char *)(-1)) {
        perror("shmat");
        exit(1);
    }    
    //Código do filho
    segmento = "conteudo da memoria compartilhada";
    filho = fork();
    if (filho == 0){
        segmento = "conteudo alterado pelo processo filho";
    }else{
        //Código do pai
        printf("Conteudo segmento: %s\n", segmento);
    }
    
    /* Desvincular do segmento */
    shmctl(shmid, IPC_RMID, NULL);
    if (shmdt(segmento) == -1) {
          perror("shmdt");
          exit(1);
    }
    return 0;


}