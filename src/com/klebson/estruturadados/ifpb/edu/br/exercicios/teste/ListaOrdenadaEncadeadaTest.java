package com.klebson.estruturadados.ifpb.edu.br.exercicios.teste;

import com.klebson.estruturadados.ifpb.edu.br.exercicios.ListaEncadeadaOrdenada;

public class ListaOrdenadaEncadeadaTest {
        public static void main(String[] args) {
            ListaEncadeadaOrdenada lista = new ListaEncadeadaOrdenada();
        
            // Adicionando elementos
            lista.adicionar(5);
            lista.adicionar(3);
            lista.adicionar(9);
            lista.adicionar(1);
            lista.adicionar(4);
    
            System.out.println("Lista após adições:");
            imprimirLista(lista);
    
            // Removendo elemento pelo índice
            System.out.println("\nRemovendo elemento no índice 2 (valor 4):");
            lista.removerPorIndex(2);
            imprimirLista(lista);
    
            // Removendo o primeiro elemento
            System.out.println("\nRemovendo o primeiro elemento:");
            lista.remover();
            imprimirLista(lista);
    
            // Obtendo um nodo pelo índice
            System.out.println("\nObtendo o valor no índice 1:");
            System.out.println(lista.getNodo(2));
    
            // Mostrando o tamanho da lista
            System.out.println("\nTamanho da lista:");
            System.out.println(lista.tamanho());
        }
    
        private static void imprimirLista(ListaEncadeadaOrdenada lista) {
            for (int i = 0; i < lista.tamanho(); i++) {
                System.out.print(lista.getNodo(i) + " ");
            }
            System.out.println(); 
        }
    }
    


