package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Scanner;

public class MaiorValorNaoRecursivo {

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

        int maximo = encontrarMaximo(lista);
        System.out.println("O maior valor é: " + maximo);
    }

    public static int encontrarMaximo(int[] lista) {
        if (lista == null || lista.length == 0) {
            throw new IllegalArgumentException("A lista não pode ser vazia.");
        }
        
        int maximo = lista[0];

        for (int i = 1; i < lista.length; i++) {
            if (lista[i] > maximo) {
                maximo = lista[i];
            }
        }

        return maximo;
    }
}
