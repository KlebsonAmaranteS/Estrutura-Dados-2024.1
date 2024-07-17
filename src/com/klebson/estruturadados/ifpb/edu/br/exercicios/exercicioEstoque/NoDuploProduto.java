package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioEstoque;

public class NoDuploProduto {
    private Produto produto;
    private NoDuploProduto proximo;

    public NoDuploProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public NoDuploProduto getProximo() {
        return proximo;
    }

    public void setProximo(NoDuploProduto proximo) {
        this.proximo = proximo;
    }
}
