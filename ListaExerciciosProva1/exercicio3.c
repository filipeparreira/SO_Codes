#include <stdio.h>
#include <unistd.h>
//#include <stdlib.h>

int main() {
    char *args[] = {"ps", NULL};
    execv("/bin/ps", args);
    printf("Erro ao executar o programa.\n");
    return 1;
}
