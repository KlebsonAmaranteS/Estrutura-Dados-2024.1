package com.klebson.estruturadados.ifpb.edu.br.exercicios.teste;

import com.klebson.estruturadados.ifpb.edu.br.exercicios.ListaEncadeadaCircular;

public class TesteListaEncadeadaCircular {

    public static void main(String[] args) {
        ListaEncadeadaCircular<Integer> lista = new ListaEncadeadaCircular<>();

        System.out.println("Adicionando elementos ao final da lista:");
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        System.out.println(lista); // Deve mostrar: [1, 2, 3]

        System.out.println("\nAdicionando elemento ao início da lista:");
        lista.adicionaInicio(0);
        System.out.println(lista); // Deve mostrar: [0, 1, 2, 3]

        System.out.println("\nAdicionando elemento na posição 2:");
        lista.adiciona(2, 5);
        System.out.println(lista); // Deve mostrar: [0, 1, 5, 2, 3]

        System.out.println("\nRemovendo o elemento de posição 2:");
        lista.remove(2);
        System.out.println(lista); // Deve mostrar: [0, 1, 2, 3]

        System.out.println("\nEstado final da lista:");
        System.out.println(lista); // Deve mostrar: [0, 1, 2, 3]
    }
}
