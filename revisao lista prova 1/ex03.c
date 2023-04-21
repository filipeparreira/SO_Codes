#include <unistd.h>
#include <signal.h>
//#include <stdlib.h>

int main(int argc, char const *argv[])
{
    char *args[] = {"ps", NULL};
    int pid = fork();
    if (pid < 0){
        write(1, "Falha ao criar o processo.\n", 28);
    } else if (pid == 0){
        //Dois jeitos diferentes de exercutar uma linha de comando
        //execv("/bin/ps", args);
        //system("ps");
    }
    return 0;
}
