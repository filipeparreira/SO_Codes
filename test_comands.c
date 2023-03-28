#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    char txt[] = "olá, %s teste\n";
    char palavra[] = "mundo";
    int count = 0;

    while(txt[count] != '\0'){
        if (txt[count] == '%'){
            printf("%s", palavra);
            count+=2;
        }
        printf("%c", txt[count]);
        count++;
    }
    



    return 0;
}

