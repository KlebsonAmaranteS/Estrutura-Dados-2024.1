package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioEstoque;

public class Produto {
    private String nome;
    private int quantidade;

    public Produto(String nome, int quantidade) {
        this.nome = nome.toUpperCase();
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome + ": " + quantidade;
    }
}

