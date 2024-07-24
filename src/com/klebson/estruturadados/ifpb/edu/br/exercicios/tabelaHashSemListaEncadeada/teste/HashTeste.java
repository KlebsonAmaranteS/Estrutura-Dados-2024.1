package com.klebson.estruturadados.ifpb.edu.br.exercicios.tabelaHashSemListaEncadeada.teste;

import com.klebson.estruturadados.ifpb.edu.br.exercicios.tabelaHashSemListaEncadeada.TabelaHash;

public class HashTeste{
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(10);
        tabela.inserirValor(123, "João");
        tabela.inserirValor(234, "Maria");
        tabela.inserirValor(345, "José");

        System.out.println("Nome do aluno com matrícula 123: " + tabela.pegarValor(123));
        System.out.println("Nome do aluno com matrícula 234: " + tabela.pegarValor(234));

        tabela.removerValor(123);
        System.out.println("Nome do aluno com matrícula 123 após remoção: " + tabela.pegarValor(123));

        System.out.println("Estado atual da tabela: " + tabela.toString());
    }
}

