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
            for(int i = 1 ; i<leitura.length; i++) {
                raiz.insereNo(leitura[i-1],leitura[i]);
                System.out.println("inseriu no");
            }
            System.out.println(raiz.getSize());
            System.out.println(raiz.getSizedoNo());


    }



}
