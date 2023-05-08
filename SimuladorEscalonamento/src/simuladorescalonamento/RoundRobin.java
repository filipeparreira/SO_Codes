package simuladorescalonamento;

import java.io.IOException;
import java.util.ArrayList;

public class RoundRobin {
    private ArrayList<Processo> listaProcessosCopy; //Lista de todos os processos, recebe como parametro
    private String linhaTempo = "";
    private ManipuladorArquivosTXT manipulador;
    private String path;
    
    public RoundRobin(ArrayList<Processo> listaProcessos, int quantum, String path) throws IOException{
        this.setListaProcessosCopy((ArrayList<Processo>) listaProcessos.clone());
        ArrayList<Processo> listaEspera = new ArrayList<>();
        ArrayList<Processo> executados = new ArrayList<>();
        int tempo = 0;
        int tempoTot = 0;
        int auxQuantum = 0;
        Processo processoAtual = new Processo();
        this.setPath(path);
        
        for (Processo p : listaProcessos){
            tempoTot += p.getTempo();
        }
        
        while(tempo <= tempoTot){
            if (!listaProcessos.isEmpty()){
                if(tempo == listaProcessos.get(0).getChegada()){
                    if (processoAtual.getProcesso().equals("")){
                        processoAtual = listaProcessos.get(0);
                        listaProcessos.remove(0);
                    } else{
                        listaEspera.add(listaProcessos.get(0));
                        listaProcessos.remove(0);
                    }
                }
            }
            
            
            if(auxQuantum == quantum && tempo != 0 || processoAtual.getTempoAux() == 0){
                
                this.addLinhaTempo(processoAtual, tempo, auxQuantum);
                
                if (processoAtual.getTempoAux() == 0){
                    processoAtual.setTempoResposta(tempo-processoAtual.getChegada());
                    processoAtual.setTempoEspera(processoAtual.getTempoResposta() - processoAtual.getTempo());
                    executados.add(processoAtual);
                    if (listaEspera.isEmpty()){
                        processoAtual = new Processo();
                    } else {
                        processoAtual = listaEspera.get(0);
                        listaEspera.remove(0);
                    }
                        
                } else{
                    listaEspera.add(processoAtual);
                    processoAtual = listaEspera.get(0);
                    listaEspera.remove(0);
                }
                auxQuantum = 0;
            }
            
            processoAtual.setTempoAux(processoAtual.getTempoAux() - 1);
            
            tempo++;
            auxQuantum++;
        }
        this.imprimir(this.setTempoMedioResposta(executados), this.setTempoMedioEspera(executados));
    }
    
    private float setTempoMedioResposta(ArrayList<Processo> executados){
        float tmr = 0f;
        for (Processo p : executados){
            tmr += p.getTempoResposta();
        }
        return tmr / executados.size();
    }
    private float setTempoMedioEspera(ArrayList<Processo> executados){
        float tme = 0f;
        for (Processo p : executados){
            tme += p.getTempoEspera();
        }
        return tme / executados.size();
    }
    
    private void setListaProcessosCopy(ArrayList<Processo> listaProcessos){
        this.listaProcessosCopy = listaProcessos;
    }
    private ArrayList<Processo> getListaProcessosCopy() {
        return listaProcessosCopy;
    }
    private String getLinhaTempo(){
        return this.linhaTempo;
    }
    private void setLinhaTempo(String linha){
        this.linhaTempo = linha;
    }
    private String getPath() {
        return path;
    }
    private void setPath(String path) {
        this.path = path;
    }
    
    
    private void addLinhaTempo(Processo processoAtual, int tempo, int auxQuantum){
        String tracos = "";
        String linha = this.getLinhaTempo();
        for (int i = 0; i < auxQuantum; i++){
            tracos = tracos + "-";
        }
        linha = linha + tracos + "[" + processoAtual.getProcesso() + "]" + tracos + "[" + tempo + "]";
        this.setLinhaTempo(linha);
    }
    
    private void imprimir(float tmr, float tme) throws IOException{
        String linha = "";
        ArrayList<String> linhas = new ArrayList<>();
        ArrayList<Processo> listaProcessos = this.getListaProcessosCopy();
        linhas.add("Processos na Fila do Round-Robin:\n");
        for (Processo processo : listaProcessos){
            linha = linha + "  " + processo.getProcesso();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de CPU requerida pelos processos:\n");
        for (Processo processo : listaProcessos){
            linha = linha + "\t" + processo.getTempo();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Chegada dos processos:\n");
        for (Processo processo : listaProcessos){
            //System.out.print("\t" + processo.getChegada());
            linha = linha + "\t" + processo.getChegada();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nLINHA DO TEMPO\n[0]");
        linhas.add(this.getLinhaTempo());
        linhas.add("\n\nTempo de Espera de cada processo:\n");
        for (Processo processo : listaProcessos){
            //System.out.print("\t" + processo.getProcesso());
            linha = linha + "\t" + processo.getProcesso();
        }
        linha = linha + "\n";
        linhas.add(linha);
        linha = "";
        for (Processo processo : listaProcessos){
            //System.out.print("\t" + processo.getTempoEspera());
            linha = linha + "\t" + processo.getTempoEspera();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Resposta de cada processo:\n");
        for (Processo processo : listaProcessos){
            //System.out.print("\t" + processo.getProcesso());
            linha = linha + "\t" + processo.getProcesso();
        }
        linha = linha + "\n";
        linhas.add(linha);
        linha = "";
        for (Processo processo : listaProcessos){
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
