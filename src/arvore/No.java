package arvore;

import java.util.ArrayList;

public class No {

    private String cidade;
    ArrayList<No> conexoes;

    public No(String nome){
        this.cidade = nome;
        this.conexoes = new ArrayList<>();
    }

    public boolean insereNo(String estaCidade, String conexao) throws Exception{
        try{
             if(this.cidade.equals(estaCidade)){
                 No novo = new No(conexao);
                 this.conexoes.add(novo);
                 return true;
             }
             else{
                 for(int i = 0; i<conexoes.size(); i++)
                     this.conexoes.get(i).insereNo(estaCidade,conexao);
                 return true;
             }

        }
        catch(Exception erro)
        {
            throw new Exception("erro a inserir novo no");
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

    public boolean estaEmConexoes(String cidade){
        for(int i = 0 ; i<conexoes.size(); i++)
            if(conexoes.get(i).equals(cidade))
                return true;
            return false;
    }


}
