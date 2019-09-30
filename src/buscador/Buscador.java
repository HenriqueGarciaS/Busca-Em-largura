package buscador;

import arvore.No;
import leitor.Leitor;
import java.util.ArrayList;

public class Buscador {

    public static void main(String [] args) throws Exception{
        Leitor leitor;
        String [] leitura;
        No raiz;
        ArrayList<String> largura = new ArrayList<String>();
        ArrayList <String> profundidade = new ArrayList<String>();
            leitor = new Leitor("C:\\Users\\Usuario\\IdeaProjects\\Novo Busca em largura\\src\\texto.txt");
            leitura = leitor.transferirLeitura();
            int custoInicial = Integer.parseInt(leitura[2]);
            raiz = new No(leitura[0],custoInicial);
            while(leitura!=null){
                for(int i = 0 ; i < leitura.length-1 ; i++) {
                    int custo = Integer.parseInt(leitura[2]);
                    raiz.insereNo(leitura[i], leitura[i + 1],custo);
                    raiz.insereNo(leitura[i+1], leitura[i],custo);
                }
                    leitura = leitor.transferirLeitura();
            }
            raiz.getCidadesLargura(largura,"G");
            for(int i = 0 ; i < largura.size(); i++ )
               System.out.println(largura.get(i));
            //raiz.getCidadesProfundidade(profundidade,"J");
            //for(int i = 0; i < profundidade.size(); i++)
              //  System.out.println(profundidade.get(i));
    }
}




