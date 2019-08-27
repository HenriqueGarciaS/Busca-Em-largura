package buscador;

import arvore.No;
import leitor.Leitor;

public class Buscador {

    public static void main(String [] args) throws Exception{
        Leitor leitor;
        String [] leitura;
        No raiz;
            leitor = new Leitor("C:\\Users\\Usuario\\IdeaProjects\\Novo Busca em largura\\src\\texto.txt");
            leitura = leitor.transferirLeitura();
            raiz = new No(leitura[0]);
            while(leitura!=null){
                for(int i=0;i<leitura.length-1;i++)
                raiz.insereNo(leitura[i],leitura[i+1]);
                leitura = leitor.transferirLeitura();
            }
            System.out.println(raiz.getCidades());
    }



}
