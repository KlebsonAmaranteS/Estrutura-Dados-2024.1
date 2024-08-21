package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class Tabuada {

    public static void main(String[] args) {
        int multiplicadorFixo = 10;
        int n = 10;

        for(int i = 1; i <= n; ++i) {
            int resultado = i * multiplicadorFixo;
            System.out.println("" + i + " * 10 = " + resultado);
        }
    }
}
