package simuladorescalonamento;

/*
TaskList:
    DONE 1: Ler o arquivo de entrada e armazenar suas linhas em um vetor de strings
    DONE 2: Percorrer char por char em cada linha e armazenar as informações dos processos
    DONE 3: Criar a classe processo para atribuir suas informações a cada processo, criando também uma lista dinamica
    DONE 4: Implementar o algoritmo dos escalonadores (Round-Robin e FCFS)
        DONE 4.1: Implementação FCFS
            DONE 4.1.1: A classe recebe a lista de processos e executa
            O primeiro processo que chega executa até o final, só pra depois o 
            proximo processo ser executado. Apos a execução de um processo, o mesmo
            sai da fila de espera
        DONE 4.2: Implementação Round-Robin
            - Recebe a lista de processos executa
            - Executa somente de acordo com o quantum
            - Subtrai o quantum do tempo de execução necessario do processo 
    DONE 5: Imprimir a saida em outro arquivo
        DONE 5.1: Fazer pra FCFS
        DONE 5.2: Fazer pra Round Robin
    TODO 6: Tentar implementar a interface grafica
        DONE 6.1: Implementar uma escolha (Tipo de algoritmo de escalonamento; e se vai ser via arquivo ou será preenchido 
                    na interface
        DONE 6.2: Implementar um seletor de arquivos, onde será selecionado o local onde está o arquivo de entrada, e 
                    selecionar o local onde será colocado o arquivo de saida 
        TODO 6.3: Implementar a parte onde é selecionado a opção de preencher os processos na interface
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalTeste {
    public void iniciar() throws IOException{
        ArrayList<String> linhasArq = new ArrayList<>();
        String path = "/home/filipe/Documents/GitHub/SO_Codes/SO_Codes/entradaEscalonamento";
        String pathSaidaRR = "/home/filipe/Documents/GitHub/SO_Codes/SO_Codes/saidaRoundRobin";
        String pathSaidaFCFS = "/home/filipe/Documents/GitHub/SO_Codes/SO_Codes/saidaFCFS";
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
        
        //new FCFS((ArrayList<Processo>) listaProcessos.clone(), pathSaidaFCFS);
        new RoundRobin((ArrayList<Processo>) listaProcessos.clone(), 0, pathSaidaRR);
        
    }
    public static void main(String[] args) throws IOException{
        PrincipalTeste p = new PrincipalTeste();
        p.iniciar();  
    }
    
}
