package com.klebson.estruturadados.ifpb.edu.br.exercicios.teste;

import java.util.LinkedList;

import com.klebson.estruturadados.ifpb.edu.br.exercicios.ListaEncadeada;

public class ListaEncadeadaTest {
    public static void main(String[] args) {
        //testesInicias();
        //adicionaInicio();
        //adicionaPorPosicao();
        //removeInicio();
        //removeFinal();
        //removePosicao();
        testeLinkedList();
    }

    public static void testeLinkedList(){
        LinkedList<Integer> lista = new LinkedList<>();

        lista.add(1);
        lista.addFirst(0);
        lista.addLast(3);

        System.out.println(lista.contains(1));

        lista.add(2, 2);

        System.out.println(lista);

        lista.remove();
        System.out.println(lista);

        lista.remove(0);
        lista.removeFirst();
        lista.removeLast();

        System.out.println(lista);
    }


    public static void removePosicao(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        lista.adiciona(4);
        lista.adiciona(5);

        System.out.println("Elemento removido: " + lista.remove(3));
        System.out.println("Lista: " + lista);
    }

    public static void removeFinal(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(3);
        lista.adiciona(2);
        lista.adiciona(1);

        System.out.println(lista.removeFinal());
        System.out.println(lista);
    }

    public static void removeInicio(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

    
        lista.adiciona(3);
        lista.adiciona(2);
        lista.adiciona(1); //1,2,3

        System.out.println(lista.removeInicio());
        System.out.println(lista);
    }

    public static void adicionaInicio(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionaInicio(3);
        lista.adicionaInicio(2);
        lista.adicionaInicio(1); //1,2,3

        System.out.println(lista);
    }

    public static void adicionaPorPosicao(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        // lista.adiciona(-1, 1);
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(4);

        lista.adiciona(0, 0);
        lista.adiciona(4, 5);
        // lista.adiciona(5, 0);

        System.out.println(lista);
    }

    public static void testesInicias(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1);

        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);

        lista.adiciona(2);
        System.out.println(lista);

        lista.adiciona(3);
        System.out.println(lista);

        // lista.limpa();
        // System.out.println(lista);

        System.out.println(lista.busca(0));
        System.out.println(lista.busca(1));
        System.out.println(lista.busca(2));
        System.out.println(lista.busca(3));

        //busca por posição
        System.out.println(lista.buscaPorPosicao(0));
        System.out.println(lista.buscaPorPosicao(1));
        System.out.println(lista.buscaPorPosicao(2));
        System.out.println(lista.buscaPorPosicao(-2));
        System.out.println(lista.buscaPorPosicao(-1));
        System.out.println(lista.buscaPorPosicao(4));
    }
}
