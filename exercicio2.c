#include <unistd.h>
#include <signal.h>
#include <stdio.h>

volatile sig_atomic_t flag = 0; // Variável flag para sinalização de sinal recebido

// Função de tratamento de sinal
void handle_signal(int sig) {
    printf("\nSaindo...\n");
    flag = 1;
}

int main() {
    struct sigaction sa; // Estrutura de ação de sinal
    sa.sa_handler = &handle_signal; // Define a função de tratamento de sinal
    sa.sa_flags = SA_RESTART; // Reativa a chamada ao sistema após a interrupção do sinal
    sigfillset(&sa.sa_mask); // Define o conjunto de sinais a serem bloqueados durante o tratamento do sinal

    // Registra o tratamento do sinal SIGINT (CTRL+C)
    if (sigaction(SIGINT, &sa, NULL) == -1) {
        perror("Erro ao registrar tratamento do sinal");
        return 1;
    }

    // Loop principal
    while (!flag) {
        printf("Dentro de um loop\n");
        sleep(5);
    }

    return 0;
}
