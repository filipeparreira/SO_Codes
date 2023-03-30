#include <string.h>
#include <unistd.h>


void myprintf(int x, int y, char* msg){
 

    int size = strlen(msg);
    char msg2[11];
    strcpy(msg2,"\033[ B\033[ C");   
    
    
    msg2[2]= x + '0';
    msg2[6]= y + '0';

    write(1, msg2, strlen(msg2));
    write(1, msg, size);    
}

int main(int argc, char const *argv[])
{
    /* code */
    char msg[] = "Olá, mundo\n";
    
    myprintf(1, 1, msg);
    
    return 0;
}
