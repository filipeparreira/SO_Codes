package simuladorescalonamento;

import java.util.ArrayList;

public class RoundRobin {
    private ArrayList<Processo> listaProcessos; //Lista de todos os processos, recebe como parametro
    private ArrayList<Processo> listaEspera; //Lista dos processos que estão em espera, adiciona os processos de acordo com a "chegada"
    private ArrayList<Processo> executados; //Lista de processos que foram executados
    private int quantum; //quantum do sistema
    private String linha;
    private ArrayList<String> linhas;
    private int tempo; //Armazena o tempo de execução atual 
    
    public RoundRobin(ArrayList<Processo> listaProcessos, int quantum){
        this.listaProcessos = listaProcessos;
        this.listaEspera = new ArrayList<>();
        this.quantum = quantum;
        this.tempo = 0;
        Processo processoChegada = new Processo();
        Processo processoExec = new Processo();
        while (!this.listaProcessos.isEmpty() && !this.listaEspera.isEmpty()){
            processoChegada = this.listaProcessos.get(0);
            if (this.tempo == processoChegada.getChegada()){
                this.listaEspera.add(processoChegada);
            }
            
        }
        
    }
    private void executa(Processo processoAtual, ArrayList<Processo> listaEspera){
        processoAtual.setTempoComeco(this.tempo);
        for (int i = 0; i < this.quantum; i++){
            
        }
        //enquanto a lista de processos e a lista de espera não estiver vazia
            //Armazena o primeiro processo da lista na variavel de processoExec
            //Decrementa a lista de processos
            //Define o tempo de entrada do processo atual
            //Laço de repetição do tamanho do quantum 
                //Verificar se o processo de execução do tempo atual é igual a 0
                    //Se for, sair do laço de execução
                //Decremento 1 a 1 o tempo de execução do processo atual
                //Verifico se tem algum processo que entra enquanto o processo atual executa
                    //Se tiver, adiciona esse processo a lista de espera
            //Verifico se o tempo de execução do processo é igual a 0
                //Se sim, apaga o processo 
                //Se não, armazena ele na fila de espera
    }
    
    
    
}
