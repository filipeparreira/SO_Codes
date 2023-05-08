package simuladorescalonamento;

import java.io.IOException;
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
    private ManipuladorArquivosTXT manipulador;
    private String path;
    
    public FCFS(ArrayList<Processo> processos, String path) throws IOException{
        this.processos = (ArrayList<Processo>) processos.clone();
        this.setQtdeProcessos(processos.size());
        this.setTempoExec(0);
        this.setTempoEspera(0);
        this.setTempoResposta(0);
        this.setPath(path);
        int tempoTot = 0;
        int tempo = 0;
        ArrayList<Processo> listaEspera = new ArrayList<>();
        Processo processoAtual = new Processo();
        
        for (Processo p : processos){
            tempoTot += p.getTempo();
        }
        
        while (tempo <= tempoTot){
            if(!processos.isEmpty()){
                if(tempo == processos.get(0).getChegada()){
                    if(processoAtual.getProcesso().equals("")){
                        processoAtual = processos.get(0);
                        processos.remove(0);
                    } else{
                        listaEspera.add(processos.get(0));
                        processos.remove(0);
                    }
                }
            }
            if (processoAtual.getTempo() == 0){
                this.executados.add(processoAtual);
                if (listaEspera.isEmpty()){
                    processoAtual = new Processo();
                }else {
                    processoAtual = listaEspera.get(0);
                    listaEspera.remove(0);
                }
            }
            processoAtual.setTempo(processoAtual.getTempo() - 1);
            tempo++;
        }
        
        /*
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
        //this.imprimir();
        */
        System.out.println("Lista Executados: ");
        for (Processo p : this.executados){
            System.out.println(p.getProcesso());
        }
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
    private String getPath() {
        return path;
    }
    private void setPath(String path) {
        this.path = path;
    }
    
    
    
    private void imprimir() throws IOException{
        String linha = "";
        ArrayList<String> linhas = new ArrayList<>();
        
        linhas.add("Processos na Fila do First Come First Served:\n");
        for (Processo processo : executados){
            //System.out.print("\t" + processo.getProcesso());
            linha = linha + "  " + processo.getProcesso();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de CPU requerida pelos processos:\n");
        for (Processo processo : executados){
            //System.out.print("\t" + processo.getTempo());
            linha = linha + "\t" + processo.getTempo();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Chegada dos processos:\n");
        for (Processo processo : executados){
            //System.out.print("\t" + processo.getChegada());
            linha = linha + "\t" + processo.getChegada();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nLINHA DO TEMPO\n[0]");
        for (Processo processo : executados){
            //System.out.printf("-----%s-----[%d]", processo.getProcesso(), 
              //      processo.getTempoFinal());
            linha = linha + "-----" + processo.getProcesso() + "-----[" + processo.getTempoFinal() + "]";
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Espera de cada processo:\n");
        for (Processo processo : executados){
            //System.out.print("\t" + processo.getProcesso());
            linha = linha + "\t" + processo.getProcesso();
        }
        linha = linha + "\n";
        linhas.add(linha);
        linha = "";
        for (Processo processo : executados){
            //System.out.print("\t" + processo.getTempoEspera());
            linha = linha + "\t" + processo.getTempoEspera();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Resposta de cada processo:\n");
        for (Processo processo : executados){
            //System.out.print("\t" + processo.getProcesso());
            linha = linha + "\t" + processo.getProcesso();
        }
        linha = linha + "\n";
        linhas.add(linha);
        linha = "";
        for (Processo processo : executados){
            //System.out.print("\t" + processo.getTempoResposta());
            linha = linha + "\t" + processo.getTempoResposta();
        }
        linhas.add(linha);
        linha = "\n\nTempo Médio de Resposta: " + this.getTempoMedioResposta();
        linhas.add(linha);
        linha = "\n\nTempo Médio de Espera: " + this.getTempoMedioEspera();
        linhas.add(linha);
        this.manipulador = new ManipuladorArquivosTXT(linhas);
        this.manipulador.escritor(this.getPath());
    }
}
