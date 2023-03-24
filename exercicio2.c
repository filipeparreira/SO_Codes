#include <unistd.h>
#include <signal.h>
#include <stdio.h>

void mensagem(int signum){
    write(1, "\nDentro do loop...", 18);
}
void saida(int signum){
    write(1, "\nSaindo.", 8);
    sleep(1);
    write(1, "\nSaindo..", 9);
    sleep(1);
    write(1, "\nSaindo...", 10);
    sleep(1);
}
int main() {
    do
    {    
        signal(SIGALRM, mensagem);   
        alarm(2);
        pause();
        signal(SIGSTOP, saida);
    } while (1);
    
    
    return 0;
}
