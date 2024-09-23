package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreRecursiva.teste;
import com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreRecursiva.Arvore;

public class ArvoreTeste {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.adicionar(2);
        arvore.adicionar(3);
        arvore.adicionar(4);
        

        System.out.println(arvore);
    }
}
