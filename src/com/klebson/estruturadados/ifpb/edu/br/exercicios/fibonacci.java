package com.klebson.estruturadados.ifpb.edu.br.exercicios;
import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {

        System.out.println("Digite um valor: ");
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();

        System.out.print("Sequência de Fibonacci até " + valor + " termos: ");
        for (int i = 0; i < valor; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int valor) {
        if (valor <= 1) { // 0 1 1 2 3
            return valor;
        }
        return fibonacci(valor - 1) + fibonacci(valor - 2);
    }
}
