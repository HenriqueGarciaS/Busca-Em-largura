package buscador;

import arvore.No;
import leitor.Leitor;
import java.util.ArrayList;

public class Buscador {

    public static void main(String [] args) throws Exception{
        Leitor leitor, leitor1;
        String [] leitura;
        No raiz;
        ArrayList<String> busca = new ArrayList<String>();
            leitor = new Leitor("C:\\Users\\Usuario\\IdeaProjects\\Novo Busca em largura\\src\\texto.txt");
            leitura = leitor.transferirLeitura();
            raiz = new No(leitura[0]);
            while(leitura!=null){
                for(int i = 0 ; i < leitura.length-1 ; i++) {
                    //System.out.println(leitura[i]+" "+leitura[i+1]);
                    raiz.insereNo(leitura[i], leitura[i + 1]);
                    raiz.insereNo(leitura[i+1], leitura[i]);
                }
                    leitura = leitor.transferirLeitura();
            }
            System.out.println(raiz.getCidades());
            /*busca = raiz.busca("Cidade 2");
            for(int i = 0 ; i < busca.size() ; i++)
                System.out.println(busca.get(i));*/
    }
}




