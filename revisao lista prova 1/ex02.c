#include <unistd.h>
#include <signal.h>
#include <stdlib.h>
int count = 0;
char escolha;

void headler_sigalrm(int sig){
    write(1, "\nDemorou muito para responder. Saindo...\n", 42);
    exit(-1);
}

void headler_sigint(int sig){
    if (count == 2){
        write(1, "\nRealmente deseja sair? [y/n]: ", 32);
        read(0, &escolha, 1);
        signal(SIGALRM, headler_sigalrm);
        alarm(20);
        if (escolha == 'y' || escolha == 'Y'){
            write(1, "Saindo do programa...\n", 23);
            exit(-1);
        }else if(escolha == 'n' || escolha == 'N'){
            count = 0;
            write(1, "Continuando...\n", 16);
        } else {
            write(1, "Opção incorreta, saindo do programa...", 40);
            exit(-1);
        }
    } else{
        count++;
    }
}

void headler_sigtstp(int sig){
    write(1, "\nVocê apertou Crtl-C '", 24);
    char inteiro = count + '0';
    write(1, &inteiro, 1);
    write(1, "' vezes\n", 9);
}

int main(int argc, char const *argv[]){
    while(1){
        signal(SIGINT, headler_sigint);
        signal(SIGTSTP, headler_sigtstp);
    }
    
    return 0;
}
