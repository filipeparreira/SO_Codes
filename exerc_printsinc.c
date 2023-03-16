#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <stdio.h>

int contador = 0;

void headlerSTP(int sig){
    contador+=1;
}

void headlerMsg(int s){
    
}

int main(int argc, char const *argv[])
{
    signal(SIGTSTP, headlerSTP);
    char msg[] = "Mensagem Alerta\n";
    while(1){
        write(1, msg, strlen(msg));
        printf("%i\n", contador);   
        sleep(1);
        
    }

    
    return 0;
}
