package simuladorescalonamento;

/*
TaskList:
    DONE 1: Ler o arquivo de entrada e armazenar suas linhas em um vetor de strings
    DONE 2: Percorrer char por char em cada linha e armazenar as informações dos processos
    TODO 3: Criar a classe processo para atribuir suas informações a cada processo, criando também uma lista dinamica
    TODO 4: Implementar o algoritmo dos escalonadores (Round-Robin e FCFS)
    TODO 5: Imprimir a saida em outro arquivo
    TODO 6: Tentar implementar a interface grafica
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PrincipalTeste {
    public void iniciar() throws IOException{
        ArrayList<String> linhasArq = new ArrayList<String>();
        String path = "/home/filipe/Documents/GitHub/SO_Codes/SO_Codes/entradaEscalonamento";
        ManipuladorArquivosTXT manipulador = new ManipuladorArquivosTXT();
        manipulador.leitor(path);
        linhasArq = manipulador.getLinhas();
        int tamanho = 0;
        
        ArrayList<ArrayList<String>> listaFrases = new ArrayList<ArrayList<String>>();
        int count = 0;
        for (String l : linhasArq){
            ArrayList<String> frase = new ArrayList<>();
            System.out.println("Linha " + count + ": " + l);
            count++;
            String[] palavras = l.split(" ");
            for (String palavra : palavras) {
                if (!palavra.equalsIgnoreCase("-")) {
                    frase.add(palavra);
                }
            }
            tamanho = frase.size();
            listaFrases.add(frase);
        }
        String[] processos = new String[tamanho - 1];
        String[] tempos = new String[tamanho - 1];
        String[] chegada = new String[tamanho - 1];
        String[] prioridade = new String[tamanho -1];
        
        
        for(ArrayList<String> linha : listaFrases){
            for(int i = 1; i<linha.size(); i++){
                if (linha.get(0).equalsIgnoreCase("Processo")){
                    processos[i-1] = linha.get(i);
                } else if (linha.get(0).equalsIgnoreCase("Tempo")){
                    tempos[i-1] = linha.get(i);
                } else if (linha.get(0).equalsIgnoreCase("Chegada")){
                    chegada[i-1]= linha.get(i);
                } else if (linha.get(0).equalsIgnoreCase("Prioridade")){
                    prioridade[i-1] = linha.get(i);
                }
            }
        }
        
        System.out.println("Processo" + Arrays.toString(processos));
        System.out.println("Tempo" + Arrays.toString(tempos));
        System.out.println("Chegada" + Arrays.toString(chegada));
        System.out.println("Prioridade" + Arrays.toString(prioridade));        
    }
    public static void main(String[] args) throws IOException{
        PrincipalTeste p = new PrincipalTeste();
        p.iniciar();  
    }
    
}
