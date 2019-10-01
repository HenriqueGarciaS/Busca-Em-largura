package buscador;

import arvore.No;
import leitor.Leitor;
import java.util.ArrayList;
import resultado.Resultado;

public class Buscador {

    public static void main(String [] args) throws Exception{
        Leitor leitor;
        String [] leitura;
        No raiz;
        ArrayList<Resultado> largura = new ArrayList<Resultado>();
        ArrayList <Resultado> profundidade = new ArrayList<Resultado>();
            leitor = new Leitor("C:\\Users\\Usuario\\IdeaProjects\\Novo Busca em largura\\src\\texto.txt");
            leitura = leitor.transferirLeitura();
            System.out.println(leitura.length);
            raiz = new No(leitura[0],0);
            while(leitura!=null){
                int custo = Integer.parseInt(leitura[2]);
                raiz.insereNo(leitura[0],leitura[1],custo);
                raiz.insereNo(leitura[1],leitura[0],custo);
                    leitura = leitor.transferirLeitura();
            }
            raiz.getCidadesLargura(largura,"F");
            raiz.getCidadesProfundidade(profundidade,"F");
           System.out.println(extraiResultado(largura));
           System.out.println(extraiResultado(profundidade));
   }

   public static String extraiResultado(ArrayList<Resultado> lista){
     String ret = new String();
     int custo = 0;
     for(int i = 0; i < lista.size(); i++){
     custo = custo + lista.get(i).getCusto();
     ret += lista.get(i).getCidade()+" "+custo+" ";
     }
     return ret;
   }
}




