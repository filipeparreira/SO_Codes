package simuladorescalonamentointerface;

import java.io.IOException;
import java.util.ArrayList;

public class FCFS {
    //Variaveis de instancia
    private ManipuladorArquivosTXT manipulador;
    private String path;
    int tempoTotM;
    int tempoM;
    int passoAux;
    int qtdeProcessos;
    ArrayList<Processo> listaEsperaM;
    ArrayList<Processo> executadosM;
    ArrayList<Processo> processosM;
    Processo processoAtualM;
    Processo processoAux;
    private String linhaTempo = "";
    
    //Execução caso seja arquivo 
    public FCFS(ArrayList<Processo> processos, String path) throws IOException{
        this.setPath(path);
        int tempoTot = 0;
        int tempo = 0;
        qtdeProcessos = 0;
        ArrayList<Processo> listaEspera = new ArrayList<>();
        Processo processoAtual = new Processo();
        ArrayList<Processo> executados = new ArrayList<>();
        
        for (Processo p : processos){
            tempoTot += p.getTempo();
            qtdeProcessos++;
        }
        
        //Executa enquando o tempo for menor que o tempo total dos processos
        while (tempo <= tempoTot){
            //Verifica se o processoAtual é um processo vazio / adiciona processos 
            // na lista de espera
            for (int i = 0; i < qtdeProcessos; i++){
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
            }
            //Quando um processo termina de ser executado 
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
            //Decremento do tempo de execução do processo atual e encremento do tempo do while
            processoAtual.setTempoAux(processoAtual.getTempoAux() - 1);
            tempo++;
        }
        this.imprimir(this.setTempoMedioResposta(executados), this.setTempoMedioEspera(executados), executados);
    }
    
    //Construtor p/ entrada manual
    public FCFS(ArrayList<Processo> processos){
        tempoTotM = 0;
        tempoM = 0;
        listaEsperaM = new ArrayList<>();
        processoAtualM = new Processo();
        executadosM = new ArrayList<>();  
        processosM = processos;
        qtdeProcessos = 0;
        for (Processo p : processosM){
            tempoTotM += p.getTempo();
            qtdeProcessos++;
        }
        passoAux = 0;
        processoAux = new Processo();
    }
    
    //Método execução caso seja entrada manual
    public ArrayList<ArrayList<Processo>> executar(int passo){
        ArrayList<ArrayList<Processo>> retorno = new ArrayList<>();
        ArrayList<Processo> pAtual = new ArrayList<>();
        while (tempoM <= tempoTotM){
            for (int i = 0; i<qtdeProcessos; i++){
                if(!processosM.isEmpty()){
                    if(tempoM == processosM.get(0).getChegada()){
                        if(processoAtualM.getProcesso().equals("")){
                            processoAtualM = processosM.get(0);
                            processoAtualM.setTempoComeco(tempoM);
                            processosM.remove(0);
                            processoAtualM.setTempoEspera(tempoM - processoAtualM.getChegada());
                        } else{
                            listaEsperaM.add(processosM.get(0));
                            processosM.remove(0);
                        }
                    }
                }
            }
            if (processoAtualM.getTempoAux() == 0){
                this.addLinhaTempo(processoAtualM, tempoM);
                processoAtualM.setTempoResposta(tempoM - processoAtualM.getChegada());
                processoAtualM.setTempoFinal(tempoM);
                executadosM.add(processoAtualM);
                if (listaEsperaM.isEmpty()){
                    processoAtualM = new Processo();
                }else {
                    processoAtualM = listaEsperaM.get(0);
                    processoAtualM.setTempoComeco(tempoM);
                    processoAtualM.setTempoEspera(tempoM - processoAtualM.getChegada());
                    listaEsperaM.remove(0);
                }
            }
            
            processoAtualM.setTempoAux(processoAtualM.getTempoAux() - 1);
            tempoM++;
            passoAux++;
            processoAux.setTempo(tempoM);
            if (passo == passoAux){
                passoAux = 0;
                break;
            }
        }
        processoAux.setTempo(tempoM);
        processoAux.setTempoAux(tempoTotM);
        processoAux.setTme(this.setTempoMedioEspera(executadosM));
        processoAux.setTmr(this.setTempoMedioResposta(executadosM));
        processoAux.setProcesso("[0]" + this.linhaTempo);
        pAtual.add(processoAux);
        if(processoAtualM.getTempoAux() != -1){
            pAtual.add(processoAtualM);
        }
        retorno.add(processosM);
        retorno.add(listaEsperaM);
        retorno.add(executadosM);
        retorno.add(pAtual);
        return retorno;
    }
    
    //Calcula o tempo medio geral (TME E TMR) e armazena
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
    private String getLinhaTempo(){
        return this.linhaTempo;
    }
    private void setLinhaTempo(String linha){
        this.linhaTempo = linha;
    }
    
    private void addLinhaTempo(Processo processoAtual, int tempo){
        String tracos = "";
        String linha = this.getLinhaTempo();
        for (int i = 0; i < 4; i++){
            tracos = tracos + "-";
        }
        linha = linha + tracos + "[" + processoAtual.getProcesso() + "]" + tracos + "[" + tempo + "]";
        this.setLinhaTempo(linha);
    }
    
    private void imprimir(float tmr, float tme, ArrayList<Processo> executados) throws IOException{
        String linha = "";
        ArrayList<String> linhas = new ArrayList<>();
        
        linhas.add("Processos na Fila do First Come First Served:\n");
        for (Processo processo : executados){
            linha = linha + "  " + processo.getProcesso();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de CPU requerida pelos processos:\n");
        for (Processo processo : executados){
            linha = linha + "\t" + processo.getTempo();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Chegada dos processos:\n");
        for (Processo processo : executados){
            linha = linha + "\t" + processo.getChegada();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nLINHA DO TEMPO\n[0]");
        for (Processo processo : executados){
            linha = linha + "-----" + processo.getProcesso() + "-----[" + processo.getTempoFinal() + "]";
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Espera de cada processo:\n");
        for (Processo processo : executados){
            linha = linha + "\t" + processo.getProcesso();
        }
        linha = linha + "\n";
        linhas.add(linha);
        linha = "";
        for (Processo processo : executados){
            linha = linha + "\t" + processo.getTempoEspera();
        }
        linhas.add(linha);
        linha = "";
        linhas.add("\n\nTempo de Resposta de cada processo:\n");
        for (Processo processo : executados){
            linha = linha + "\t" + processo.getProcesso();
        }
        linha = linha + "\n";
        linhas.add(linha);
        linha = "";
        for (Processo processo : executados){
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
