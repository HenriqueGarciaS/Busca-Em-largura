package buscador;

import arvore.No;
import leitor.Leitor;

public class Buscador {

    public static void main(String [] args) throws Exception{
        Leitor leitor, leitor1;
        String [] leitura;
        No raiz;
            leitor = new Leitor("C:\\Users\\Usuario\\IdeaProjects\\Novo Busca em largura\\src\\texto.txt");
            leitor1 = new Leitor("C:\\Users\\Usuario\\IdeaProjects\\Novo Busca em largura\\src\\texto.txt");
            leitura = leitor.transferirLeitura();
            raiz = new No(leitura[0]);
            while(leitura!=null){
                for(int i = 0 ; i < leitura.length-1 ; i++) {
                    System.out.println(leitura[i]+" "+leitura[i+1]);
                    raiz.insereNo(leitura[i], leitura[i + 1]);
                }
                    leitura = leitor.transferirLeitura();
            }
            leitura = leitor1.transferirLeitura();
            while(leitura!=null){
                for( int i = 0; i < leitura.length-1 ; i++) {
                    System.out.println(leitura[i+1] + " " + leitura[i]);
                    raiz.insereNo(leitura[i + 1], leitura[i]);
                }
                leitura = leitor1.transferirLeitura();
            }
            getCidadesRaiz(raiz);
    }

     public static void getCidadesRaiz(No raiz){
        System.out.println(raiz.getCidades());

    }



}
