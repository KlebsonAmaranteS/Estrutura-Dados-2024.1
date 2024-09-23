package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Scanner;

public class MaiorValor {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

    
        System.out.print("Quantos números você deseja inserir? ");
        int tamanho = scanner.nextInt();

        int[] lista = new int[tamanho];


        System.out.println("Digite os " + tamanho + " números:");
        for (int i = 0; i < tamanho; i++) {
            lista[i] = scanner.nextInt();
        }

        scanner.close();

        int maximo = encontrarMaximo(lista, lista.length);
        System.out.println("O maior valor é: " + maximo);
    }

    public static int encontrarMaximo(int[] lista, int tamanho) {
        if (tamanho == 1) {
            return lista[0];
        } else {
            int maximo = encontrarMaximo(lista, tamanho - 1);
            if (lista[tamanho - 1] > maximo) {
                return lista[tamanho - 1];
            } else {
                return maximo;
            }
        }
    }
}
