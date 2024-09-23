package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12};
        System.out.println("Algoritmo antes da ordenação: ");
        System.out.println(Arrays.toString(array));

        bubbleSort(array);
        System.out.println("\nArray depois da ordenação:");
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
