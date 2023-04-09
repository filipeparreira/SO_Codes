#include <unistd.h>

int main(int argc, char const *argv[])
{
    char msg[] = "bons estudos\n";

    while(1){
        write(1, msg, 14);
        sleep(10);
    }

    return 0;
}