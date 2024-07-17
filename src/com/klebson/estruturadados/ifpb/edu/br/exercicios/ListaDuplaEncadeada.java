/*package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class ListaDuplaEncadeada<T> {

    private NoDuplo<T> inicio;
    private NoDuplo<T> ultimo;
    private int tamanho = 0;

    public ListaDuplaEncadeada() {
        this.inicio = null;
        this.ultimo = null;
    }

    public void adicionaInicio(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        if (this.tamanho == 0) {
            this.inicio = this.ultimo = novoNo;
        } else {
            novoNo.setProximo(this.inicio);
            this.inicio.setAnterior(novoNo);
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    public void adicionaFinal(T elemento) {
        if (this.tamanho == 0) {
            adicionaInicio(elemento);
        } else {
            NoDuplo<T> novoNo = new NoDuplo<>(elemento);
            this.ultimo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimo);
            this.ultimo = novoNo;
            this.tamanho++;
        }
    }

    public void adiciona(int posicao, T elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if (posicao == 0) {
            adicionaInicio(elemento);
        } else if (posicao == tamanho) {
            adicionaFinal(elemento);
        } else {
            NoDuplo<T> nodoAtual = this.inicio;
            for (int i = 0; i < posicao - 1; i++) {
                nodoAtual = nodoAtual.getProximo();
            }
            NoDuplo<T> novoNo = new NoDuplo<>(elemento);
            novoNo.setProximo(nodoAtual.getProximo());
            novoNo.setAnterior(nodoAtual);
            nodoAtual.setProximo(novoNo);
            novoNo.getProximo().setAnterior(novoNo);
            this.tamanho++;
        }
    }

    public T removeInicio() {
        if (this.tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        T elemento = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        if (this.inicio == null) {
            this.ultimo = null;
        } else {
            this.inicio.setAnterior(null);
        }
        this.tamanho--;
        return elemento;
    }

    public T removeFinal() {
        if (this.tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        } else if (this.tamanho == 1) {
            return removeInicio();
        } else {
            T elemento = this.ultimo.getElemento();
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setProximo(null);
            this.tamanho--;
            return elemento;
        }
    }

    public T remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if (posicao == 0) {
            return removeInicio();
        } else if (posicao == tamanho - 1) {
            return removeFinal();
        } else {
            NoDuplo<T> nodoAtual = this.inicio;
            for (int i = 0; i < posicao; i++) {
                nodoAtual = nodoAtual.getProximo();
            }
            T elemento = nodoAtual.getElemento();
            nodoAtual.getAnterior().setProximo(nodoAtual.getProximo());
            nodoAtual.getProximo().setAnterior(nodoAtual.getAnterior());
            this.tamanho--;
            return elemento;
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NoDuplo<T> atual = inicio;
        while (atual != null) {
            sb.append(atual.getElemento().toString());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}
*/
