package simuladorescalonamento;

public class Processo {
    private String processo;
    private int tempo;
    private int chegada;
    private int prioridade;

    public Processo() {
        this.processo = "";
        this.tempo = 0;
        this.chegada = 0;
        this.prioridade = 0;
    }
    
    public Processo(String processo, int tempo, int chegada, int prioridade){
        this.processo = processo;
        this.prioridade = prioridade;
        this.chegada = chegada;
        this.prioridade = prioridade;
        this.tempo = tempo;
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

    @Override
    public String toString() {
        return "Processo " + this.processo + ", tempo=" + this.tempo + ", chegada=" + this.chegada + ", prioridade=" + this.prioridade;
    }
}
