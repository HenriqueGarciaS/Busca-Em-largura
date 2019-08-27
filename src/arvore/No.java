package arvore;

import java.util.ArrayList;

public class No {

    private String cidade;
    ArrayList<No> conexoes;

    public No(String nome){
        this.cidade = nome;
        this.conexoes = new ArrayList<>();
    }

    public void insereNo(String estaCidade, String conexao) throws Exception{
        try{
            if(cidade.equals(estaCidade)){
                No novo = new No(conexao);
                this.conexoes.add(novo);
            }
            else{
                int i = 0;
                while(!conexoes.get(i).getCidade().equals(estaCidade))
                    i++;
                conexoes.get(i).insereNo(estaCidade,conexao);
            }
        }
        catch(Exception erro)
        {
            throw new Exception("erro a inserir no");
        }

    }

    public String getCidade(){
        return this.cidade;
    }

    public String getCidades(){
        String retorno = this.cidade;
        for(int i = 0; i<conexoes.size();i++)
            retorno+= " "+conexoes.get(i).getCidades();
        return  retorno;
    }



}
