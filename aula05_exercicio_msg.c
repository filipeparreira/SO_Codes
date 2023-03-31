#include <signal.h>
#include <unistd.h>
#include <string.h>
#include <stdio.h>

char msgAlert[] = "Mensagem Alerta!!! \n";
int contador = 0;

void display_message(int s) {
    contador+= '0';
    write(1, msgAlert, strlen(msgAlert));
    write(1, contador, 1);
    alarm(1);    //for every second
    signal(SIGALRM, display_message);
}

void cont(int s){
    contador += 1;
}

void printsinc(char* msg, int segundos){
    signal(SIGALRM, display_message);
    alarm(segundos);
    signal(SIGTSTP, cont);    
    int n = 0;
    while (1) {
        ++n;
    }
}

int main(void) {
    printsinc(msgAlert, 2);
    return 0;
}

