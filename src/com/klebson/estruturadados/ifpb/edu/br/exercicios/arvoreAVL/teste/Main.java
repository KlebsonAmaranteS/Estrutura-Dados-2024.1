package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreAVL.teste;

import com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreAVL.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.adicionar(50);
        arvore.adicionar(30);
        arvore.adicionar(70);
        arvore.adicionar(20);
        arvore.adicionar(40);
        arvore.adicionar(60);
        arvore.adicionar(80);

        System.out.println("Impressão em Pré-Ordem:");
        arvore.imprimirPreOrdem(arvore.getRaiz());

        System.out.println("\nImpressão em Ordem:");
        arvore.imprimirEmOrdem(arvore.getRaiz());

        System.out.println("\nImpressão em Pós-Ordem:");
        arvore.imprimirPosOrdem(arvore.getRaiz());

        System.out.println("\nBusca pelo elemento 40: " + arvore.busca(40));
        System.out.println("Busca pelo elemento 90: " + arvore.busca(90));

        System.out.println("\nRemovendo o elemento 20");
        arvore.remover(20);
        System.out.println("Impressão em Ordem após remoção:");
        arvore.imprimirEmOrdem(arvore.getRaiz());

        System.out.println("\nRemovendo o elemento 30");
        arvore.remover(30);
        System.out.println("Impressão em Ordem após remoção:");
        arvore.imprimirEmOrdem(arvore.getRaiz());

        System.out.println("\nRemovendo o elemento 50");
        arvore.remover(50);
        System.out.println("Impressão em Ordem após remoção:");
        arvore.imprimirEmOrdem(arvore.getRaiz());
    }
}
