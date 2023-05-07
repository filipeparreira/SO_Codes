package simuladorescalonamento;

public class Processo {
    private String processo;
    private int tempo;
    private int chegada;
    private int prioridade;
    private int tempoResposta;
    private int tempoEspera;
    private int tempoComeco;
    private int tempoFinal;

    public Processo() {
        this.processo = "";
        this.tempo = 0;
        this.chegada = 0;
        this.prioridade = 0;
        this.tempoResposta = 0;
        this.tempoEspera = 0;
    }
    
    public Processo(String processo, int tempo, int chegada, int prioridade){
        this.processo = processo;
        this.prioridade = prioridade;
        this.chegada = chegada;
        this.prioridade = prioridade;
        this.tempo = tempo;
        this.tempoEspera = 0;
        this.tempoResposta = 0;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) {
        this.chegada = chegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getTempoResposta() {
        return tempoResposta;
    }

    public void setTempoResposta(int tempoResposta) {
        this.tempoResposta = tempoResposta;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getTempoComeco() {
        return tempoComeco;
    }

    public void setTempoComeco(int tempoComeco) {
        this.tempoComeco = tempoComeco;
    }

    public int getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(int tempoFinal) {
        this.tempoFinal = tempoFinal;
    }
    
    
    @Override
    public String toString() {
        return "Processo " + this.processo + ", tempo=" + this.tempo + ", chegada=" + this.chegada + ", prioridade=" + this.prioridade;
    }
}
