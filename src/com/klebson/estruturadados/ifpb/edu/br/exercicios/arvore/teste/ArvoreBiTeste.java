package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvore.teste;

import com.klebson.estruturadados.ifpb.edu.br.exercicios.arvore.ArvoreBinaria;

public class ArvoreBiTeste {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(2);
        arvore.inserir(4);
        arvore.inserir(6);
        arvore.inserir(1);

        System.out.println(arvore);

        arvore.remover(4);

        System.out.println(arvore);

        arvore.removerInicio();

        System.out.println(arvore);

        arvore.removerFim();

        System.out.println(arvore);
    }
}
