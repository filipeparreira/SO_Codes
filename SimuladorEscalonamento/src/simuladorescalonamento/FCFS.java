package simuladorescalonamento;

import java.io.IOException;
import java.util.ArrayList;

public class FCFS {
    private ManipuladorArquivosTXT manipulador;
    private String path;
    
    public FCFS(ArrayList<Processo> processos, String path) throws IOException{
        this.setPath(path);
        int tempoTot = 0;
        int tempo = 0;
        ArrayList<Processo> listaEspera = new ArrayList<>();
        Processo processoAtual = new Processo();
        ArrayList<Processo> executados = new ArrayList<>();
        
        for (Processo p : processos){
            tempoTot += p.getTempo();
        }
        
        while (tempo <= tempoTot){
            if(!processos.isEmpty()){
                if(tempo == processos.get(0).getChegada()){
                    if(processoAtual.getProcesso().equals("")){
                        processoAtual = processos.get(0);
                        processoAtual.setTempoComeco(tempo);
                        processos.remove(0);
                        processoAtual.setTempoEspera(tempo - processoAtual.getChegada());
                    } else{
                        listaEspera.add(processos.get(0));
                        processos.remove(0);
                    }
                }
            }
            if (processoAtual.getTempoAux() == 0){
                processoAtual.setTempoResposta(tempo - processoAtual.getChegada());
                processoAtual.setTempoFinal(tempo);
                executados.add(processoAtual);
                if (listaEspera.isEmpty()){
                    processoAtual = new Processo();
                }else {
                    processoAtual = listaEspera.get(0);
                    processoAtual.setTempoComeco(tempo);
                    processoAtual.setTempoEspera(tempo - processoAtual.getChegada());
                    listaEspera.remove(0);
                }
            }
            processoAtual.setTempoAux(processoAtual.getTempoAux() - 1);
            tempo++;
        }
        
        this.imprimir(this.setTempoMedioResposta(executados), this.setTempoMedioEspera(executados), executados);
    }
    private float setTempoMedioResposta(ArrayList<Processo> executados){
        float tmr = 0;
        
        for (Processo p : executados){
            tmr +=  p.getTempoResposta();
        }
        return tmr / executados.size();
    }
    private float setTempoMedioEspera(ArrayList<Processo> executados){
        float tmr = 0;
        
        for (Processo p : executados){
            tmr +=  p.getTempoEspera();
        }
        return tmr / executados.size();
    }
    private String getPath() {
        return path;
    }
    private void setPath(String path) {
        this.path = path;
    }
    
    
    
    private void imprimir(float tmr, float tme, ArrayList<Processo> executados) throws IOException{
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
        linha = "\n\nTempo Médio de Resposta: " + tmr;
        linhas.add(linha);
        linha = "\n\nTempo Médio de Espera: " + tme;
        linhas.add(linha);
        this.manipulador = new ManipuladorArquivosTXT(linhas);
        this.manipulador.escritor(this.getPath());
    }
}
