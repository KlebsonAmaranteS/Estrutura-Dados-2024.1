package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreAVL;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        // inserção
        arvore.raiz = arvore.inserir(arvore.raiz, 10);
        arvore.raiz = arvore.inserir(arvore.raiz, 20);
        arvore.raiz = arvore.inserir(arvore.raiz, 30);
        arvore.raiz = arvore.inserir(arvore.raiz, 40);
        arvore.raiz = arvore.inserir(arvore.raiz, 50);
        arvore.raiz = arvore.inserir(arvore.raiz, 25);

        // Exibe a árvore em diferentes ordens
        System.out.println("Pre-order traversal:");
        arvore.preOrder(arvore.raiz);
        System.out.println("\nIn-order traversal:");
        arvore.inOrder(arvore.raiz);
        System.out.println("\nPost-order traversal:");
        arvore.postOrder(arvore.raiz);

        // remoção
        System.out.println("\n\nRemovendo o nó com valor 40");
        arvore.raiz = arvore.remover(arvore.raiz, 40);

        System.out.println("In-order traversal após remover 40:");
        arvore.inOrder(arvore.raiz);

        // busca
        int valorParaBuscar = 25;
        No resultado = arvore.buscar(arvore.raiz, valorParaBuscar);
        if (resultado != null) {
            System.out.println("\n\nValor " + valorParaBuscar + " encontrado na árvore.");
        } else {
            System.out.println("\n\nValor " + valorParaBuscar + " não encontrado na árvore.");
        }
    }
}
