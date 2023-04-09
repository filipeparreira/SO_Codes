#include <unistd.h>

int main(int argc, char const *argv[])
{
    char frase[] = "bons estudos\n";
    while(1){
        write(1, frase, 14);
        sleep(10);
    }
    return 0;
}
