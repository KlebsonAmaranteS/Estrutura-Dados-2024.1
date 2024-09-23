package com.klebson.estruturadados.ifpb.edu.br.exercicios.exercicioEstoque;

public class ListaDuplaEncadeadaProduto {
    private NoDuploProduto inicio;

    public void adicionarProduto(String nome, int quantidade) {
        Produto novoProduto = new Produto(nome, quantidade);
        NoDuploProduto novoNo = new NoDuploProduto(novoProduto);

        if (inicio == null) {
            inicio = novoNo;
        } else {
            NoDuploProduto atual = inicio;
            NoDuploProduto anterior = null;

            while (atual != null && atual.getProduto().getNome().compareTo(novoProduto.getNome()) < 0) {
                anterior = atual;
                atual = atual.getProximo();
            }

            if (atual != null && atual.getProduto().getNome().equals(novoProduto.getNome())) {
                atual.getProduto().setQuantidade(atual.getProduto().getQuantidade() + quantidade);
            } else {
                if (anterior == null) {
                    novoNo.setProximo(inicio);
                    inicio = novoNo;
                } else {
                    anterior.setProximo(novoNo);
                    novoNo.setProximo(atual);
                }
            }
        }
    }

    public void listarProdutos() {
        NoDuploProduto atual = inicio;
        while (atual != null) {
            System.out.println(atual.getProduto());
            atual = atual.getProximo();
        }
    }

    public void retirarProduto(String nome, int quantidade) {
        NoDuploProduto atual = inicio;
        NoDuploProduto anterior = null;

        while (atual != null && !atual.getProduto().getNome().equals(nome.toUpperCase())) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("Produto não encontrado.");
        } else {
            int quantidadeAtual = atual.getProduto().getQuantidade();
            if (quantidade > quantidadeAtual) {
                System.out.println("Quantidade insuficiente. Quantidade disponível: " + quantidadeAtual);
            } else {
                atual.getProduto().setQuantidade(quantidadeAtual - quantidade);
                if (atual.getProduto().getQuantidade() == 0) {
                    if (anterior == null) {
                        inicio = atual.getProximo();
                    } else {
                        anterior.setProximo(atual.getProximo());
                    }
                }
            }
        }
    }

    public void checarProduto(String nome) {
        NoDuploProduto atual = inicio;

        while (atual != null && !atual.getProduto().getNome().equals(nome.toUpperCase())) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto encontrado. Quantidade: " + atual.getProduto().getQuantidade());
        }
    }
}
