#include <unistd.h>
#include <stdint.h>
#include <stdio.h>
#include <signal.h>

void strLen(char* msg){
    
    printf("%s");
}

int main(int argc, char const *argv[]){
    char msg[] = "Olá, mundo\n";
    strLen(msg);

    //strLen(msg);
    //write(1, msg, 13);
    //printf("%d", size);
    return 0;
}
