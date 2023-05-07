package simuladorescalonamento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManipuladorArquivosTXT {
    private ArrayList<String> linhas;
    
    public ManipuladorArquivosTXT(){
        this.linhas = new ArrayList<>();
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
}
