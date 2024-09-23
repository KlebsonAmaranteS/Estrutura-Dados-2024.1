package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class ListaEncadeadaCircular<T> {

    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int tamanho = 0;
    private final String NAO_EXISTE = "Posição não existe.";
    private final String LISTA_VAZIA = "Lista vazia.";

    public void adiciona(T elemento) {
        Nodo<T> novoNo = new Nodo<>(elemento);
        if (this.tamanho == 0) {
            this.inicio = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
        }
        novoNo.setProximo(this.inicio); 
        this.ultimo = novoNo;
        this.tamanho++;
    }

    public void adicionaInicio(T elemento) {
        Nodo<T> novoNo = new Nodo<>(elemento);
        if (this.tamanho == 0) {
            this.inicio = this.ultimo = novoNo;
            novoNo.setProximo(novoNo); 
        } else {
            novoNo.setProximo(this.inicio);
            this.inicio = novoNo;
            this.ultimo.setProximo(this.inicio); 
        }
        this.tamanho++;
    }

    public void adiciona(int posicao, T elemento) {
        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        if (posicao == 0) {
            this.adicionaInicio(elemento);
        } else if (posicao == this.tamanho) {
            this.adiciona(elemento);
        } else {
            Nodo<T> noAnterior = this.buscaNo(posicao - 1);
            Nodo<T> novoNo = new Nodo<>(elemento, noAnterior.getProximo());
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    public T remove(int posicao) {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }

        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        Nodo<T> removido = null;

        if (posicao == 0) {
            removido = this.inicio;
            this.inicio = this.inicio.getProximo();
            this.ultimo.setProximo(this.inicio);
            if (this.tamanho == 1) {
                this.ultimo = null; 
            }
        } else {
            Nodo<T> noAnterior = this.buscaNo(posicao - 1);
            removido = noAnterior.getProximo();
            noAnterior.setProximo(removido.getProximo());
            if (posicao == this.tamanho - 1) { 
                this.ultimo = noAnterior;
            }
        }

        this.tamanho--;

        return removido.getElemento();
    }

    private boolean posicaoNaoExiste(int posicao) {
        return posicao < 0 || posicao >= this.tamanho;
    }

    private Nodo<T> buscaNo(int posicao) {
        Nodo<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public void limpa() {
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Nodo<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            builder.append(atual.getElemento().toString());
            atual = atual.getProximo();
            if (i < this.tamanho - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}