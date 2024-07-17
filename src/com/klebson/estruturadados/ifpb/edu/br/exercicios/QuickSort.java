package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos elementos você deseja ordenar?");
        int n = scanner.nextInt(); 

        int[] arrayParaOrdenar = new int[n];

        System.out.println("Digite os elementos a serem ordenados:");
        for (int i = 0; i < n; i++) {
            arrayParaOrdenar[i] = scanner.nextInt(); 
        }

        quickSort(arrayParaOrdenar, 0, arrayParaOrdenar.length - 1);

        System.out.println("Array ordenado:");
        for (int elemento : arrayParaOrdenar) {
            System.out.print(elemento + " ");
        }
        scanner.close();
 }
    
    public static void quickSort(int[] array, int inicio, int fim){
        if(inicio < fim){
            int indiceParticao = particionar(array, inicio, fim);

            quickSort(array, inicio, indiceParticao - 1);
            quickSort(array, indiceParticao + 1, fim);
        }
    }

    public static int particionar(int[] arr, int inicio, int fim){
        int pivot = arr[inicio];
        int i = inicio + 1;

        for(int j = i; j <= fim; j++){ 
            if(arr[j] < pivot){
                trocar(arr, i, j);
                i++;
            }
        }
        trocar(arr, inicio, i - 1);
        return i - 1;
    }

    private static void trocar(int[] arr, int i, int f){
        int temp = arr[i];
        arr[i] = arr[f];
        arr[f] = temp;
    }
}
