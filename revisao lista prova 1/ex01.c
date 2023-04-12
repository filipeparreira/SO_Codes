#include <unistd.h>

int main(int argc, char const *argv[]){
    
    while(1){
        write(1, "bons estudos\n", 14);
        sleep(10);
    }  
    
    return 0;
}
