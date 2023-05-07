package simuladorescalonamento;

/*
TaskList:
    DONE 1: Ler o arquivo de entrada e armazenar suas linhas em um vetor de strings
    DONE 2: Percorrer char por char em cada linha e armazenar as informações dos processos
    DONE 3: Criar a classe processo para atribuir suas informações a cada processo, criando também uma lista dinamica
    TODO 4: Implementar o algoritmo dos escalonadores (Round-Robin e FCFS)
        DONE 4.1: Implementação FCFS
            DONE 4.1.1: A classe recebe a lista de processos e executa
            O primeiro processo que chega executa até o final, só pra depois o 
            proximo processo ser executado. Apos a execução de um processo, o mesmo
            sai da fila de espera
        TODO 4.2: Implementação Round-Robin
            - Recebe a lista de processos executa
            - Executa somente de acordo com o quantum
            - Subtrai o quantum do tempo de execução necessario do processo 
    TODO 5: Imprimir a saida em outro arquivo
        DONE 5.1: Fazer pra FCFS
        TODO 5.2: Fazer pra Round Robin
    TODO 6: Tentar implementar a interface grafica
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalTeste {
    public void iniciar() throws IOException{
        ArrayList<String> linhasArq = new ArrayList<>();
        String path = "/home/filipe/Documents/GitHub/SO_Codes/SO_Codes/entradaRoundRobin";
        String pathSaida = "/home/filipe/Documents/GitHub/SO_Codes/SO_Codes/saidaEscalonamento.txt";
        ManipuladorArquivosTXT manipulador = new ManipuladorArquivosTXT();
        manipulador.leitor(path);
        linhasArq = manipulador.getLinhas();
        int tamanho = 0;
        
        ArrayList<String[]> listaFrases = new ArrayList<>();
        
        for (String l : linhasArq){
            String[] palavras = l.split("-");
            tamanho = palavras.length;
            listaFrases.add(palavras);
        }

        String[] processos = new String[tamanho - 1];
        Integer[] tempos = new Integer[tamanho - 1];
        Integer[] chegada = new Integer[tamanho - 1];
        Integer[] prioridade = new Integer[tamanho -1];
        ArrayList<Processo> listaProcessos = new ArrayList<>();
        
        for(String[] linha : listaFrases){
            for(int i = 1; i<tamanho; i++){
                if (linha[0].equalsIgnoreCase("Processo")){
                    processos[i-1] = linha[i];
                } else if (linha[0].equalsIgnoreCase("Tempo")){
                    tempos[i-1] = Integer.valueOf(linha[i]);
                } else if (linha[0].equalsIgnoreCase("Chegada")){
                    chegada[i-1]= Integer.valueOf(linha[i]);
                } else if (linha[0].equalsIgnoreCase("Prioridade")){
                    prioridade[i-1] = Integer.valueOf(linha[i]);
                }
            }
        }
        //Armazenando as informações dentro de processo
        for (int i = 0; i < tamanho - 1; i++){
            listaProcessos.add(new Processo(processos[i], tempos[i], chegada[i], prioridade[i]));
        }
        
        //Ordenando a lista de processos por chegada
        Comparator<Processo> comparador = (Processo p1, Processo p2) -> Integer.compare(p1.getChegada(), p2.getChegada());
        Collections.sort(listaProcessos, comparador);
        
        //new FCFS(listaProcessos, pathSaida);
        new RoundRobin(listaProcessos, 5);
        
    }
    public static void main(String[] args) throws IOException{
        PrincipalTeste p = new PrincipalTeste();
        p.iniciar();  
    }
    
}
