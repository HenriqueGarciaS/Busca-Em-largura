package buscador;

import arvore.No;
import leitor.Leitor;
import java.util.ArrayList;

public class Buscador {

    public static void main(String [] args) throws Exception{
        Leitor leitor;
        String [] leitura;
        No raiz;
        int calculo1 = 0,calculo2 = 0, calculo3 = 0;
        ArrayList<String> largura = new ArrayList<String>();
        ArrayList<String> profundidade = new ArrayList<String>();
        ArrayList<String> abertura = new ArrayList<String>();
        ArrayList<String> uniforme = new ArrayList<String>();
        leitor = new Leitor("C:\\Users\\Usuario\\IdeaProjects\\Novo Busca em largura\\src\\texto.txt");
        leitura = leitor.transferirLeitura();
        raiz = new No(leitura[0],0);
        while(leitura!=null && leitura.length!= 1){
            int custo = Integer.parseInt(leitura[2]);
            raiz.insereNo(leitura[0],leitura[1],custo);
            raiz.insereNo(leitura[1],leitura[0],custo);
            leitura = leitor.transferirLeitura();
        }
        String origem = leitura[0];
        leitura = leitor.transferirLeitura();
        String destino = leitura[0];
        raiz.buscarNesteNo(origem, largura, destino, calculo1, 1);
        raiz.buscarNesteNo(origem, profundidade, destino, calculo2, 2);
        raiz.buscarNesteNo(origem, uniforme, destino, calculo3, 3);
        raiz.buscarNesteNo(origem, abertura, destino, 0, 4);
        imprimeBuscas(largura,profundidade,uniforme,abertura);
    }

    public static void imprimeBuscas(ArrayList<String> largura, ArrayList<String> profundidade, ArrayList<String> uniforme, ArrayList<String> abertura ) {
        System.out.println("Abertura da arvore em largura:");
        for(String s : abertura)
            System.out.print(s+"->");
        System.out.println();
        System.out.println("caminho de largura:");
        for(String s : largura)
            System.out.print(s+"->");
        System.out.println();
        System.out.println("caminho de profundiade:");
        for(String s : profundidade)
            System.out.print(s+"->");
        System.out.println();
        System.out.println("caminho de custo uniforme:");
        for(String s : uniforme)
            System.out.print(s+"->");
        System.out.println();

    }
}


