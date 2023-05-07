package simuladorescalonamento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ManipuladorArquivosTXT {
    private ArrayList<String> linhas;
    
    public ManipuladorArquivosTXT(){
        this.linhas = new ArrayList<>();
    }
    public ManipuladorArquivosTXT(ArrayList<String> linhas){
        this.linhas = linhas;
    }
    
    public void addLinhas(String linha){
        this.linhas.add(linha);
    }
    
    public ArrayList<String> getLinhas(){
        return this.linhas;
    }
    public void leitor(String path) throws IOException{
        BufferedReader buffread = new BufferedReader(new FileReader(path));
        String linha = "";
        while(true){
            linha = buffread.readLine();
            if (linha == null){
                break;
            } else if (!"".equals(linha)){
                linha = linha.replaceAll("\\s+", "");
                this.addLinhas(linha);
            }
        }
        buffread.close();
    }
    public void escritor(String path) throws IOException{
        FileWriter arq = new FileWriter(path);
        PrintWriter gravador = new PrintWriter(arq);
        ArrayList<String> linhas = this.getLinhas();
        for (String linha : linhas){
            gravador.print(linha);
            System.out.println(linha);
        }
        System.out.println("Gravado com sucesso");
        gravador.close();
        arq.close();
    }
}
