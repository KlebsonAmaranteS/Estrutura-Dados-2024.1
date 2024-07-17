package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class OrdenarLista {

    public static void main(String[] args) {
        int[] numeros = {6, 10, 8, 1, 3, 2};

        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}
