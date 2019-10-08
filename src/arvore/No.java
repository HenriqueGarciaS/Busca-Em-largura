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

    public String getCustos(){
        String ret =""+ this.custo;
        for(int i = 0 ; i < this.conexoes.size(); i++)
            ret +=" "+ this.conexoes.get(i).getCustos();
        return ret;
    }

    public int getCusto() {
        return this.custo;
    }

    public int getSize(){
        return this.conexoes.size();
    }

    public String getCidades(){
        String retorno = this.cidade;
        for(int i = 0; i<conexoes.size();i++)
            retorno+= " "+conexoes.get(i).getCidades();
        return  retorno;
    }


    private boolean estaEmConexoes(String destino){
        for(int i = 0; i < this.conexoes.size(); i++)
            if(this.conexoes.get(i).getCidade().equals(destino))
                return true;
        return false;
    }

    public int menorPosicao(){
        if(this.conexoes.size() > 0) {
            int posicao = 0;
            int menorCusto = 0;
            for (int i = 0; i < this.conexoes.size(); i++) {
                if (menorCusto == 0) {
                    menorCusto = this.conexoes.get(i).getCusto();
                    posicao = i;
                }
                else if (menorCusto >= this.conexoes.get(i).getCusto()) {
                    if(this.conexoes.get(i).getSize() >= this.conexoes.get(posicao).getSize()) {
                        menorCusto = this.conexoes.get(i).getCusto();
                        posicao = i;
                    }
                }
            }
            return posicao;
        }
        return -1;
    }

    public void AbrirLargura(ArrayList<String> largura, String destino) {
        if(!largura.contains(destino)) {
            if(this.estaEmConexoes(destino)){
                if(!largura.contains(this.cidade))
                    largura.add(this.cidade);
                for(int i = 0; i < this.conexoes.size(); i++)
                    largura.add(this.conexoes.get(i).getCidade());
            }
            else{
                if(!largura.contains(this.cidade))
                    largura.add(this.cidade);
                for(int i = 0; i < this.conexoes.size(); i++) {
                    if(!largura.contains(this.conexoes.get(i).getCidade()))
                        largura.add(this.conexoes.get(i).getCidade());
                }
                for(int i = 0; i < this.conexoes.size(); i++)
                    this.conexoes.get(i).AbrirLargura(largura,destino);
            }
        }
    }

    public void getCidadeUniforme(int calculo,ArrayList<String> uniforme, String destino){
        if(!uniforme.contains(destino)){
            if(this.estaEmConexoes(destino)){
                if(!uniforme.contains(this.cidade)){
                    uniforme.add(this.cidade);
                    calculo = calculo + this.custo;
                }
                int i = 0;
                while(!this.conexoes.get(i).getCidade().equals(destino))
                i++;
                uniforme.add(this.conexoes.get(i).getCidade());
                calculo = calculo + this.custo;
                System.out.println("Custo uniforme: "+calculo);
            }
            else {
                if (!uniforme.contains(this.cidade)) {
                    uniforme.add(this.cidade);
                    calculo = calculo + this.custo;
                }
                for (int i = 0; i < this.conexoes.size(); i++)
                    if (this.conexoes.get(i).estaEmConexoes(destino)) {
                        this.conexoes.get(i).getCidadeUniforme(calculo, uniforme, destino);
                        break;
                    }
                    if(this.menorPosicao() == -1){
                        for(int i = 0 ; i < this.conexoes.size(); i++)
                            this.conexoes.get(i).getCidadeUniforme(calculo,uniforme,destino);
                    }
                    else
                        this.conexoes.get(this.menorPosicao()).getCidadeUniforme(calculo, uniforme, destino);
            }
        }
        }


    public void getCidadesLargura(int calculo, ArrayList<String> largura, String destino)
    {
        if(!largura.contains(destino)){
            if(this.estaEmConexoes(destino)){
                if(!largura.contains(this.cidade)){
                    largura.add(this.cidade);
                    calculo = calculo + this.custo;
                }
                int i = 0;
                while(!this.conexoes.get(i).getCidade().equals(destino))
                    i++;
                largura.add(this.conexoes.get(i).getCidade());
                calculo = calculo + this.conexoes.get(i).getCusto();
                System.out.println("custo de largura: "+calculo);
            }
            else{
                if(!largura.contains(this.cidade)){
                    largura.add(this.cidade);
                    calculo = calculo + this.custo;
                }
                for(int i = 0 ; i < this.conexoes.size(); i++)
                    if(this.conexoes.get(i).estaEmConexoes(destino)) {
                        this.conexoes.get(i).getCidadesLargura(calculo, largura, destino);
                        break;
                    }
                for(int i = 0; i < this.conexoes.size(); i++)
                    this.conexoes.get(i).getCidadesLargura(calculo,largura,destino);
            }
        }
    }

    public void getCidadesProfundidade(int calculo, ArrayList<String> profundidade, String destino) {
        if(!profundidade.contains(destino)) {
            if(this.estaEmConexoes(destino)){
                profundidade.add(this.cidade);
                calculo = calculo + this.custo;
                int i = 0;
                while(!this.conexoes.get(i).getCidade().equals(destino))
                    i++;
                profundidade.add(this.conexoes.get(i).getCidade());
                calculo = calculo + this.conexoes.get(i).getCusto();
                System.out.println("custo de profundidade: "+calculo);
            }
            else{

                if (!profundidade.contains(this.cidade)) {
                    profundidade.add(this.cidade);
                    calculo = calculo + this.custo;
                }
                for (int i = 0; i < this.conexoes.size(); i++)
                    this.conexoes.get(i).getCidadesProfundidade(calculo,profundidade, destino);

            }
        }

    }

}