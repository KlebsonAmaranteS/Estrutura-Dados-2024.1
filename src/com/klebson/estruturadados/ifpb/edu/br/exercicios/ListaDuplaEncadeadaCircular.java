/*package com.klebson.estruturadados.ifpb.edu.br.exercicios;

public class ListaDuplaEncadeadaCircular<T> {

    private NoDuplo<T> inicio;
    private NoDuplo<T> ultimo;
    private int tamanho = 0;

    public ListaDuplaEncadeadaCircular() {
        this.inicio = null;
        this.ultimo = null;
    }

    public void adicionaInicio(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        if (this.tamanho == 0) {
            this.inicio = this.ultimo = novoNo;
            this.inicio.setProximo(this.ultimo);
            this.ultimo.setAnterior(this.inicio);
        } else {
            novoNo.setProximo(this.inicio);
            this.inicio.setAnterior(novoNo);
            this.inicio = novoNo;
        }
        this.inicio.setAnterior(this.ultimo); 
        this.ultimo.setProximo(this.inicio); 
        this.tamanho++;
    }

    public void adicionaFinal(T elemento) {
        if (this.tamanho == 0) {
            adicionaInicio(elemento);
        } else {
            NoDuplo<T> novoNo = new NoDuplo<>(elemento);
            novoNo.setAnterior(this.ultimo);
            this.ultimo.setProximo(novoNo);
            this.ultimo = novoNo;
            this.ultimo.setProximo(this.inicio); 
            this.inicio.setAnterior(this.ultimo); 
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
        if (this.tamanho == 1) {
            this.inicio = this.ultimo = null;
        } else {
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(this.ultimo);
            this.ultimo.setProximo(this.inicio);
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
            this.ultimo.setProximo(this.inicio);
            this.inicio.setAnterior(this.ultimo);
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
        if (this.tamanho == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        NoDuplo<T> atual = inicio;
        for (int i = 0; i < tamanho; i++) {
            sb.append(atual.getElemento().toString());
            if (i < tamanho - 1) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}*/
