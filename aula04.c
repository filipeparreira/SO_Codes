#include <unistd.h>
#include <stdlib.h>
#include <signal.h>


int main(){
	char buff[1024];
	write(1, "Digite o nome: ", 16);
	read(1, buff, 1024);
	write(1, "Digite o RA", 12);
	read(1, )
	write(1, buff, 8);
	return 0;
}

/*
void func(){
	write(1, "Aconteceu um alarme \n\n", 23);
	
}
void func1(){
	write(1, "O processo foi interrompido\n\n", 30);
	
}
void func2(){
	write(1, "CTLZ...\n\n", 10);
	exit(1);
}
int main(){
	
	signal(SIGALRM, func);
	signal(SIGINT, func1);
	signal(SIGTSTP, func2);
	
	while(1){
		alarm(5);
		pause();
	}
		
	return 0;

}
*/