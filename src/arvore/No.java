package arvore;


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



    public String getCidades(){
        String retorno = this.cidade;
        for(int i = 0; i<conexoes.size();i++)
            retorno+= " "+conexoes.get(i).getCidades();
        return  retorno;
    }

    public void getCidadesLargura(ArrayList<String> largura,String destino)
    {
        if(this.estaEmConexoes(destino)){
            largura.add(this.getCidade());
            for(int i = 0; i < this.conexoes.size(); i++)
                largura.add(this.conexoes.get(i).getCidade());
        }
        else {
            if(!largura.isEmpty()) {
                if (!largura.contains(this.getCidade()))
                    largura.add(this.getCidade());
                for(int i = 0 ; i < this.conexoes.size(); i++)
                    if(!largura.contains(this.conexoes.get(i).getCidade()))
                        largura.add(this.conexoes.get(i).getCidade());
                    for(int i = 0 ; i < this.conexoes.size(); i++)
                        this.conexoes.get(i).getCidadesLargura(largura, destino);
            }
            else {
                largura.add(this.getCidade());
                for (int i = 0; i < this.conexoes.size(); i++)
                    largura.add(this.conexoes.get(i).getCidade());
                for (int i = 0; i < this.conexoes.size(); i++)
                    this.conexoes.get(i).getCidadesLargura(largura, destino);
            }
        }
    }

    public void getCidadesProfundidade(ArrayList<String> profundidade, String destino) {
         if(this.estaEmConexoes(destino)){
             profundidade.add(this.getCidade());
             int i = 0;
             while(!this.conexoes.get(i).getCidade().equals(destino))
                 i++;
             profundidade.add(this.conexoes.get(i).getCidade());
         }
         else{
             if(!profundidade.isEmpty()) {
                 if (!profundidade.contains(this.cidade))
                     profundidade.add(this.cidade);
                 for (int i = 0; i < this.conexoes.size(); i++)
                     this.conexoes.get(i).getCidadesProfundidade(profundidade, destino);
             }
             else{
                 profundidade.add(this.getCidade());
                 for(int i = 0; i < this.conexoes.size(); i++)
                     this.conexoes.get(i).getCidadesProfundidade(profundidade, destino);
             }

         }

    }

    private boolean estaEmConexoes(String destino){
        for(int i = 0; i < this.conexoes.size(); i++)
            if(this.conexoes.get(i).getCidade().equals(destino))
                return true;
        return false;
    }



}
