package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Scanner;

public class OrdenacaoRecursiva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de elementos:");
        int numeroDeElementos = scanner.nextInt();
        int[] array = new int[numeroDeElementos];

        System.out.println("Digite os elementos um por um:");
        for (int i = 0; i < numeroDeElementos; i++) {
            array[i] = scanner.nextInt();
        }

        ordenacaoPorSelecaoRecursiva(array, 0);

        System.out.println("Array ordenado:");
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        scanner.close();
    }

    private static void ordenacaoPorSelecaoRecursiva(int[] array, int inicio) {
        if (inicio < array.length - 1) {
            int indiceDoMenor = inicio;
            for (int i = inicio + 1; i < array.length; i++) {
                if (array[i] < array[indiceDoMenor]) {
                    indiceDoMenor = i;
                }
            }
            int temp = array[indiceDoMenor];
            array[indiceDoMenor] = array[inicio];
            array[inicio] = temp;

            ordenacaoPorSelecaoRecursiva(array, inicio + 1);
        }
    }
}
