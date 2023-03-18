#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    char msg[] = "Mensagem Alerta\n";
    signal(SIGALRM, SIG_IGN);
    int n = 0;
    while (n<3)
    {
        write(1, msg, strlen(msg));
        alarm(6);
        alarm()
        n+=1;
    }
    
    

    return 0;
}
