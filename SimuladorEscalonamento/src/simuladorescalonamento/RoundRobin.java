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
        int tempoTot = 0;
        this.executados = new ArrayList<>();
        Processo processoAtual = new Processo();
        for (Processo p : this.listaProcessos){
            tempoTot += p.getTempo();
        }
        while(this.tempo <= tempoTot){
            //Caso a lista de processos não esteja vazia, é verificado se o tempo do primeiro 
            // elemento da lista é igual ao tempo de chegada, caso ele seja igual, é verificado 
            // se tem algum processo executando no momento, caso tenha o primeiro processo da lista
            // de processos vai para lista de espera e é removido da lista de processos, caso não 
            // tenha um processo executando, ele assume o lugar do processo em execução
            if (!this.listaProcessos.isEmpty()){
                if(this.tempo == this.listaProcessos.get(0).getChegada()){
                    if (processoAtual.getProcesso().equals("")){
                        processoAtual = this.listaProcessos.get(0);
                        this.listaProcessos.remove(0);
                    } else{
                        this.listaEspera.add(this.listaProcessos.get(0));
                        this.listaProcessos.remove(0);
                    }
                }
            }
            
            processoAtual.setTempo(processoAtual.getTempo() - 1);
            
                
            
            if((this.tempo % this.quantum) == 0 && this.tempo != 0){
                if (processoAtual.getTempo() == 0){
                    this.executados.add(processoAtual);
                    processoAtual = new Processo();
                } else{
                    this.listaEspera.add(processoAtual);
                    processoAtual = this.listaEspera.get(0);
                    this.listaEspera.remove(0);
                }
            }
            
            this.tempo++;
        }
        System.out.println("Lista Espera:");
        for (Processo p : this.listaEspera){
            System.out.println(p.getProcesso());
        }
        System.out.println("Lista de executado");
        for (Processo p : this.executados){
            System.out.println(p.getProcesso());
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
