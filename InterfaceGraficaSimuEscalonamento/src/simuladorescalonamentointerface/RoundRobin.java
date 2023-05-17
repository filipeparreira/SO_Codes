package simuladorescalonamentointerface;

import java.io.IOException;
import java.util.ArrayList;

public class RoundRobin {
    private ArrayList<Processo> listaProcessosCopy; //Lista de todos os processos, recebe como parametro
    private String linhaTempo = "";
    private ManipuladorArquivosTXT manipulador;
    private String path;
    ArrayList<Processo> listaEsperaM;
    ArrayList<Processo> executadosM;
    ArrayList<Processo> processosM;
    int tempoM;
    int tempoTotM;
    int auxQuantumM;
    int quantumM;
    int passoAux;
    int qtdeProcessos; 
    Processo processoAtualM;
    Processo processoAux;
    
    public RoundRobin(ArrayList<Processo> listaProcessos, int quantum, String path) throws IOException{
        this.setListaProcessosCopy((ArrayList<Processo>) listaProcessos.clone());
        ArrayList<Processo> listaEspera = new ArrayList<>();
        ArrayList<Processo> executados = new ArrayList<>();
        int tempo = 0;
        int tempoTot = 0;
        int auxQuantum = 0;
        qtdeProcessos = 0;
        Processo processoAtual = new Processo();
        this.setPath(path);
        
        for (Processo p : listaProcessos){
            tempoTot += p.getTempo();
            qtdeProcessos++;
        }
        
        while(tempo <= tempoTot){
            for (int i = 0; i < qtdeProcessos; i++){
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
    
    public RoundRobin(ArrayList<Processo> listaProcessos, int quantum){
        this.setListaProcessosCopy((ArrayList<Processo>) listaProcessos.clone());
        processosM = listaProcessos;
        listaEsperaM = new ArrayList<>();
        executadosM = new ArrayList<>();
        tempoM = 0;
        tempoTotM = 0;
        quantumM = quantum;
        passoAux = 0;
        processoAtualM = new Processo();
        processoAux = new Processo();
        qtdeProcessos = 0;
        for (Processo p : processosM){
            tempoTotM += p.getTempo();
            qtdeProcessos++;
        }
    }
    
    public ArrayList<ArrayList<Processo>> executar(int passo){
        ArrayList<ArrayList<Processo>> retorno = new ArrayList<>();
        ArrayList<Processo> pAtual = new ArrayList<>();
        while(tempoM <= tempoTotM){
            for (int i = 0; i < qtdeProcessos; i++){
                if (!processosM.isEmpty()){
                    if(tempoM == processosM.get(0).getChegada()){
                        if (processoAtualM.getProcesso().equals("")){
                            processoAtualM = processosM.get(0);
                            processosM.remove(0);
                        } else{
                            listaEsperaM.add(processosM.get(0));
                            processosM.remove(0);
                        }
                    }
                }
            }
        
            if(auxQuantumM == quantumM && tempoM != 0 || processoAtualM.getTempoAux() == 0){
                this.addLinhaTempo(processoAtualM, tempoM, auxQuantumM);
                if (processoAtualM.getTempoAux() == 0){
                    processoAtualM.setTempoResposta(tempoM-processoAtualM.getChegada());
                    processoAtualM.setTempoEspera(processoAtualM.getTempoResposta() - processoAtualM.getTempo());
                    executadosM.add(processoAtualM);
                    
                    if (listaEsperaM.isEmpty()){
                        processoAtualM = new Processo();
                    } else {
                        processoAtualM = listaEsperaM.get(0);
                        listaEsperaM.remove(0);
                    }
                    
                } else{
                    listaEsperaM.add(processoAtualM);
                    processoAtualM = listaEsperaM.get(0);
                    listaEsperaM.remove(0);
                }
                auxQuantumM = 0;
            }
            
            
            processoAtualM.setTempoAux(processoAtualM.getTempoAux() - 1);
            tempoM++;
            auxQuantumM++;
            passoAux++;
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
