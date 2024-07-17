package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Scanner;

public class OrdenacaoIterativa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de elementos:");
        int numeroDeElementos = scanner.nextInt();
        int[] array = new int[numeroDeElementos];

        System.out.println("Digite os elementos um por um:");
        for (int i = 0; i < numeroDeElementos; i++) {
            array[i] = scanner.nextInt();
        }

        ordenacaoPorSelecaoIterativa(array);

        System.out.println("Array ordenado:");
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        scanner.close();
    }

    private static void ordenacaoPorSelecaoIterativa(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indiceDoMenor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indiceDoMenor]) {
                    indiceDoMenor = j;
                }
            }
            int temp = array[indiceDoMenor];
            array[indiceDoMenor] = array[i];
            array[i] = temp;
        }
    }
}

