package simuladorescalonamento;

import java.io.IOException;
import java.util.ArrayList;

public class PrincipalTeste {
    public void iniciar() throws IOException{
        ArrayList<String> linhasArq = new ArrayList<String>();
        String path = "/home/filipe/Documents/GitHub/SO_Codes/SO_Codes/entradaEscalonamento";
        ManipuladorArquivosTXT manipulador = new ManipuladorArquivosTXT();
        manipulador.leitor(path);
        linhasArq = manipulador.getLinhas();
        int count = 0;
        for (String l : linhasArq){
            System.out.println("Linha " + count + ": " + l);
            count++;
        }
        
    }
    public static void main(String[] args) throws IOException{
        PrincipalTeste p = new PrincipalTeste();
        p.iniciar();  
    }
    
}
