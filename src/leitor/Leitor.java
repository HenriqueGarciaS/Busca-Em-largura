package leitor;
import java.io.BufferedReader;
import java.io.FileReader;
public class Leitor {

    private BufferedReader leitor;
    private String linha, texto;
    private String [] textoLido;

    public Leitor (String caminho) throws Exception {
        try{
            leitor = new BufferedReader(new FileReader(caminho));
        }
        catch(Exception erro)
        {
            throw new Exception("erro ao encontrar arquivo");
        }
    }

    public String getLinha(){
        return this.linha;
    }

    public String getTexto(){
        return this.texto;
    }

    public String [] getTextoLido(){
        return this.textoLido;
    }

    public String[] transferirLeituraCompleta() throws Exception {
        try {
           linha = leitor.readLine();
           texto = new String();
           while(!linha.equals("Cidade inicio;")) {
               texto += linha;
               linha = leitor.readLine();
           }
           textoLido = texto.split(",|;");
           return textoLido;
        }
        catch (Exception erro)
        {
            throw new Exception("erro ao transferir texto");
        }

    }

    public String[] transferirLeitura() throws Exception{
        try{
            linha = leitor.readLine();
            if(linha != null) {
                textoLido = linha.split(",|;");
                return textoLido;
            }
            else{
                textoLido = null;
            return  textoLido;
            }
        }
        catch(Exception erro){
            throw new Exception("erro ao transferir texto");
        }
    }



}
