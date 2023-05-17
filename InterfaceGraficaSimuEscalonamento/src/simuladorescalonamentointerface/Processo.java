package simuladorescalonamentointerface;

public class Processo {
    private String processo;
    private int tempo;
    private int chegada;
    private int prioridade;
    private int tempoResposta;
    private int tempoEspera;
    private int tempoComeco;
    private int tempoFinal;
    private int tempoAux;
    private float tmr;
    private float tme;

    public Processo() {
        this.processo = "";
        this.tempo = 0;
        this.chegada = 0;
        this.prioridade = 0;
        this.tempoResposta = 0;
        this.tempoEspera = 0;
        this.tmr = 0f;
        this.tme = 0f;
    }
    
    public Processo(String processo, int tempo, int chegada, int prioridade){
        this.processo = processo;
        this.prioridade = prioridade;
        this.chegada = chegada;
        this.prioridade = prioridade;
        this.tempo = tempo;
        this.tempoEspera = 0;
        this.tempoResposta = 0;
        this.tempoAux = tempo;
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

    public int getTempoAux() {
        return tempoAux;
    }

    public void setTempoAux(int tempoAux) {
        this.tempoAux = tempoAux;
    }

    public float getTmr() {
        return tmr;
    }

    public void setTmr(float tmr) {
        this.tmr = tmr;
    }

    public float getTme() {
        return tme;
    }

    public void setTme(float tme) {
        this.tme = tme;
    }
    
    
    
    @Override
    public String toString() {
        return "Processo " + this.processo + ", tempo=" + this.tempo + ", chegada=" + this.chegada + ", prioridade=" + this.prioridade;
    }
    public Object[] getDados(){
        return new Object[] {this.getProcesso(), this.getTempo(), this.getChegada(), this.getPrioridade()};
    }
    
}
