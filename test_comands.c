#include <unistd.h>
int main(int argc, char const *argv[])
{
    int inteiro = 3;
    char num = 3 + '0';
    write(1, &num, 1);
    return 0;
}
