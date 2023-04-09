#include <unistd.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>

int count = 0;
char escolha;
void headler_alarm(int sig){
    write(1, "\nDemorou muito para responder. Saindo...\n", 42);
    exit(0);
}
void headler_sigint(int sig){
    count++;
    if (count == 3){
        write(1, "\nRealmente deseja sair?[s/n]: ", 31);
        signal(SIGALRM, headler_alarm);
        alarm(20);
        read(0, &escolha, 1);
        if (escolha == 'n' || escolha == 'N'){
            write(1, "Continuando...\n", 16);
        } else if (escolha == 's' || escolha == 'S'){
            write(1, "Saindo...\n", 11);
            exit(0);
        }        
        count = 0;
    }
}
void headler_sigtstp(int sig){
    char msg[] = "\nVoce apertou Ctrl-C '";
    char msgf[] = "' vezes\n";
    char inteiro = count + '0';
    write(1, msg, 23);
    write(1, &inteiro, 1);
    write(1, msgf, 9);
}

int main(int argc, char const *argv[]){
    
    while(1){
        signal(SIGINT, headler_sigint);
        signal(SIGTSTP, headler_sigtstp);
    }
    return 0;
}
