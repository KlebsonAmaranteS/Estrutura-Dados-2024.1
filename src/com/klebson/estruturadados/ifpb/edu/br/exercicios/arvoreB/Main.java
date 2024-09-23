package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreB;

public class Main {
    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB(4);

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(52);
        arvore.inserir(5);
        arvore.inserir(6);
        arvore.inserir(12);
        arvore.inserir(30);
        arvore.inserir(7);
        arvore.inserir(17);
        arvore.inserir(18);

        System.out.println("Percorrendo a árvore B:");
        arvore.percorrer();
        System.out.println();

        arvore.remover(6);
        System.out.println("Percorrendo a árvore B após remover 6:");
        arvore.percorrer();
        System.out.println();

        arvore.remover(13);  
    }
}

