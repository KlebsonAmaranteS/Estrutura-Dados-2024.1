package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class MenorValor {
    public static void main(String[] args) {
        int[] valores = {5,6,1,2,8};
        int menor = valores[0];

       for(int i = 1; i < valores.length; i++){
           if (valores[i] < menor){
               menor = valores[i];
           }
       }
        System.out.println("O menor valor é: " + menor);
    }
}
