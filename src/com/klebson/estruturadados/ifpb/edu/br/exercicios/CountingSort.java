package com.klebson.estruturadados.ifpb.edu.br.exercicios;

import java.util.Scanner;

public class CountingSort {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Quantos números você deseja ordenar?");
    int tamanho = scanner.nextInt();

    int[] array = new int[tamanho];

    System.out.println("Digite os números para ordenar:");
    for (int i = 0; i < tamanho; i++) {
      array[i] = scanner.nextInt();
    }

    countingSort(array);

    System.out.println("Array ordenado:");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  static void countingSort(int[] array) {
    int maximo = array[0];
    int minimo = array[0];

    for(int i = 1; i < array.length; i++){
        if(array[i] > maximo){
            maximo = array[i];
        } else if(array[i] < minimo){
            minimo = array[i];
        }
    }
   
    int intervalo = maximo - minimo + 1;
    int[] contagem = new int[intervalo];
    int[] saida = new int[array.length];
    
    for (int i = 0; i < array.length; i++) {
        contagem[array[i] - minimo] ++;
    }
    
    for (int i = 1; i < contagem.length; i++) {
        contagem[i] += contagem[i - 1];
    }
    
    for (int i = array.length - 1; i >= 0; i--) {
        saida[contagem[array[i] - minimo] - 1] = array[i];
        contagem[array[i] - minimo]--;
    }
    
    for (int i = 0; i < array.length; i++) {
        array[i] = saida[i];
    }
  }
}