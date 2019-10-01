package arvore;


import resultado.Resultado;

import java.util.ArrayList;

public class No {

    private String cidade;
    private ArrayList<No> conexoes;
    private int custo;

    public No(String nome, int preco){
        this.cidade = nome;
        this.conexoes = new ArrayList<No>();
        this.custo = preco;
    }

    public boolean insereNo(String estaCidade, String conexao, int preco) throws Exception{
        try{
             if(this.cidade.equals(estaCidade)){
                 No novo = new No(conexao,preco);
                 this.conexoes.add(novo);
                 return true;
             }
             else{
                 for(int i = 0; i<conexoes.size(); i++)
                     this.conexoes.get(i).insereNo(estaCidade,conexao,preco);
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

    public String getCustos(){
        String ret =""+ this.custo;
        for(int i = 0 ; i < this.conexoes.size(); i++)
        ret +=" "+ this.conexoes.get(i).getCustos();
        return ret;
    }



    public String getCidades(){
        String retorno = this.cidade;
        for(int i = 0; i<conexoes.size();i++)
            retorno+= " "+conexoes.get(i).getCidades();
        return  retorno;
    }

    public Resultado criaResultado(){
        Resultado novo =  new Resultado(this.cidade,this.custo);
        return novo;
    }

    public void getCidadesLargura(ArrayList<Resultado> largura, String destino)
    {
        if(this.estaEmConexoes(destino)){
            largura.add(this.criaResultado());
            for(int i = 0; i < this.conexoes.size(); i++)
                largura.add(this.conexoes.get(i).criaResultado());
        }
        else{
            if(!largura.contains(this.criaResultado()))
                largura.add(this.criaResultado());
            for(int i = 0; i < this.conexoes.size(); i++)
               if(!largura.contains(this.conexoes.get(i).criaResultado()))
                   largura.add(this.conexoes.get(i).criaResultado());
               for(int i = 0; i < this.conexoes.size(); i++)
               this.conexoes.get(i).getCidadesLargura(largura,destino);
        }
       /*
        else {
            if(!largura.isEmpty()) {
                if (!largura.contains(this.criaResultado()))
                    largura.add(this.criaResultado());
                for(int i = 0 ; i < this.conexoes.size(); i++)
                    if(!largura.contains(this.conexoes.get(i).criaResultado()))
                        largura.add(this.conexoes.get(i).criaResultado());
                    for(int i = 0 ; i < this.conexoes.size(); i++)
                        this.conexoes.get(i).getCidadesLargura(largura, destino);
            }
            else {
                largura.add(this.criaResultado());
                for (int i = 0; i < this.conexoes.size(); i++)
                    largura.add(this.conexoes.get(i).criaResultado());
                for (int i = 0; i < this.conexoes.size(); i++)
                    this.conexoes.get(i).getCidadesLargura(largura, destino);
            }
        }*/
    }

    public void getCidadesProfundidade(ArrayList<Resultado> profundidade, String destino) {
        if(this.estaEmConexoes(destino)){
             profundidade.add(this.criaResultado());
             int i = 0;
             while(!this.conexoes.get(i).getCidade().equals(destino))
                 i++;
             profundidade.add(this.conexoes.get(i).criaResultado());
         }
         else{

                 if (!profundidade.contains(this.criaResultado()))
                     profundidade.add(this.criaResultado());
                 for (int i = 0; i < this.conexoes.size(); i++)
                     this.conexoes.get(i).getCidadesProfundidade(profundidade, destino);

         }

    }

    private boolean estaEmConexoes(String destino){
        for(int i = 0; i < this.conexoes.size(); i++)
            if(this.conexoes.get(i).getCidade().equals(destino))
                return true;
        return false;
    }



}
