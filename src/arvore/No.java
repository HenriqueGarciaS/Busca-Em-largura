package arvore;

import java.util.ArrayList;

public class No {

    private String cidade;
    private ArrayList<No> conexoes;

    public No(String nome){
        this.cidade = nome;
        this.conexoes = new ArrayList<No>();
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



    private boolean estaEmConexoes(String cidade){
        for(int i = 0 ; i<conexoes.size(); i++)
            if(conexoes.get(i).equals(cidade))
                return true;
            return false;
    }

    public int buscaEmLargura(ArrayList<String> busca, String destino){
        if(busca.isEmpty() == true) {
            busca.add(this.cidade);
            for(int i = 0; i < this.conexoes.size(); i++)
                busca.add(this.conexoes.get(i).getCidade());
            for(int i = 0; i < busca.size(); i++)
                if(busca.get(i).equals(destino))
                    return 1;
                for(int i = 0; i< busca.size(); i++)
                    return this.conexoes.get(i).buscaEmLargura(busca, destino);
        }
        if(estaEmConexoes(destino) == true) {
            busca.add(this.cidade);
            for (int i = 0; i < this.conexoes.size(); i++)
                for(int j = 0; j < busca.size(); j++)
                    if(!busca.get(j).equals(this.conexoes.get(i).getCidade()))
                        busca.add(this.conexoes.get(i).getCidade());
                    return 1;
        }
        return 1;
    }

}
