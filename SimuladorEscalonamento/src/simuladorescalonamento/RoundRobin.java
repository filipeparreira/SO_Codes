package simuladorescalonamento;

import java.util.ArrayList;

public class RoundRobin {
    private ArrayList<Processo> listaProcessos; //Lista de todos os processos, recebe como parametro
    private ArrayList<Processo> listaEspera; //Lista dos processos que estão em espera, adiciona os processos de acordo com a "chegada"
    private ArrayList<Processo> executados; //Lista de processos que foram executados
    private int quantum; //quantum do sistema
    private String linha = "[0]";
    private ArrayList<String> linhas;
    private int tempo; //Armazena o tempo de execução atual 
    
    public RoundRobin(ArrayList<Processo> listaProcessos, int quantum){
        this.listaProcessos = listaProcessos;
        this.listaEspera = new ArrayList<>();
        this.quantum = quantum;
        this.tempo = 0;
        int tempoTot = 0;
        int auxQuantum = 0;
        this.executados = new ArrayList<>();
        Processo processoAtual = new Processo();
        for (Processo p : this.listaProcessos){
            tempoTot += p.getTempo();
        }
        
        while(this.tempo <= tempoTot){
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
            
            
            if(auxQuantum == this.quantum && this.tempo != 0 || processoAtual.getTempo() == 0){
                String tracos = "";
                for (int i = 0; i < auxQuantum; i++){
                    tracos = tracos + "-";
                }
                this.linha = this.linha + tracos + "[" + processoAtual.getProcesso() + "]" + tracos + "[" + this.tempo + "]";
                auxQuantum = 0;
                if (processoAtual.getTempo() == 0){
                    this.executados.add(processoAtual);
                    if (this.listaEspera.isEmpty()){
                        processoAtual = new Processo();
                    } else {
                        processoAtual = this.listaEspera.get(0);
                        this.listaEspera.remove(0);
                    }
                        
                } else{
                    this.listaEspera.add(processoAtual);
                    processoAtual = this.listaEspera.get(0);
                    this.listaEspera.remove(0);
                }
            }
            
            processoAtual.setTempo(processoAtual.getTempo() - 1);
            
            this.tempo++;
            auxQuantum++;
        }
        System.out.println("Lista Espera:");
        for (Processo p : this.listaEspera){
            System.out.println(p.getProcesso());
        }
        System.out.println("Lista de executado");
        for (Processo p : this.executados){
            System.out.println(p.getProcesso());
        }
        System.out.println("Linha do tempo\n\n");
        System.out.println(this.linha);
    }
    
    
    
    
}
