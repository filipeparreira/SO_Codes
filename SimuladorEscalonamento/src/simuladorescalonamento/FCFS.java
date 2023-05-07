package simuladorescalonamento;

import java.util.ArrayList;

public class FCFS {
    private ArrayList<Processo> processos = new ArrayList<>();
    private int qtdeProcessos; 
    private int tempoEspera; // tempo que ele começou a ser executado - o tempo de chegada
    private int tempoResposta; // tempo em que o processo foi executado - o tempo de chagada
    private float tempoMedioEspera; // todos os tempos de espera somado / quantidade de processos
    private float tempoMedioResposta; // todos os tempos de resposta somado / quantidade de processos
    private int tempoExec; // tempo que é acrescentado a cada execução 
    private ArrayList<Processo> executados = new ArrayList<>();
    
    public FCFS(ArrayList<Processo> processos){
        this.processos = processos;
        this.setQtdeProcessos(processos.size());
        this.setTempoExec(0);
        this.setTempoEspera(0);
        this.setTempoResposta(0);
        
        while (!this.processos.isEmpty()){
            //"Pega" um processo da pilha 
            Processo processoAtual = processos.get(0);
           //Executa ele
                //adiciona o tempo de execução atual a lista de tempos de execução
                //encrementa o tempo de execução
                //adicionar o tempo a lista de tempos de execução
                //calcula o tempo de espera e o tempo de resposta e passa para o processo que foi executado
            this.executa(processoAtual);
            //Adiciona o processo executado a lista de executados
            this.addExecutados(processoAtual);
            //Remove o processo da lista e passa pro proximo
            this.processos.remove(0);
            //Calcular o tempo medio de espera
            //Calcular o tempo medio de resposta
        }
        for (Processo processo : executados){
            this.setTempoEspera(this.getTempoEspera() + processo.getTempoEspera());
            this.setTempoResposta(this.getTempoResposta() + processo.getTempoResposta());
        }
        this.setTempoMedioEspera((float) this.getTempoEspera() / this.getQtdeProcessos());
        this.setTempoMedioResposta((float) this.getTempoResposta() / this.getQtdeProcessos());
        this.imprimir();
    }
    private void executa(Processo processoAtual){
        processoAtual.setTempoComeco(this.getTempoExec());
        processoAtual.setTempoEspera(this.getTempoExec() - processoAtual.getChegada());
        this.setTempoExec(this.getTempoExec() + processoAtual.getTempo());
        processoAtual.setTempoFinal(this.getTempoExec());
        processoAtual.setTempoResposta(processoAtual.getTempoFinal() - processoAtual.getChegada());
    }
    
    
    private int getQtdeProcessos(){
        return this.qtdeProcessos;
    } 
    private void setQtdeProcessos(int qtdeProcessos){
        this.qtdeProcessos = qtdeProcessos;
    }
    private int getTempoExec(){
        return this.tempoExec;
    }
    private void setTempoExec(int tempoExec){
        this.tempoExec = tempoExec;
    }
    private void addExecutados(Processo processo){
        this.executados.add(processo);
    }
    private int getTempoEspera(){
        return this.tempoEspera;
    }
    private void setTempoEspera(int tempoEspera){
        this.tempoEspera = tempoEspera;
    }
    private int getTempoResposta(){
        return this.tempoResposta;
    }
    private void setTempoResposta(int tempoResposta){
        this.tempoResposta = tempoResposta;
    }
    private float getTempoMedioResposta(){
        return this.tempoMedioResposta;
    }
    private void setTempoMedioResposta(float tempoMedioResposta){
        this.tempoMedioResposta = tempoMedioResposta;
    }
    private float getTempoMedioEspera(){
        return this.tempoMedioEspera;
    }
    private void setTempoMedioEspera(float tempoMedioEspera){
        this.tempoMedioEspera = tempoMedioEspera;
    }
    
    private void imprimir(){
        System.out.print("Processos na Fila do First Come First Served:");
        for (Processo processo : executados){
            System.out.print("\t" + processo.getProcesso());
        }
        System.out.println("\n\nTempo de CPU requerida pelos processos:");
        for (Processo processo : executados){
            System.out.print("\t" + processo.getTempo());
        }
        System.out.println("\n\nTempo de Chegada dos processos:");
        for (Processo processo : executados){
            System.out.print("\t" + processo.getChegada());
        }
        System.out.println("\n\nLINHA DO TEMPO\n");
        System.out.print("[0]");
        for (Processo processo : executados){
            System.out.printf("-----%s-----[%d]", processo.getProcesso(), 
                    processo.getTempoFinal());
        }
        System.out.println("\n\nTempo de Espera de cada processo:");
        for (Processo processo : executados){
            System.out.print("\t" + processo.getProcesso());
        }
        System.out.println("");
        for (Processo processo : executados){
            System.out.print("\t" + processo.getTempoEspera());
        }
        System.out.println("\n\nTempo de Resposta de cada processo:");
        for (Processo processo : executados){
            System.out.print("\t" + processo.getProcesso());
        }
        System.out.println("");
        for (Processo processo : executados){
            System.out.print("\t" + processo.getTempoResposta());
        }
        
        System.out.println("\n\nTempo Médio de Resposta: " + this.getTempoMedioResposta());
        System.out.println("\n\nTempo Médio de Espera: " + this.getTempoMedioEspera());
    }
}
