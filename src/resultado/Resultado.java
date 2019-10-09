package resultado;

import java.util.ArrayList;

public class Resultado {

    private String cidade;
    private int custo;



    public Resultado(String nome , int preco){
        this.cidade = nome;
        this.custo = preco;
    }

    public String getCidade(){
        return this.cidade;
    }

    public String getCidadeECusto(){
        return this.cidade+" "+this.custo;
    }

    public int getCusto(){
        return this.custo;
    }

    public void setCidade(String nome){
        this.cidade = nome;
    }

    public void setCusto(int preco){
        this.custo = preco;
    }

}
